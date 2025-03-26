
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N=Long.parseLong(br.readLine());
        
        StringTokenizer st=new StringTokenizer(br.readLine());
        
        //주사위 A B C D E F가 순서대로. A-F, B-E, C-D, 가 마주본다
        int[] dice=new int[6];
        for(int i=0;i<6;i++) {
        	dice[i]=Integer.parseInt(st.nextToken());
        }
		// 0-1-
        
        //N^3개의 주사위로 정육면체를 만듬. 이 육면체의 보이는 5면의 숫자의 합이 최소인 경우
        
        //한면에 N^2개의 숫자가. 이런 면이 5개.
        
        //웃기긴한데 이렇게 푸는게 과연 올바른 것인가???????????? 생각난김에 해보는데 빠르기는 제일 빠르긴 하겠네
        //근데 주사위를 거꾸로 돌려도 되는건가. 되겠지. (n-1) 면은 그냥 가장 작은 주사위 값으로
        //N
        /*
         * 2 1 1 1 1 2
         * 1 0 0 0 0 1
         * 1 0 0 0 0 1
         * 1 0 0 0 0 1
         * 1 0 0 0 0 1
         * 1 0 0 0 0 1
         * 
         * 0 0 0
         * 1 0 1
         * 1 1 1
         * */
        //N이 6일 때. 4*(N-1)+4*(N-2)는 붙어있는 두 면의 합이 가장 작은 경우로
        //4는 붙어있는 세 면이 가장 작은 경우
        //나머지는 모두 가장 작은 수
        
        // 만약 N이 1이라면 가장 큰 수를 제거한 합.
        // N이 2라면 두면의 합이 가장 작은 4, 세면의 합이 가장 작은 4
        // N이 3 이상이라면
        long minDb=Integer.MAX_VALUE;
        long minTp=Integer.MAX_VALUE;
        long min=Integer.MAX_VALUE;
        long answer=0;
        
        if(N==1) {
        	long max=0;
        	long sum=0;
        	for(int m:dice){
        		max=Math.max(max, m);
        		sum+=m;
        	}
        	answer=sum-max;
        }else if(N==2){
        	//A-B, A-C, A-D, A-E, F-B, F-C, F-D, F-E, E-D, E-C, B-D, B-C 
        	//0-1, 0-2, 0-3, 0-4, 5-1, 5-2, 5-3, 5-4, 4-3, 4-2, 1-3, 1-2
        	for(int m:dice) {
            	min=Math.min(m, min);
            }
        	int[] db=new int[]{	dice[0]+dice[1],
        						dice[0]+dice[2],
        						dice[0]+dice[3],
        						dice[0]+dice[4],
        						dice[5]+dice[1],
        						dice[5]+dice[2],
        						dice[5]+dice[3],
        						dice[5]+dice[4],
        						dice[4]+dice[3],
        						dice[4]+dice[2],
        						dice[1]+dice[3],
        						dice[1]+dice[2]};
        	for(int m:db) {
        		minDb=Math.min(minDb, m);
        	}
        	//A-B-C, A-C-E, A-E-D, A-E-B, F-B-C, F-C-E, F-E-D, F-E-B 
        	//0-1-2, 0-2-4, 0-4-3, 0-3-1, 5-1-2, 5-2-4, 5-4-3, 5-3-1
        	int[] tp=new int[] {dice[0]+dice[1]+dice[2],
        						dice[0]+dice[2]+dice[4],
        						dice[0]+dice[4]+dice[3],
        						dice[0]+dice[3]+dice[1],
        						dice[5]+dice[2]+dice[4],
        						dice[5]+dice[4]+dice[3],
        						dice[5]+dice[1]+dice[2],
        						dice[5]+dice[3]+dice[1]};
        	for(int m:tp) {
        		minTp=Math.min(minTp, m);
        	}
        	answer=4*minDb;
        	answer+=4*minTp;
        	
        }else {
        	//A-B, A-C, A-D, A-E, F-B, F-C, F-D, F-E, E-D, E-C, B-D, B-C 
        	//0-1, 0-2, 0-3, 0-4, 5-1, 5-2, 5-3, 5-4, 4-3, 4-2, 1-3, 1-2
        	for(int m:dice) {
            	min=Math.min(m, min);
            }
        	int[] db=new int[]{	dice[0]+dice[1],
        						dice[0]+dice[2],
        						dice[0]+dice[3],
        						dice[0]+dice[4],
        						dice[5]+dice[1],
        						dice[5]+dice[2],
        						dice[5]+dice[3],
        						dice[5]+dice[4],
        						dice[4]+dice[3],
        						dice[4]+dice[2],
        						dice[1]+dice[3],
        						dice[1]+dice[2]};
        	for(int m:db) {
        		minDb=Math.min(minDb, m);
        	}
        	//A-B-C, A-C-E, A-E-D, A-D-B, F-B-C, F-C-E, F-E-D, F-D-B 
        	//0-1-2, 0-2-4, 0-4-3, 0-3-1, 5-1-2, 5-2-4, 5-4-3, 5-3-1
        	int[] tp=new int[] {dice[0]+dice[1]+dice[2],
        						dice[0]+dice[2]+dice[4],
        						dice[0]+dice[4]+dice[3],
        						dice[0]+dice[3]+dice[1],
        						dice[5]+dice[2]+dice[4],
        						dice[5]+dice[4]+dice[3],
        						dice[5]+dice[1]+dice[2],
        						dice[5]+dice[3]+dice[1]};
        	for(int m:tp) {
        		minTp=Math.min(minTp, m);
        	}
        	
            //N이 6일 때. 4*(N-1)+4*(N-2)는 붙어있는 두 면의 합이 가장 작은 경우로
            //4는 붙어있는 세 면이 가장 작은 경우
            //나머지는 모두 가장 작은 수
        	
        	answer = minDb * (4L * (N - 1) + 4L * (N - 2));
        	answer += minTp * 4L;
        	answer += (N - 2) * (N - 1) * 4L * min;
        	answer += (N - 2) * (N - 2) * min;
        	
        }
        System.out.println(answer);
//        System.out.println("250000000000000");
    }
}
