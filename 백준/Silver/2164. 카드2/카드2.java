import java.io.*;
import java.util.*;
import java.util.zip.InflaterInputStream;


public class Main {

	public static void main(String[] args) throws IOException{
	
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	
	Queue<Integer> queue=new LinkedList<>();
	
	int N=Integer.parseInt(br.readLine());
	
	for(int i=1;i<=N;i++) {
		queue.add(i);
		
	}
	
	while(queue.size()>1) {
		queue.poll();
		queue.add(queue.poll());
	}
	System.out.println(queue.poll());
	}

}