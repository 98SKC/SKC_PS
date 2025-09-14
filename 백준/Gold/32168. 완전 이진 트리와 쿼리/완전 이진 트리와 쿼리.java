
import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int Q;
    static int root = 1;
    static long total;     

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        total = sumRange(1, N); // 전체 합

        StringBuilder sb = new StringBuilder();
        for(int i=1;i<=Q;i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            if (t == 1) {
                root = v; // 루트 변경
            } else {
            	
                // 쿼리 2: 현재 루트 기준에서 v의 서브트리 합
                int rel = searchDir(root, v); 
                // 0: v의 서브트리 밖
                //-1: v의 왼쪽 가지로 내려감
                //+1: 오른쪽 가지
                //2: root==v
                
                long ans;
                if (rel == 2) {
                    ans = total;
                } else if (rel == 0) {
                    ans = sumSubtree(v);
                } else if (rel == -1) {
                    // 루트가 v의 왼쪽 서브트리 쪽에 있음 → 전체 - 왼쪽자식 서브트리
                    ans = total - sumSubtree(2 * v);
                } else {
                    // 루트가 v의 오른쪽 서브트리 쪽에 있음 → 전체 - 오른쪽자식 서브트리
                    ans = total - sumSubtree(2 * v + 1);
                }
                sb.append(ans).append('\n');
            }
        }
        System.out.print(sb.toString());
    }

    // root가 v의 서브트리 안에 있는지, 그리고 어느 방향으로 내려가는지 방향을 탐지.
    // 반환값: 2(=root==v), -1(왼쪽으로 내려감), +1(오른쪽), 0(서브트리 밖)
    static int searchDir(int root, long v) {
        if (root == v) return 2;
        int cur = root;
        while (cur > 1) {
            int p = cur / 2;
            if (p == v) return (cur == 2 * v ? -1 : +1);
            cur = p;
        }
        return 0;
    }

    // v의 서브트리 합
    // 각 레벨에서 좌우 구간을 더해가며 찾기
    static long sumSubtree(int v) {
        if (v > N) return 0;
        long sum = 0;
        long L = v, R = v;
        while (L <= N) {
            long rr = Math.min(R, N);
            sum += sumRange(L, rr);
            L <<= 1;
            R = (R << 1) + 1;
        }
        return sum;
    }

    // 구간합 등차수열의 공식 (a..b) = (b-a+1)*(a+b)/2 
    static long sumRange(long a, long b) {
        if (a > b) return 0;
        long cnt = b - a + 1;
        long s = a + b;
        if ((cnt & 1L) == 0) cnt >>= 1; else s >>= 1; //둘중 짝수에게 2를 먼저 나눠줌
        return cnt * s;
    }
}
