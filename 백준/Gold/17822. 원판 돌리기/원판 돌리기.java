import java.util.*;
import java.io.*;

public class Main {
	
	static int N,M,T;
	static int[][] circle;
	static int x,d,k;
	static Queue<Integer> q;
	static int[] di=new int[] {0,1,0,-1};
	static int[] dj=new int[] {1,0,-1,0};
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       
        StringTokenizer st = new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        T=Integer.parseInt(st.nextToken());
        circle=new int[N+1][M];

        for(int i=1;i<=N;i++) {
        	st=new StringTokenizer(br.readLine());
        	for(int j=0;j<M;j++) {
        		circle[i][j]=Integer.parseInt(st.nextToken());
        	}
        }
        
        for(int i=0;i<T;i++) {
        	q=new ArrayDeque<>();
        	st=new StringTokenizer(br.readLine());
        	x=Integer.parseInt(st.nextToken());
        	d=Integer.parseInt(st.nextToken());
        	k=Integer.parseInt(st.nextToken());
        	
        	for(int j=x;j<=N;j+=x) {//x배수의      		
        		if(d==0) {
        			clock(j, k);       			
        		}else{
        			reverse(j,k);
        			
        		}
        	}
        	search();
//        	for(int a=1;a<=N;a++) {
//            	for(int j=0;j<M;j++) {
//            		System.out.print(circle[a][j]+" ");
//            	}
//            	System.out.println();
//            }
//        	System.out.println();
        }
        
        int answer=0;
        for(int i=1;i<=N;i++) {
        	for(int j=0;j<M;j++) {
        		answer+=circle[i][j];
        	}
        }
        
        
        System.out.println(answer);
        
    }
    static void clock(int h,int k) {
    	
    	for(int i=0;i<M;i++) {
    		q.add(circle[h][i]);
    	}
    	
    	int pos=k;


    	while(!q.isEmpty()) {
    		circle[h][pos]=q.poll();
    		pos=(pos+1)%M;
    	}
    	
    }
    
    static void reverse(int h,int k) {
    	
    	for(int i=0;i<M;i++) {
    		q.add(circle[h][i]);
    	}
    	
    	int pos=M-k;
    	while(!q.isEmpty()) {
    		circle[h][pos]=q.poll();
    		pos=(pos+1)%M;
    	}
    	
    }
    
    static void search() {
    	HashSet<Integer> set=new HashSet<>();
    	int[] sum=new int[] {0,0};
    	int ni,nj;
    	
    	for(int h=1;h<=N;h++) {
    		for(int j=0;j<M;j++) {
    			if(circle[h][j]!=0) {
    				sum[0]+=circle[h][j];
    				sum[1]++;
    				for(int a=0;a<4;a++) {
        				ni=h+di[a];
        				nj=j+dj[a];
        				if(nj==-1) nj=M-1;
        				if(nj==M) nj=0;
        				if(ni>=0&&ni<=N&&nj>=0&&nj<M) {
        					if(circle[h][j]==circle[ni][nj]) {
        						set.add(h*M+j);
        						set.add(ni*M+nj);
        					}
        				}	
        			}
    			}
    			
    		}
    	}
    	

    	if(set.size()!=0) {
    		for(int pos:set) {
    			
    			int i=pos/M;
    			int j=pos%M;
    			//System.out.println("i+j"+i+" "+j);
    			circle[i][j]=0;
    			
    		}
    	}else{
    		double avg=(double)sum[0]/sum[1];
//    		System.out.println("sub[0]: "+sum[0]);
//    		System.out.println("sum[1]: "+sum[1]);
//    		System.out.println("avg: "+avg);
    		for(int i=1;i<=N;i++) {
    			
    			for(int j=0;j<M;j++) {
    				if(circle[i][j]!=0) {
    					if(circle[i][j]>avg) {
        					circle[i][j]--;
        				}else if(circle[i][j]<avg) {
        					circle[i][j]++;
        				}
    				}
    				
    			}
    		}
    	}
    }
}