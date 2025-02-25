import java.io.*;
import java.util.*;

public class Main {

	
	
	
	public static void main(String[] args) throws Exception{
		
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		int N=Integer.parseInt(br.readLine());
		StringTokenizer st=new StringTokenizer(br.readLine());

		//int[] arrA=new int[N+1];
		ArrayList<Integer> list=new ArrayList<>();
		HashMap<Integer,Integer> map=new HashMap<>();
		int sub=0;
		int[] preSumA=new int[N+1];
		for(int i=1;i<=N;i++) { 
			
			preSumA[i]=preSumA[i-1]+Integer.parseInt(st.nextToken());
		}
		
		for(int i=0;i<N;i++) {
			sub=preSumA[i];//i+1를 무조건 포함할 때
			//System.out.println((i+1)+"을 포함할 때");
			for(int j=i+1;j<=N;j++) {
				sub=preSumA[j]-preSumA[i];
				//System.out.println("현 누적합: "+sub);
				//System.out.println("들어있는 누적합: "+map.toString());
//				list.clear();
//				
//				for(Integer s:map.keySet()) {
//					list.add(s+sub);
//				}
//				list.add(sub);
//				for(Integer p:list) {
//					map.put(p, map.getOrDefault(p, 0)+1);
//				}
				map.put(sub, map.getOrDefault(sub, 0)+1);
				//System.out.println("이번 최종 누적합: "+map.toString());
				//System.out.println();
			}
			//System.out.println("------------------------");
		}
		
		//System.out.println("첫번째 누적합 합: "+map.toString());
		
		int M=Integer.parseInt(br.readLine());
		int[] preSumB=new int[M+1];
		st=new StringTokenizer(br.readLine());

		HashMap<Integer,Integer> map2=new HashMap<>();

		for(int i=1;i<=M;i++) {
			preSumB[i]=preSumB[i-1]+Integer.parseInt(st.nextToken());
		}
		
		for(int i=0;i<M;i++) {
			sub=preSumB[i];
			for(int j=i+1;j<=M;j++) {

				sub=preSumB[j]-preSumB[i];
				//System.out.println("현 누적합: "+sub);
				//System.out.println("들어있는 누적합: "+map2.toString());

//				System.out.println("이번 최종 누적합: "+map.toString());
//				System.out.println();
				map2.put(sub, map2.getOrDefault(sub, 0)+1);
				//System.out.println("이번 최종 누적합: "+map2.toString());
			}
			
		}
		//System.out.println("두번째 누적합 합: "+map2.toString());
		//int answer=0;// 
		long answer=0;
		//
		for(Integer s:map.keySet()) {
			///System.out.println(s+" 와 쌍: "+(T-s));
			//System.out.println(map.get(s)+" "+map2.getOrDefault(T-s, 0)+" :"+(map.get(s)*map2.getOrDefault(T-s, 0)));
			answer += (long) map.get(s) * map2.getOrDefault(T-s, 0);
			//answer+= map.get(s) * map2.getOrDefault(T-s, 0);

		}

		
		
		//System.out.println(map.toString());
		//System.out.println(map2.toString());
		
		//System.out.println(map.size()+" "+map2.size());
		System.out.println(answer);

		
		
	}
	
	
}