import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
 
	
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int N=Integer.parseInt(br.readLine());
		int [][] arr=new int[N][2];
		//StringTokenizer st=new StringTokenizer(br.readLine());
		String[] str;
		
		for(int i=0;i<N;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			arr[i][0]=Integer.parseInt(st.nextToken());
			arr[i][1]=Integer.parseInt(st.nextToken());
		}
		
		//정렬: Arrays.sort의 오버라이드
		/*
		 *  Arrays.sort(정렬할 배열, Comparator 인터페이스의 익명 클래스 생성 부분)
		 *  Comparator 인터페이스의 익명 클래스 생성:  이 클래스는 compare 메서드를 오버라이드하여 두 배열 요소를 비교하는 로직을 정의
		 *  여기에서는 int[] 타입의 두 객체를 비교
		 *  public int compare(o1, o2): 이 메서드는 두 배열 요소 o1과 o2를 비교하여 정렬 순서를 결정
		 *  int[] o1, int[] o2: int[] 타입의 배열, 즉 정수 배열을 비교 대상.o1과 o2는 2차원 배열 arr의 각 행을 가리킨다
		 *  if(o1[0] == o2[0]) return o1[1] - o2[1];: 만약 두 배열 요소의 첫 번째 원소가 같다면, 두 번째 원소를 비교합니다.
		 *  o1[1] - o2[1] 결과는 다음과 같다/
		 *  양수: o1이 o2보다 크다는 의미이므로, o1이 o2 뒤에 오도록 정렬됩니다.
		 *	0: o1과 o2가 같다는 의미이므로, 정렬 순서는 변하지 않습니다.
		 *	음수: o1이 o2보다 작다는 의미이므로, o1이 o2 앞에 오도록 정렬됩니다.
		 *  else return o1[0] - o2[0];: 두 배열 요소의 첫 번째 원소가 다르다면, 첫 번째 원소를 기준으로 정렬합니다. 방식은 위와 동일
		 * */
		Arrays.sort(arr,new Comparator<int[]>() {
			@Override
			public int compare(int[]o1,int[]o2) {
				if(o1[0]==o2[0]) return o1[1]-o2[1];
				else return o1[0]-o2[0];
			}
		});
		
	
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<N;i++) {
			sb.append(arr[i][0]).append(" ").append(arr[i][1]).append("\n");
		}
		System.out.println(sb);
	}
}