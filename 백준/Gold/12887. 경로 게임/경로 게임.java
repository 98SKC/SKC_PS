import java.util.*;
import java.io.*;

public class Main {

	public static char[][] arr;
	public static boolean[][] v;
	public static int max=0;
	public static int len=0;

    public static void main(String[] args) throws Exception {
        
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	len=Integer.parseInt(br.readLine());
    	String str1,str2;
    	str1=br.readLine();
    	str2=br.readLine();

    	arr=new char[2][len];
    	v=new boolean[2][len];
    	//possible=new boolean[2][len];
    	for(int i=0;i<len;i++) {
    		arr[0][i]=str1.charAt(i);
    	}
    	
    	for(int i=0;i<len;i++) {
    		arr[1][i]=str2.charAt(i);
    		
    	}
    	
    	int row=0;
    	int col;
    	ArrayDeque<int[]> q=new ArrayDeque<int[]>();
    	if(arr[0][0]=='.') {
    		q.add(new int[] {0,0,0});
    	}
    	if(arr[1][0]=='.') {
    		q.add(new int[] {1,0,0});
    	}

    	int sub[];
    	while(!q.isEmpty()) {
    		sub=q.poll();
    		int next=check(sub[0],sub[1]);
    		if(next==0) {
//    			max++;
//    			row+=1;
    			q.add(new int[] {sub[0],sub[1]+1,sub[2]+1});
//    			q.add(new int[] {Math.abs(sub[0]-1),sub[1]+1,sub[2]+1});
    		}else if(next==1) {
//    			row+=1;
//    			col=Math.abs(col-1);
    			q.add(new int[] {Math.abs(sub[0]-1),sub[1]+1,sub[2]});
    		}else if(next==2){
//    			max++;
//    			row+=1;
    			q.add(new int[] {sub[0],sub[1]+1,sub[2]+1});
    		}else if(next==3){
    			//row+=1;
    			q.add(new int[] {sub[0],sub[1]+1,sub[2]});
    		}else if(next==4) {
//    			max++;
//    			row+=1;
    			max=Math.max(max, sub[2]+1);
    		}else {
//    			row+=1;
    			max=Math.max(max, sub[2]);
    		}
    		
    	}
//    	while(row<len) {
//    		int next=check(col,row);
//    		if(next==0) {
//    			max++;
//    			row+=1;
//    		}else if(next==1) {
//    			row+=1;
//    			col=Math.abs(col-1);
//    		}else if(next==2){
//    			max++;
//    			row+=1;
//    		}else if(next==3){
//    			row+=1;
//    		}else if(next==4) {
//    			max++;
//    			row+=1;
//    		}else {
//    			row+=1;
//    		}
//    	}
    	System.out.println(max);
    	
    	
    }
    public static int check(int col, int row) {
    	if(row==len-1){// 지금이 끝 위치면
    		if(arr[Math.abs(col-1)][row]=='.') return 4;// 하나 더 바꿀 수 있음
    		return 5;// 못 바꿈
    	}
    	
    	if(arr[col][row+1]=='.'&&arr[Math.abs(col-1)][row+1]=='.'&&arr[Math.abs(col-1)][row]=='.') return 0;// 자신이 있는 곳 반대를 검정색으로. 그리고 옆으로 한칸 이동
    	
    	else if(arr[col][row+1]=='#'){// 바로 옆이 벽
    		return 1;// 대각선으로 이동
    	}else if(arr[Math.abs(col-1)][row]=='.'){// 바로 옆이 벽이 아닌데, 반대쪽이 비어있으면 바꾸고 갈 수 잇음
    		return 2;
    	}else {
    		return 3;// 아무 변화 없이 옆으로 감
    	}
    }
    
    
   
}