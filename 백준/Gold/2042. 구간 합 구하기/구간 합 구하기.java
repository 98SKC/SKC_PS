import java.util.*;
import java.io.*;

public class Main {
	static long[] arr, tree;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());  // 입력 받을 수열의 크기
        int M = Integer.parseInt(st.nextToken());  // 수행할 쿼리의 수
        int K = Integer.parseInt(st.nextToken());  // 수행할 쿼리의 수

        arr = new long[N + 1];  // 입력 수열 저장
        for (int i = 1; i <= N; i++) {
            arr[i] = Long.parseLong(br.readLine());  // 수열의 원소를 읽음
        }

        tree = new long[N * 4];  // 세그먼트 트리를 위한 배열. 최대 4N 크기로 초기화. -> 노드 개수로는 2*n 이내는 맞는데, 인덱스는 4*n까지 봐야함

        init(1, N, 1);  // 세그먼트 트리 초기화

        StringBuilder sb = new StringBuilder();
        int a,b;
        long c,dif;
        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());

            a = Integer.parseInt(st.nextToken());  // 쿼리 유형
            b = Integer.parseInt(st.nextToken());  // 시작 인덱스
            c = Long.parseLong(st.nextToken());  // 끝 인덱스 또는 변경될 값

            if (a == 1) {  // 업데이트 쿼리의 경우
                dif = c - arr[b];  // 변경될 값과 현재 값의 차이 계산
                arr[b] = c;  // 실제 배열의 값을 업데이트
                update(1, N, 1, b, dif);  // 세그먼트 트리를 업데이트
            } else if (a == 2) {  // 구간 합 쿼리의 경우
                sb.append(sum(1, N, 1, b, (int) c) + "\n");  // 구간 합을 계산하여 결과를 변경
            }
        }
        System.out.println(sb);

    }

    // 세그먼트 트리 초기화 함수
    public static long init(int start, int end, int node) {// start, end는 arr의 idx 범위. node는 tree의 idx.
        if (start == end) {
            return tree[node] = arr[start];  // 리프 노드
        }

        int mid = (start + end) / 2;  // 중간 지점 계산
        return tree[node] = init(start, mid, node * 2) + init(mid + 1, end, node * 2 + 1);  // 왼쪽과 오른쪽 자식을 재귀적으로 초기화하고, 그 합을 저장
    }

    // 구간 합을 구하는 함수
    public static long sum(int start, int end, int node, int left, int right) {
        if (left > end || right < start) {
            return 0;  // 쿼리 범위 밖인 경우
        }

        if (left <= start && end <= right) {
            return tree[node];  // 쿼리 범위 내인 경우
        }

        int mid = (start + end) / 2;  // 중간 지점 계산
        return sum(start, mid, node * 2, left, right) + sum(mid + 1, end, node * 2 + 1, left, right);  // 왼쪽과 오른쪽 자식에서의 구간 합을 재귀적으로 계산
    }

    // 특정 원소를 업데이트하는 함수, start 와 end 사이의 idx가 포함된 범위인지 확인
    /*
          1
     2          3 
  4    5    6       7
8  9 10 11 12 13  14 15
1  2 3  4  5  6   7  8
      
      idx=5의 경우 처음 1~8 사이에 5가 있기에 node 1이 변경
      update가 1~4, 5~8로 재귀를 호출하며 node가 각각 2, 3으로 들어감
      1~4의 범위인 node2의 경우 5가 1~4 밖에 있으니 return. 좌측은 탐색이 끝난닷
      5~8은 5가 속해있으니 idx3은 변경. 5~6, 7~8이 node 6, 7로 들어감
      5~6은 5가 포함되어 idx 6이 변경. 7~8은 idx 5가 미포함이기에 변경 x
      
     
     * */
    public static void update(int start, int end, int node, int idx, long dif) {// dif=변경된 값과 원래 값의 차이
        if (idx < start || idx > end) {
            return;  // 업데이트 범위 밖인 경우
        }

        tree[node] += dif;  // 현재 노드에 차이를 반영
        if (start != end) {
            int mid = (start + end) / 2;  // 중간 지점 계산
            update(start, mid, node * 2, idx, dif);  // 왼쪽 자식을 업데이트
            update(mid + 1, end, node * 2 + 1, idx, dif);  // 오른쪽 자식을 업데이트
        }
    }
}