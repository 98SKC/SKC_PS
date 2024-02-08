import java.io.*;
import java.util.*;

public class Solution {
	static int answer, min, N;
	static int[][] food;


	public static void main(String[] args) throws Exception {
	//	System.setIn(new FileInputStream("res/sample_input (5).txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb=new StringBuilder();
		int T=Integer.parseInt(br.readLine());
		ArrayList<Integer> foodA;
		ArrayList<Integer> foodB;
		for(int tc=1;tc<=T;tc++) {
			answer=Integer.MAX_VALUE;
			N=Integer.parseInt(br.readLine());
			
			
			food=new int[N][N];
			foodA=new ArrayList<>();
			foodB=new ArrayList<>();


	
			for(int i=0;i<N;i++) {
				st=new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					food[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			
			helper(foodA,foodB,0);
			sb.append("#").append(tc).append(" ").append(answer).append("\n");		
		}
		
		System.out.println(sb);
	}
	
    static void helper(ArrayList<Integer> foodA, ArrayList<Integer> foodB,int number) {
        if (number == N) {
            if (foodA.size() == N / 2 && foodB.size() == N / 2) {
                answer = Math.min(answer, calculation(foodA, foodB));
            }
            return;
        
        }

        if (foodA.size() < N / 2) {
            foodA.add(number);
            helper(foodA, foodB, number + 1);
            foodA.remove(foodA.size() - 1);
        }

        foodB.add(number);
        helper(foodA, foodB, number + 1);
        foodB.remove(foodB.size() - 1);
       
    }

    static int calculation(ArrayList<Integer> foodA, ArrayList<Integer> foodB) {
        int start = 0;
        int link = 0;

        for (int i = 0; i < foodA.size(); i++) {
            for (int j = i + 1; j < foodA.size(); j++) {
                int a = foodA.get(i);
                int b = foodA.get(j);
                start += food[a][b] + food[b][a];
            }
        }

        for (int i = 0; i < foodB.size(); i++) {
            for (int j = i + 1; j < foodB.size(); j++) {
                int a = foodB.get(i);
                int b = foodB.get(j);
                link += food[a][b] + food[b][a];
            }
        }

        return Math.abs(start - link);
    }

}