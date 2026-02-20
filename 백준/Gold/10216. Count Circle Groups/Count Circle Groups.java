import java.io.*;
import java.util.*;

public class Main {

    public static int N;
    public static int[] parent;
    public static int[][] arr; // [i][0]=x, [i][1]=y, [i][2]=r 

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        for (int tc = 0; tc < T; tc++) {
            N = Integer.parseInt(br.readLine());
            parent = new int[N];
            arr = new int[N][3];

            for (int i = 0; i < N; i++) parent[i] = i;

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());

                arr[i][0] = x;
                arr[i][1] = y;
                arr[i][2] = r; 
            }

            // 모든 쌍 비교 후 union
            for (int i = 0; i < N; i++) {
                for (int j = i + 1; j < N; j++) {
                    int dist = calDist(arr[i][0], arr[i][1], arr[j][0], arr[j][1]);
                    int rSum = arr[i][2] + arr[j][2];
                    int rSum2 = rSum * rSum;

                    if (dist <= rSum2) {
                        union(i, j);
                    }
                }
            }

            
            HashSet<Integer> set = new HashSet<>();
            for (int i = 0; i < N; i++) set.add(find(i));
            sb.append(set.size()).append('\n');
        }

        System.out.print(sb.toString());
    }

    public static void union(int a, int b) {
        int ra = find(a);
        int rb = find(b);
        if (ra == rb) return;
        
        if (ra < rb) parent[rb] = ra;
        else parent[ra] = rb;
    }

    public static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    public static int calDist(int x1, int y1, int x2, int y2) {
        int dx = x1 - x2;
        int dy = y1 - y2;
        return dx * dx + dy * dy;
    }
}

//import java.io.*;
//import java.util.*;
//public class Main {
//
//    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//
//
//    }
//
//}