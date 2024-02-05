import java.util.*;
import java.io.*;



public class Solution {

	public static void main(String[] args) throws Exception{
	//	System.setIn(new FileInputStream("res/input (3).txt"));
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		StringTokenizer st;
		for(int tc=1;tc<=10;tc++) {
			int N=Integer.parseInt(br.readLine());

			int[] arr=new int[N];

			LinkedList<String> list=new LinkedList<>();
			LinkedList<String> subList;
			st=new StringTokenizer(br.readLine());

			//원본 암호문 받기
			for(int i=0;i<N;i++) {
				
				list.add(st.nextToken());

			}										
			//명령어의 개수
			int M=Integer.parseInt(br.readLine()); 

			st=new StringTokenizer(br.readLine());// 4번째야 하는데?
			for(int i=0;i<M;i++) {// 명령어 실행
				//명령어 받기.
				subList=new LinkedList<>();
				String garb=st.nextToken();// I
				
				// 여기에 i다음꺼 출력해보자ㅣ.
				
				int head=Integer.parseInt(st.nextToken());// 어디 뒤에 붙일 것인지

				int number=Integer.parseInt(st.nextToken());

				for(int j=0;j<number;j++) {//st.countTokens()-2 인지, 그냥인지 애매
					subList.add(st.nextToken());
				}// 연결할 sub리스트
				list.addAll(head, subList);// head뒤에 sublist를 붙인다.
			}
			sb.append("#").append(tc).append(" ");
			for(int i=0;i<10;i++) {
				sb.append(list.get(i)).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}


}