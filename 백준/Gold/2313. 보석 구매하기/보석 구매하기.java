import java.io.*;
import java.util.*;

public class Main{
	public static int N;
	public static int[] line;
	public static int[] prefix;
	public static int len;
	public static List<Integer> list=new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        //여러개의 보석이 진열. 각 보석에 대한 가치가 있다.
        //음수의 가치 또한 존재.
        //보석이 N개의 줄에 나열. 각 줄에서 몇개의 보석을 구매.
        //구매할 때 연속적인 보석들을 구매해야만 한다.
        //구매하는 보석의 가치의 총 합이 최대가 되도록 하라.
        //같은 가치가 여러개면 보석 개수가 적은 것. 이 또한 여러개면
        //출력할 수들을 하나의 수열로 치환할 때, 사전식으로 가장 앞에오는 것
        
        
        /*
         * 떠오르는 것
         * 1. 누적합
         * 2. 또 다른 dp
         * 3. 조합과 누적합? 1000C2 *1000. 500000000 5억 연산.X
         * 일단 1000*???이고
         * ???이 한 라인에서 첫점, 끝점을 선택하는 알고리즘.
         * 1초내로 되려면 100000. 1000크기니 n^2은 걸릴 수 없고...N까지는 가능
         * 
         * 누적합이 가장 큰 부분과 가장 작은 부분을 빼기?
         * 로 구하고 있었는데 그냥 매 순간 누적합을 다시할지 말지 고르는게 더 짧아보임
         * 다 풀고 찾아보니 kadena 알고리즘이라는 것으로 최적화 가능하다길래 적용해보았다.
          * */
        
        
        //10000*1000*1000=10000000000
        long answer=0;
        StringBuilder sb=new StringBuilder();

        
        N = Integer.parseInt(br.readLine());

        for(int i=0;i<N;i++) {
        	len=Integer.parseInt(br.readLine());
        	st = new StringTokenizer(br.readLine());
        	line=new int[len+1];//
        	prefix=new int[len+1];
        	list.clear();

        	// 입력과 동시에 처리 
        	long currSum=0;   // 현재 구간 합
        	int currL=1;   // 현재 구간 시작

        	long bestSum=-1000001; // 최적 합
        	int bestL=1; 
        	int bestR=1;   // 최적 구간 [bestL..bestR]

        	for(int j=1;j<=len;j++) {
        		line[j]=Integer.parseInt(st.nextToken());

        		// 이어갈지, 새로 시작할지
        		if (line[j] >= currSum + line[j]) {
        			currSum = line[j];
        			currL   = j;
        		} else {
        			currSum += line[j];
        		}

        		prefix[j] = (int)currSum; // 연속합(dp) 기록

        		int currR = j;

        		// 최적 교체: 합 , 길이(개수 적은게 우선) ,시작작음 , 끝작음
        		if (currSum > bestSum) {
        			bestSum = currSum; bestL = currL; bestR = currR;
        		} else if (currSum == bestSum) {
        			int currLen = currR - currL;
        			int bestLen = bestR - bestL;
        			if (currLen < bestLen) {
        				bestL = currL; bestR = currR;
        			} else if (currLen == bestLen) {
        				if (currL < bestL || (currL == bestL && currR < bestR)) {
        					bestL = currL; bestR = currR;
        				}
        			}
        		}
        	}
        	// 결과 누적
        	answer += bestSum;
        	sb.append(bestL).append(' ').append(bestR).append('\n');
        }
        
        System.out.println(answer);
        System.out.print(sb);
    }

}
