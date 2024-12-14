import java.util.*;
import java.io.*;

public class Main {

    static class Brick {
        int number; // 블록 번호
        int extent; // 면적
        int height; // 높이
        int weight; // 무게

        Brick(int number, int extent, int height, int weight) {
            this.number = number;
            this.extent = extent;
            this.height = height;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 배열로 변경
        Brick[] bricks = new Brick[N+1];
        bricks[0]=new Brick(0,0,0,0);
        // 입력받은 블록 데이터를 배열에 저장
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int extent = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            bricks[i] = new Brick(i, extent, height, weight);
        }

        // 무게순으로 정렬
        Arrays.sort(bricks, (a, b) -> Integer.compare(a.weight, b.weight));

        // dp 배열 생성 (i번째 블록을 가장 아래에 두었을 때의 최대 높이. 처음에는 자기 자신의 높이만)
        int[] dp = new int[N+1];
        dp[0]=0;
        for (int i = 1; i <= N; i++) {
            dp[i] = bricks[i].height;
        }

        // 
        int max=0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= i; j++) {
                if (bricks[i].extent > bricks[j].extent) {// 다음 블록이 자신보다 면적이 작으면 올릴 수 있다.
                	dp[i]=Math.max(dp[i], dp[j]+bricks[i].height);// 지금 i에 쌓인 높이보다, j위에 쌓인 높이 +i의 높이가 크면 교체
                    
                }
            }
            max=Math.max(max, dp[i]);
        }
        
        Stack<Integer> stack=new Stack<>();
        int sub=max;
        
        // dp 배열 출력
//        System.out.println("dp 배열 출력:");
//        for (int i = 1; i <= N; i++) {
//            System.out.println("dp[" + i + "] = " + dp[i]);
//        }
        
//        for(int i=1;i<=N;i++) {
//        	for(int j=1;j<=N;j++) {
//        		//System.out.println("sub: "+sub+" dp["+j+"] : "+dp[j]);
//            	if(sub==dp[j]) {
//            		
//            		stack.add(bricks[j].number);
//            		//System.out.println(stack.peek()+"이 들어감");
//            		sub-=bricks[j].height;
//            		//System.out.println("sub: "+sub);
//            	}
//        	}
//        }
        while(N>0) {
        	if(max==dp[N]) {
        		stack.add(bricks[N].number);
        		max-=bricks[N].height;
        	}
        	N--;
        }
        
        System.out.println(stack.size());
        
        // dp 배열 출력
        while(!stack.isEmpty()) {
        	System.out.println(stack.pop());
        }
    }
}