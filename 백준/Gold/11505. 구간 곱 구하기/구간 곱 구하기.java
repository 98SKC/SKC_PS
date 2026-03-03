//import java.io.*;
//import java.util.*;
//
//public class Main{
//
//    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//    }
//}

import java.io.*;
import java.util.*;

//세그먼트 트리의 연습
public class Main {

    public static int N, M, K;
    public static int[] arr;     // 원본 배열(입력값 저장용)
    public static long[] tree;   // 세그먼트 트리(구간 곱 저장용)
    public static final long MOD = 1_000_000_007L;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 수의 개수
        M = Integer.parseInt(st.nextToken()); // 수의 변경 횟수
        K = Integer.parseInt(st.nextToken()); // 구간 곱 쿼리 횟수

        arr = new int[N];

        // 세그먼트 트리는 보통 4*N 정도 잡으면 안전
        tree = new long[N * 4];


        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        /*
         * 1) 트리 빌드(build)
         * - tree[node] = 해당 구간의 곱(mod)
         * - 리프(구간 길이 1)면 arr 값을 넣고
         * - 아니면 왼쪽/오른쪽 구간 곱을 곱해서 저장
         */
        build(1, 0, N - 1);

        int sub = M + K; // 총 명령 개수
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < sub; i++) {
            st = new StringTokenizer(br.readLine());

            int cal = Integer.parseInt(st.nextToken()); // 1: 변경, 2: 구간 곱
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (cal == 1) {
                /*
                 * cal==1: a번째 수를 b로 변경
                 * 문제는 1-based 인덱스(1번째, 2번째...)를 쓰므로
                 * 내부 배열(0-based)로 바꾸면 idx = a-1
                 */
                int idx = a - 1;
                long newValue = b;

                arr[idx] = (int) newValue; // 원본 갱신
                update(1, 0, N - 1, idx, newValue);

            } else {
                /*
                 * cal==2: a부터 b까지 곱 출력
                 * a, b는 1-based이므로 l=a-1, r=b-1 로 변환
                 */
                int left = a - 1;
                int right = b - 1;

                long ans = query(1, 0, N - 1, left, right);
                sb.append(ans).append('\n');
            }
        }

        System.out.print(sb);
    }

    // ===== 세그먼트 트리 빌드 =====
    // node: 현재 노드 번호
    // start~end: 이 node가 담당하는 구간
    public static long build(int node, int start, int end) {
        if (start == end) {
            // 리프 노드: 원소 1개 담당 -> arr[start] 저장
            return tree[node] = arr[start] % MOD;
        }

        int mid = (start + end) / 2;

        // 왼쪽 구간 곱. 인덱스는 지금위치*2
        long leftMul = build(node * 2, start, mid);
        // 오른쪽 구간 곱. 인덱스는 지금위치*2 + 1
        long rightMul = build(node * 2 + 1, mid + 1, end);

        // 부모 노드 = 왼쪽 곱 * 오른쪽 곱 (MOD)
        return tree[node] = (leftMul * rightMul) % MOD;
    }


    // ===== 점 업데이트 ====
    // idx 위치의 값을 newValue로 바꿨을 때, 관련된 노드들을 다시 계산. 세그먼트 트리 구조상 변경된 노드부터 위로 가면 된다. 위에 노드 인덱스는 지금 위치의 /2.
    public static long update(int node, int start, int end, int idx, long newValue) {
        // idx가 현재 구간(start~end) 밖이면 이 노드는 영향 없음 -> 기존값 그대로 반환
        if (idx < start || idx > end) return tree[node];

        if (start == end) {
            // 리프 노드(정확히 idx) 도착 -> 값을 newValue로 교체
            return tree[node] = newValue % MOD;
        }

        int mid = (start + end) / 2;

        // 왼쪽/오른쪽 중 idx가 포함되는 쪽을 타고 내려가며 갱신
        long leftMul = update(node * 2, start, mid, idx, newValue);
        long rightMul = update(node * 2 + 1, mid + 1, end, idx, newValue);

        // 현재 노드도 자식 결과로 다시 계산
        return tree[node] = (leftMul * rightMul) % MOD;
    }

    // ===== 구간 곱 쿼리 =====
    // [left, right] 구간의 곱을 구함
    // 즉 left,right : 구하려는 구간. 트리 노드 번호. start, end : node가 담당하는 배열 구간.
    // 시작을 1부터, 왼쪽은 start와 mid, 오른쪽은 mid+1과 end로 start와 end를 갱신하며 내려감. left,right는 고정  
    public static long query(int node, int start, int end, int left, int right) {


        // 1) 전혀 겹치지 않으면: 곱에 영향 없는 값(항등원 1) 반환
        if (right < start || end < left) return 1L;

        // 2) 현재 구간(start~end)이 완전히 포함되면: 이 node 값 그대로 사용
        if (left <= start && end <= right) return tree[node];

        // 3) 일부만 겹치면: 양쪽 자식으로 내려가서 필요한 부분만 곱함
        int mid = (start + end) / 2;

        long leftMul = query(node * 2, start, mid, left, right);
        long rightMul = query(node * 2 + 1, mid + 1, end, left, right);

        return (leftMul * rightMul) % MOD;
    }
}