import java.util.*;
import java.io.*;

public class Main {

	static int[][] parent;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int T=Integer.parseInt(br.readLine());
        int N;
        HashMap<String,Integer> map;
        
        
        for(int test_case=1;test_case<=T;test_case++) {
        	N=Integer.parseInt(br.readLine());
        	map=new HashMap<String, Integer>();
        	parent=new int[N*2][2]; // 0은 부모, 1은 그 집합의 총 크기
        	int cnt=0;
        	int sum=0;
        	for(int i=0;i<N;i++) {
        		String[] name=br.readLine().split(" ");
        		if(!map.containsKey(name[0])) {
        			map.put(name[0],cnt++);
        			parent[map.get(name[0])][1]=1;
        			parent[map.get(name[0])][0]=map.get(name[0]);
        		} 
        		if(!map.containsKey(name[1])) {
        			map.put(name[1],cnt++);
        			parent[map.get(name[1])][1]=1;
        			parent[map.get(name[1])][0]=map.get(name[1]);
        			
        		} 
        		
//        		System.out.println("map.get(name[0]): "+map.get(name[0]));
        		int fir=find(map.get(name[0]));
//        		System.out.println("map.get(name[1]): "+map.get(name[1]));
        		int sec=find(map.get(name[1]));
        		if(fir==sec) {// 부모가 같으면
        			sb.append(parent[fir][1]+"\n");
        		}else {
        			sum=parent[fir][1]+parent[sec][1];
        			if(parent[fir][1]>parent[sec][1]){// 왼쪽이 더 큼
        				parent[fir][1]+=parent[sec][1];
        				sb.append(parent[fir][1]+"\n");
        				union(fir,sec);
        			}else {
        				parent[sec][1]+=parent[fir][1];
        				sb.append(parent[sec][1]+"\n");
        				union(sec,fir);
        			}
        		}
        	}
//        	System.out.println("-------------------------------------");
        }
        System.out.println(sb);

     }
    
    static public int find(int a) {
    	
    	if(parent[a][0]==a) {
    		
    		return a;
    	}else {
    		return parent[a][0]=find(parent[a][0]);
    	}
    }
    static public void union(int a, int b) {
    	parent[b][0]=parent[a][0];
    }
}