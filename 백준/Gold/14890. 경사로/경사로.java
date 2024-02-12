import java.io.*;
import java.util.*;

public class Main

{

	static int N ,X,answer;
	static int[][] runway;
	static boolean[] possible;
	
    public static void main(String args[]) throws Exception
    {
    	
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb=new StringBuilder();
    	StringTokenizer st;
    	
    		int check=0;
    		int count;
    		st=new StringTokenizer(br.readLine());
    		N=Integer.parseInt(st.nextToken());
    		X=Integer.parseInt(st.nextToken());
    		answer=0;
    		runway=new int[N][N];
    		//배열 생성
    		for(int i=0;i<N;i++) {
    			st=new StringTokenizer(br.readLine());
    			for(int j=0;j<N;j++) {
    				runway[i][j]=Integer.parseInt(st.nextToken());
    			}
    		}
    		
    		for(int i=0;i<N;i++) {
    			count=1;
    			possible=new boolean[N];
    			for(int j=0;j<N-1;j++) {//for문은 고정. 범위 맞음
        			if(runway[i][j]==runway[i][j+1]) count++;
        			else if(Math.abs(runway[i][j]-runway[i][j+1])!=1){//경사로 설치해도 못감.
        				break;
        			}else if(runway[i][j]<runway[i][j+1]) {// 다음위치가 더 높음
        				if(!helper(count,j)) {// 경사로 설치 가능하면
        					break;
        				}
        				count=1;//count 사용함.
        			}else {//다음 위치가 더 낮음
        				if(helper2(i, j)) {
        					j+=X-1;
        					count=1;//count 초기화
        				}else {
        					break;
        				}
        			}		
    				if(j>=N-2) answer++;
        		}
    		}
    		
    		for(int i=0;i<N;i++) {
    			count=1;
    			possible=new boolean[N];
    			for(int j=0;j<N-1;j++) {//for문은 고정. 범위 맞음
        			if(runway[j][i]==runway[j+1][i]) {
        				count++;
        			} else if(Math.abs(runway[j][i]-runway[j+1][i])!=1){//경사로 설치해도 못감.
        				break;
        			}else if(runway[j][i]<runway[j+1][i]) {// 다음위치가 더 높음
        				if(!helper(count,j)) {// 경사로 설치 가능하면
        					break;
        				}
        				count=1;//count 사용함.
        			}else {//다음 위치가 더 낮음
        				if(helper3(i, j)) {
        					j+=X-1;
        					count=1;//count 초기화
        				}else {
        					break;
        				}
        			}		
    				if(j>=N-2) answer++;
        		}
    		}

    	System.out.println(answer);
       
    }
     
    //경사로 조건
    //1. 경사로 설치 시 배열 범위 내.
    //2. 경사로 설치 자리에 경사로이 없어야함.
    //3. 경사로 설치하는 구역은 높이가 같아야함.
    //4. 가려는 곳과 위치가 1차이.
    //5. 내려가는 경사로의 경우, 탐색 위치를 뛰어 넘어야 한다.
  
    static boolean helper(int cnt,int j) {// 더 높은 곳 처리
    
    	if(cnt<X) {
    		return false;
    	}else {
    		for(int i=j;i>j-X;i--) {
    			if(possible[i]) {
    				return false;
    			}
    			possible[i]=true;//세울 수 있으면 위치에 true
    		}
    		return true;
    	}
    	
    }
    static boolean helper2(int number,int j) {// 더 낮은 곳 처리-가로
    	//아직 탐색 안한 곳을 확인 하는 것이니 count나 경사로 설치 여부는 의미 없음. 높낮이가 일정한지만 확인
    	if(j+X>N-1) {
    		return false;
    	}
    	
    	if(X==1) {
    		possible[j+1]=true;
    		return true;
    	}
    	for(int i=j+1;i<j+X;i++) {
    		if(runway[number][i]!=runway[number][i+1]) {

    			return false;
    		}
    		possible[i+1]=true;
    	}
    	 return true;
    }
    
    static boolean helper3(int number,int j) {// 더 낮은 곳 처리- 세로
    	//아직 탐색 안한 곳을 확인
    	if(j+X>N-1) {
    		return false;
    	}
    	
    	if(X==1) {
    		possible[j+1]=true;
    		return true;
    	}
    	for(int i=j+1;i<j+X;i++) {
    		if(runway[i][number]!=runway[i+1][number]) {
    			return false;
    		}
    		possible[i+1]=true;
    	}
    	 return true;
    }

}