import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
        int sub;
		
		ArrayList<Integer> list = new ArrayList<>();
	
		for(int i = 0; i < N; i++) {
            sub=Integer.parseInt(br.readLine());
			list.add(sub);
		}
		
		Collections.sort(list);

		for(Integer c : list) {
			sb.append(c).append("\n");
		}
		
		System.out.println(sb);
	}
}