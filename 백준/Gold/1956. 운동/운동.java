import java.io.*;
import java.util.*;


public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        
        int V=Integer.parseInt(st.nextToken());
        int E=Integer.parseInt(st.nextToken());
        
        int[][] dist=new int[V+1][V+1]; 
        for(int i=1;i<=V;i++){
            for(int j=1;j<=V;j++){
                if (i == j) {
					dist[i][j] = 0;
					continue;
				}
				dist[i][j] = 1000000000;
            }
        }
        int subA,subB,subDist;
        
        for(int i=1;i<=E;i++){
        	st=new StringTokenizer(br.readLine());
        	subA=Integer.parseInt(st.nextToken());
            subB=Integer.parseInt(st.nextToken());
            subDist=Integer.parseInt(st.nextToken());
            dist[subA][subB]=subDist;
            
        }
        for(int k=1;k<=V;k++) {// k를 거쳐가는 루트
        	for(int i=1;i<=V;i++) { 
            	for(int j=1;j<=V;j++) {
            		dist[i][j]=Math.min(dist[i][j], dist[i][k]+dist[k][j]);
            		
                }
            }
        }
        
        int answer=Integer.MAX_VALUE;
        for(int k=1;k<=V;k++) {// k를 거쳐가는 루트
        	for(int i=1;i<=V;i++) {
        		if(i==k) continue;
        		if(dist[i][k]==1000000000||dist[k][i]==1000000000) {
        			continue;
        		}
        		answer=Math.min(answer, dist[i][k]+dist[k][i]);
            }
        }
        
        if(answer==Integer.MAX_VALUE) answer=-1;
        System.out.println(answer);
        
	}
}