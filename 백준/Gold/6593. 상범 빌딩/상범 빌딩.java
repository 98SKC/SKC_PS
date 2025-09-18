import java.io.*;
import java.util.*;

public class Main {
	
	public static char[][][] map;
	public static boolean[][][] v;
	public static int[] di=new int[] {0,0,1,-1,0,0};
	public static int[] dj=new int[] {0,0,0,0,1,-1};
	public static int[] dk=new int[] {1,-1,0,0,0,0};
	public static int L,R,C;
	public static int si,sj,sk;//시작점.
	public static int gi,gj,gk;//목표
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String str;
        
        int ni,nj,nk;
        int[] p;
        int s=-1;
        StringBuilder sb=new StringBuilder();
        ArrayDeque<int[]> q;
        while(true) {
        	st = new StringTokenizer(br.readLine());
            
            L=Integer.parseInt(st.nextToken());
            R=Integer.parseInt(st.nextToken());
            C=Integer.parseInt(st.nextToken());
            s=-1;
            if((L+R+C)==0) break;
            
            map=new char[L+1][R+1][C+1];
            v=new boolean[L+1][R+1][C+1];
            for(int k=1;k<=L;k++) {
            	for(int i=1;i<=R;i++) {
                	str = br.readLine();
            		for(int j=1;j<=C;j++) {
            			map[k][i][j]=str.charAt(j-1);
            			if(map[k][i][j]=='S') {
            				si=i;
            				sj=j;
            				sk=k;
            			}else if(map[k][i][j]=='E') {
            				gi=i;
            				gj=j;
            				gk=k;
            			}
            		}
            	}
            	br.readLine();
            }
            q=new ArrayDeque<>();
            q.add(new int[] {sk,si,sj,0});
            v[sk][si][sj]=true;
            while(!q.isEmpty()) {
            	p=q.poll();
            	if(p[0]==gk&&p[1]==gi&&p[2]==gj){
            		s=p[3];
            		break;
            	}
            	
            	for(int a=0;a<6;a++) {
            		nk=p[0]+dk[a];
            		ni=p[1]+di[a];
            		nj=p[2]+dj[a];
            		
            		if(nk>0&&nk<=L&&ni>0&&ni<=R&&nj>0&&nj<=C&&!v[nk][ni][nj]&&map[nk][ni][nj]!='#') {
            			v[nk][ni][nj]=true;
            			q.add(new int[] {nk,ni,nj,p[3]+1});
            		}
            		
            	}
            }
            
            if(v[gk][gi][gj]) sb.append("Escaped in "+s+" minute(s).");
            else sb.append("Trapped!");
            sb.append("\n");
        }
        
        //정육면체에 map
        //동서남북상하로 이동가능. 

        
        
        System.out.println(sb);
    }

}
