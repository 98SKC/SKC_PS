import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T=Integer.parseInt(br.readLine());
        int V,E;
        StringTokenizer st;
        
        StringBuilder sb=new StringBuilder();
        int s,e;
        
        for(int t=1;t<=T;t++) {
        	st=new StringTokenizer(br.readLine());
            V=Integer.parseInt(st.nextToken());
            E=Integer.parseInt(st.nextToken());
            ArrayList<Integer>[] list=new ArrayList[V+1];
            
            for(int i=1;i<=V;i++) {
            	list[i]=new ArrayList<>();
            }
            
            for(int i=0;i<E;i++) {
            	st=new StringTokenizer(br.readLine());
            	s=Integer.parseInt(st.nextToken());
            	e=Integer.parseInt(st.nextToken());
            	
            	list[s].add(e);
            	list[e].add(s);
            }
            ArrayDeque<int[]> q=new ArrayDeque<>();
            int[] v=new int[V+1];//0 - 미방문 , 1: 1그룹, -1: 2그룹
            boolean check=true;
            int[] sub;
            q.add(new int[] {1,1});
            for(int k=1;k<=V;k++) {
            	if(v[k]!=0) continue;
            	q.add(new int[] {k,1});
                v[k]=1;
                while(!q.isEmpty()) {
                	sub=q.poll();
                	for(int i=0;i<list[sub[0]].size();i++) {
                		if(v[list[sub[0]].get(i)]==0) {// 다음이 아직 방문한 적 없는 정점이면
                			q.add(new int[] {list[sub[0]].get(i),sub[1]*-1});
                			v[list[sub[0]].get(i)]=sub[1]*-1;
                		}else if(v[list[sub[0]].get(i)]==sub[1]){// 다음이 이미 자신과 같은 노드면 
                			check=false;
                			break;
                		}else {// 다음이 이미 자신과 다른 노드라면
                			// 스킵
                		}
                	}
                }
                if(!check) break;
                
            }

            
        	if(check) {
        		sb.append("YES\n");
        	}else {
        		sb.append("NO\n");
        	}
        }
        
        System.out.println(sb);
        
        
        
    }
}