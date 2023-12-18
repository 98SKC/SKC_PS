import java.io.*;
import java.util.*;
import java.util.zip.InflaterInputStream;


public class Main {

	public static void main(String[] args) throws IOException{
	
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	//ArrayList<Integer> list=new ArrayList<>();// ArrayList로 구현할 경으 remove의 시간복잡도가 O(n)이라서 시간초과가 일어남.
	LinkedList<Integer> list = new LinkedList<>();
	int N=Integer.parseInt(br.readLine());
	String str="";
	StringBuilder sb=new StringBuilder();// 여전히 시간초과가 일어나서 sb를 사용해보도록 한다.
	
	
	for(int i=0;i<N;i++) {
		StringTokenizer st=new StringTokenizer(br.readLine());	
		str=st.nextToken();
	
		switch (str) {
		case "push":
			list.add(Integer.parseInt(st.nextToken()));
			break;

		case "pop":
			if (!list.isEmpty()) {
               // System.out.println(list.remove(0)); // 이것도 가능은 하나, 가독성 면에서 아래쪽 메서드가 좋다고 한다.
               // System.out.println(list.removeFirst());
                sb.append(list.removeFirst()).append("\n");
            } else {
                //System.out.println(-1);
            	sb.append(-1).append("\n");
            }
			break;
		case "size":
			//System.out.println(list.size());
			sb.append(list.size()).append("\n");
			break;
			
		case "empty":
			if(list.size()==0) {
				//System.out.println(1);
				sb.append(1).append("\n");
			}else {
				//System.out.println(0);
				sb.append(0).append("\n");
			}
			break;
		case "front":
			if(list.size()!=0) {
				//System.out.println(list.get(0));// 이것도 가능은 하나, 가독성 면에서 아래쪽 메서드가 좋다고 한다.
				//System.out.println(list.getFirst());
				sb.append(list.getFirst()).append("\n");
			}else {
				//System.out.println(-1);
				sb.append(-1).append("\n");
			}
			break;
			
		case "back":
			if(list.size()!=0) {
				//System.out.println(list.get(list.size()-1));// 이것도 가능은 하나, 가독성 면에서 아래쪽 메서드가 좋다고 한다.
				//System.out.println(list.getLast());
				sb.append(list.getLast()).append("\n");
			}else {
				//System.out.println(-1);
				sb.append(-1).append("\n");
			}
			break;
		}
	
	
	}
	
	
		System.out.println(sb);
		
	}

}