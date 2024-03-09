import java.util.*;
import java.io.*;
import java.nio.BufferOverflowException;


public class Main {

    static int[] arr;
    static boolean[] check;

    public static final int INF = Integer.MAX_VALUE;


    static int N, M;
    static int D=10000;
    static ArrayList<Node>[] list;
    static int[] dp;
    public static void main(String[] args)throws IOException {
        int i, j, z, t;
        StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dp = new int[M + 1];
        list = new ArrayList[M + 1];
        for (i = 0; i <= M; i++) {
            list[i] = new ArrayList<>();
        }

        for (i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            if (end > M)
                continue;

            list[end].add(new Node(start, weight));
        }

        for (i = 1; i <= M; i++) {
            dp[i] = dp[i - 1]+1;
            for (Node node : list[i]) {
            	dp[i]=Math.min(dp[i], dp[node.end] + node.weight);
            }
        }
        
        System.out.println(dp[M]);
    }

}

class Node implements Comparable<Node> {
    int end;
    int weight;

    Node(int end, int weight) {
        this.end = end;
        this.weight = weight;
    }

    @Override
        public int compareTo(Node o) {
        // TODO Auto-generated method stub
        return weight - o.weight;
    }
}