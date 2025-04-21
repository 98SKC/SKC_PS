
import java.util.*;
import java.io.*;

public class Main{

	public static int[] parent;
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        int[][] map=new int[N][N];
        String str;
        int total=0;
        int sub;
        
        for(int i=0;i<N;i++) {
        	str=br.readLine();
        	for(int j=0;j<N;j++) {
        		if(str.charAt(j)!='0') {
        			sub=str.charAt(j);
        			if(sub<'a') {
        				sub=26+sub-'A'+1;
        			}else {
        				sub=sub-'a'+1;
        			}
        			
        		}else {
        			sub=0;
        		}
        		total+=sub;
        		map[i][j]=sub;
        	}
        }
        
        parent=new int[N];
        for(int i=0;i<N;i++) {
        	parent[i]=i;
        }
        
        //edge[i]의 원소는 i와 연결된 arr[0]컴퓨터 사이의 거리 arr[1]
//        ArrayList<int[]>[] edge=new ArrayList[N];
//        for(int i=0;i<N;i++) {
//        	edge[i]=new ArrayList<>();
//        }
        PriorityQueue<int[]> pq=new PriorityQueue<>(new Comparator<int[]>() {
        	@Override
        	public int compare(int[] o1, int[] o2) {
        		return o1[2]-o2[2];
        	}
        });
        
        for(int i=0;i<N;i++) {
        	for(int j=i+1;j<N;j++) {
        		if(map[i][j]!=0&&map[j][i]!=0) {
        			
        			sub=Math.min(map[i][j], map[j][i]);
        			pq.add(new int[] {i,j,sub});
        		}else {
        			if(map[i][j]!=0||map[j][i]!=0) {
        			
        				sub=Math.max(map[i][j], map[j][i]);
        				pq.add(new int[] {i,j,sub});
        			}
        		}
        		
        	}
        }
        
        int[] pos;
        int sum=0;
        while(!pq.isEmpty()) {
        	pos=pq.poll();
        	if(union(pos[0],pos[1])){
        		sum+=pos[2];
        		//System.out.println(pos[0]+" "+pos[1]+" 을 연결. "+pos[2]+" 의길이. 현 총합: "+sum);
        	}
        	
        }
        int before=parent[0];
        int p;
        for(int i=1;i<N;i++){
        	p=find(i);
        	if(before!=p) {
        		System.out.println(-1);
        		return;
        	}
        	before=p;
        }
        System.out.println(total-sum);

        
    }
    
    public static int find(int a) {
    	if(parent[a]==a) {
    		return a;
    	}
    	
    	return parent[a]=find(parent[a]);
    }
    
    
    public static boolean union(int a,int b) {
    	int parentA=find(a);
    	int parentB=find(b);
    	if(parentA==parentB) {
    		return false;
    	}
    	if (parentA > parentB) {
    	    parent[parentA] = parentB;
    	} else {
    	    parent[parentB] = parentA;
    	}

    	
    	return true;
    }
    
}
