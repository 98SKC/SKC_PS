import java.util.*;
import java.io.*;

public class Main {
	static int N,R,size;
	static int[][] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        R=Integer.parseInt(st.nextToken());
        size=(int) Math.pow(2, N);
        arr=new int[size][size];
        
        for(int i=0;i<size;i++) {
        	st=new StringTokenizer(br.readLine());
        	for(int j=0;j<size;j++) {
            	arr[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        int step, sub;

        for(int i=0;i<R;i++) {
        	st=new StringTokenizer(br.readLine());
            sub=Integer.parseInt(st.nextToken());
            step=Integer.parseInt(st.nextToken());
            switch(sub) {
            case 1:
            	func1(step);
            	break;
            case 2:
            	func2(step);
            	break;
            case 3:
            	func3(step);
            	break;
            case 4:
            	func4(step);
            	break;
            case 5:
            	func5(step);
            	break;
            case 6:
            	func6(step);
            	break;
            case 7:
            	func7(step);
            	break;
            case 8:
            	func8(step);
            	break;

            }

        }

        StringBuilder sb=new StringBuilder();
        for(int[] a:arr) {
        	for(int b:a) {
        		sb.append(b+" ");
        	}
        	sb.append("\n");
        }
        System.out.println(sb);

        
    }
    
    //완료
    static void func1(int step) {//부분 배열 내에서 상하반전
    	int sub;
    	for(int i=0;i<size;i+=Math.pow(2, step)) {
        	for(int j=0;j<size;j+=Math.pow(2, step)) {
            //부분배열 좌상단이 i,j
        		int top=i;
        		int bottom=i+(int)Math.pow(2, step)-1;
        		while(top<bottom) {
        			for(int k=j;k<j+Math.pow(2, step);k++) {
        				sub=arr[top][k];
        				arr[top][k]=arr[bottom][k];
        				arr[bottom][k]=sub;
        			}
        			top++;
        			bottom--;
        		}

            }
        }
    }
    
    //완료
    static void func2(int step) {//부분 배열 내에서 좌우 봔전
    	int sub;
    	for(int j=0;j<size;j+=Math.pow(2, step)) {
        	for(int i=0;i<size;i+=Math.pow(2, step)) {
            //부분배열 좌상단이 i,j
        		int left=j;
        		int right=j+(int)Math.pow(2, step)-1;
        		while(left<right) {
        			for(int k=i;k<i+Math.pow(2, step);k++) {
        				sub=arr[k][left];
        				arr[k][left]=arr[k][right];
        				arr[k][right]=sub;
        			}
        			left++;
        			right--;
        		}

            }
        }
    }
    
    //완료
    static void func3(int step) {//부분 배열 내에서 오른쪽으로 회전
    	int sub;
    	Queue<Integer> q=new ArrayDeque<>();
    	for(int i=0;i<size;i+=Math.pow(2, step)) {
        	for(int j=0;j<size;j+=Math.pow(2, step)) {
 
        		int startI=i;
        		int startJ=j;
        		
        		for(int a=startI;a<startI+Math.pow(2, step);a++){
        			for(int b=startJ;b<startJ+Math.pow(2, step);b++) {
        				q.add(arr[a][b]);
        			}
        		}
        		for(int b=(int)(startJ+Math.pow(2, step)-1);b>=startJ;b--){
        			for(int a=startI;a<startI+Math.pow(2, step);a++) {
        				arr[a][b]=q.poll();
        			}
        		}

            }
        }
    }
    //완료
    static void func4(int step) {//부분 배병 내에서 왼쪽으로 회전
    	int sub;
    	Queue<Integer> q=new ArrayDeque<>();
    	for(int i=0;i<size;i+=Math.pow(2, step)) {
        	for(int j=0;j<size;j+=Math.pow(2, step)) {
 
        		int startI=i;
        		int startJ=j+(int)(Math.pow(2, step)-1);
        		
        		for(int a=startI;a<startI+Math.pow(2, step);a++){
        			for(int b=startJ;b>=j;b--) {
        				q.add(arr[a][b]);
        			}
        		}
     
        		
        		for(int b=j;b<j+Math.pow(2, step);b++){
        			for(int a=startI;a<startI+Math.pow(2, step);a++) {
        				arr[a][b]=q.poll();
        			}
        		}

            }
        }
    }
    
    static void func5(int step) {//부분배열끼리 상하 반전
    	func1(N);
    	func1(step);
    }
    
    static void func6(int step) {//부분배열끼리 좌우 반전
    	func2(N);
    	func2(step);
    }
    
    static void func7(int step) {//부분배열끼리 오른쪽 회전
    	func3(N);
    	func4(step);
    	
    }
    
    static void func8(int step) {//부분배열끼리 왼쪽 회전
    	func4(N);
    	func3(step);
    }
    
}