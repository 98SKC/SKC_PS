import java.io.*;
import java.util.*;
import java.util.zip.InflaterInputStream;

//풀이 1. 배열 앞부터, 뒤를 비교해가며 자기보다 작은 수를 직접 세가며 배열을 생성. n+(n+1)+(n+2)...-> 시간복잡도 O(n^2)
//풀이 2. HashMap을 사용해서 배열을 만들때, 배열을 미리 복사. Arrays.sort 한 후에 배열 원소 위치를 map에 저장. 복사된 배열을 탐색하면서, 배열 값을 키로  map의 값을 불러옴.
//-> 풀이 2는 공간복잡도도 시간복잡도도 클 것 같다.

public class Main {
	

	//map이용 해볼까
	public static void main(String[] args) throws IOException {
 
	     int count=-1;
		 BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		 StringBuilder sb=new StringBuilder();
		 HashMap<Integer,Integer> map=new HashMap<>();
		 
		 int N=Integer.parseInt(br.readLine());
		 int[] sub=new int[N];
		 int[] arr=new int[N];
		 StringTokenizer st=new StringTokenizer(br.readLine());
		 
		 for(int i=0;i<N;i++) {
			 arr[i]=Integer.parseInt(st.nextToken());
			 sub[i]=arr[i];
			 
		 }
	 
		 Arrays.sort(arr);

		 for(int i=0;i<N;i++) {
			 if(map.containsKey(arr[i])) continue;
			 count++;			 
			 map.put(arr[i], count);
		 }
		 for(int i=0;i<N;i++) {
			 sb.append(map.get(sub[i])).append(" ");
		 }
		 
		 System.out.println(sb);


	}
}