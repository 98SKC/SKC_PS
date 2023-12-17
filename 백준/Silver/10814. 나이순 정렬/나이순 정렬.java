import java.io.*;
import java.util.*;


public class Main {
	// 객체를 사용해서 Arrays.Sort Override를 한번 해보자.
	public static class object{
		
		int age;
		String name;		
		public object(int age,String name) {
			this.age=age;
			this.name=name;
		}
		
	}
	public static void main(String[] args) throws IOException {
 
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		
		int N=Integer.parseInt(br.readLine());
		object[] ob=new object[N];
		
		for(int i=0;i<N;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			
			int age=Integer.parseInt(st.nextToken());
			String name=st.nextToken();
			
			ob[i]=new object(age, name);
		}
		
		
		Arrays.sort(ob, new Comparator<object>() {
			
			@Override
			public int compare(object o1,object o2) {
			
				if(o1.age==o2.age) {
					return 0;// 이 부분을 어떻게 해야할까?-> 원래 배열에 들어온 순서대로 이미 정렬되어 있기 때문에 0을 반환
				}else {
					return Integer.compare(o1.age,o2.age);//Integer.compare는 오버플로우나 언더플로우를 방지하는 장점
					//return o1.age-o2.age;
				}
				
			}
			
		});
		
		for(object o:ob) {
			sb.append(o.age).append(" ").append(o.name).append("\n");
		}
		System.out.println(sb);

	}
}