import java.io.*;
import java.util.*;

public class Main {   
  	static int N;
  	static int M;
  	static int[] parent;
  	
  	public static void main(String[] args) throws Exception {
  		
  		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
  		
  		N = Integer.parseInt(br.readLine());
  		M = Integer.parseInt(br.readLine());
  		int count = 0;
  		StringTokenizer st;
  		parent = new int[N + 1];
  		for (int i = 1; i <= N; i++) parent[i] = i;
  		
  		while (M> 0) {
  			st=new StringTokenizer(br.readLine());
  			int x = Integer.parseInt(st.nextToken());
  			int y = Integer.parseInt(st.nextToken());
  			union(x, y);
  			M--;
  		}

  		
  		int root = find(1);
  		for (int i = 2; i <= N; i++) if (find(i) == root) count++;
  		System.out.println(count);

  	}

  	public static int find(int x) {

  		if (x == parent[x]) return x;
  		int root = find(parent[x]);
  		parent[x] = root;
  		return root;

  	}


  	public static void union(int x, int y) {
  		x = find(x);
  		y = find(y);
  		if (x != y)
  			parent[y] = x;
  	}
 }