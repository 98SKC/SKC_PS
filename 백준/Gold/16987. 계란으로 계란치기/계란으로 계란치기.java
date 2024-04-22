import java.util.*;
import java.io.*;

public class Main {
	static class Egg {
		int hp, weight;

		public Egg(int hp, int weight) {
			this.hp = hp;
			this.weight = weight;
		}
	}
	static Egg[] egg;
	//static boolean[] check;
	static int N;
	static int answer=0;
	static boolean find;
	 public static void main(String[] args) throws Exception {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        N = Integer.parseInt(br.readLine());
	        StringTokenizer st;
	        egg = new Egg[N];
	       // check = new boolean[N];

	        for (int i = 0; i < N; i++) {
	            st = new StringTokenizer(br.readLine());
	            egg[i] = new Egg(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

	        }

	        backtrack(0,0);
	        System.out.println(answer);
	    }

	    static void backtrack(int pos, int broken) {
	    	if ((N - pos)*2 + broken<= answer) return;
	    	answer = Math.max(answer, broken);
	    	if (pos == N) return;
	        
	       // if (check[pos]) {
	    	if (egg[pos].hp <= 0) {
	            backtrack(pos + 1,broken);  // 현재 계란이 이미 깨졌다면 다음 계란으로
	        } else {
	            boolean isHit = false;
	            for (int i = 0; i < N; i++) {
	                if (i == pos || egg[i].hp <= 0) continue;
	                    isHit = true;
	                    int cnt=0;
	                    // 계란을 서로 치기
	                    egg[pos].hp -= egg[i].weight;
	                    egg[i].hp -= egg[pos].weight;

	                    if (egg[pos].hp <= 0) {
	                    	//check[pos] = true;
	                    	cnt+=1;
	                    } 
	                    if (egg[i].hp <= 0) {
	                    	//check[i] = true;
	                    	cnt+=1;
	                    } 
	                    backtrack(pos + 1,broken+cnt);
	                    // 원상 복구
	                   // check[pos] = false;
	                   // check[i] = false;
	                    egg[pos].hp += egg[i].weight;
	                    egg[i].hp += egg[pos].weight;
	                
	            }
	            if (!isHit) {  // 다른 계란을 치지 못했다면 다음 계란으로
	                backtrack(pos + 1,broken);
	            }
	        }
	    }
	}