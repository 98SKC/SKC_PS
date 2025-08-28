
import java.util.*;
import java.io.*;

public class Main {

   public static int N,K,M;
   
   //public static ArrayList<Integer>[] friends;
   public static int[] parent;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());
        
        StringTokenizer st;
        int a,b;
        int pa,pb;
        StringBuilder sb=new StringBuilder();
        for(int test_case=1;test_case<=T;test_case++) {
           sb.append("Scenario "+test_case+":\n");
           N=Integer.parseInt(br.readLine());
           K=Integer.parseInt(br.readLine());
           
           //friends=new ArrayList[N];
           parent=new int[N];
           for(int i=0;i<N;i++) {
              parent[i]=i;
           }
           
           for(int i=0;i<K;i++) {
              st=new StringTokenizer(br.readLine());
              a=Integer.parseInt(st.nextToken());
              b=Integer.parseInt(st.nextToken());
              union(a,b);
              
           }
           
           //System.out.println(Arrays.toString(parent));
           M=Integer.parseInt(br.readLine());
           for(int m=0;m<M;m++) {
              st=new StringTokenizer(br.readLine());
              a=Integer.parseInt(st.nextToken());
              b=Integer.parseInt(st.nextToken());
              
              pa=find(a);
              pb=find(b);
              
              if(pa==pb) {
                 sb.append(1+"\n");
              }else {
                 sb.append(0+"\n");
              }
              
           }
          
          sb.append("\n");
           
           
        }
        System.out.println(sb);
    }
    
    public static boolean union(int a, int b) {
       int pa=find(a);
       int pb=find(b);
       if(pa==pb) return false;
       
       int sub;
       if(pb<pa){
          sub=pb;
          pb=pa;
          pa=sub;
       }
       
       //pa가 더 작음
       parent[pb]=pa;
       return true;
    }
    
    public static int find(int a) {
       
       if(parent[a]==a) return a;
       return parent[a]=find(parent[a]);
       
    }
       
}
