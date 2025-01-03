import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
    	  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
          StringTokenizer st=new StringTokenizer(br.readLine());
          
          int N=Integer.parseInt(st.nextToken());
          int M=Integer.parseInt(st.nextToken());
          int max=0;
          int K=Integer.parseInt(br.readLine());
          ArrayList<Integer> row=new ArrayList<>();
          ArrayList<Integer> col=new ArrayList<>();
          int sub;
          row.add(0);
          col.add(0);
          row.add(N);
          col.add(M);
          
          for(int i=0;i<K;i++) {
          	st=new StringTokenizer(br.readLine());
          	sub=Integer.parseInt(st.nextToken());
          	if(sub==1){//가로로
          		row.add(Integer.parseInt(st.nextToken()));
          	}else{
          		col.add(Integer.parseInt(st.nextToken()));
          	}
          }
          
          Collections.sort(row);
          Collections.sort(col);
          
          int r=0;
          int c=0;
          
          for(int i=0;i<row.size()-1;i++) {
          	r=Math.max(r,row.get(i+1)-row.get(i));
          }
          
          for(int i=0;i<col.size()-1;i++) {
            	c=Math.max(c,col.get(i+1)-col.get(i));
          }
            
          System.out.println(r*c);
          
      }
  }