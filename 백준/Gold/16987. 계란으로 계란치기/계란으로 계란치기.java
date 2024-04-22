import java.util.*;
import java.io.*;

public class Main {

	static int[][] egg;
	static boolean[] check;
	static int N;
	static int answer=0;
	static boolean find;
	 public static void main(String[] args) throws Exception {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        N = Integer.parseInt(br.readLine());
	        StringTokenizer st;
	        egg = new int[N][2];
	        check = new boolean[N];

	        for (int i = 0; i < N; i++) {
	            st = new StringTokenizer(br.readLine());
	            egg[i][0] = Integer.parseInt(st.nextToken()); // 내구도
	            egg[i][1] = Integer.parseInt(st.nextToken()); // 무게
	        }

	        backtrack(0);
	        System.out.println(answer);
	    }

	    static void backtrack(int pos) {
	        if (pos == N) {
	            int count = 0;
	            for (boolean b : check) if (b) count++;
	            answer = Math.max(answer, count);
	            return;
	        }

	        if (check[pos]) {
	            backtrack(pos + 1);  // 현재 계란이 이미 깨졌다면 다음 계란으로
	        } else {
	            boolean isHit = false;
	            for (int i = 0; i < N; i++) {
	                if (i != pos && !check[i]) {
	                    isHit = true;
	                    // 계란을 서로 치기
	                    egg[pos][0] -= egg[i][1];
	                    egg[i][0] -= egg[pos][1];

	                    if (egg[pos][0] <= 0) check[pos] = true;
	                    if (egg[i][0] <= 0) check[i] = true;

	                    backtrack(pos + 1);

	                    // 원상 복구
	                    if (egg[pos][0] <= 0) check[pos] = false;
	                    if (egg[i][0] <= 0) check[i] = false;
	                    egg[pos][0] += egg[i][1];
	                    egg[i][0] += egg[pos][1];
	                }
	            }
	            if (!isHit) {  // 다른 계란을 치지 못했다면 다음 계란으로
	                backtrack(pos + 1);
	            }
	        }
	    }
	}