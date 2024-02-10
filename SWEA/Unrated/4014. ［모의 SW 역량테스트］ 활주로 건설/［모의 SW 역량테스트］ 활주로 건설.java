import java.io.*;
import java.util.*;

public class Solution

{

	static int N ,X,answer;
	static int[][] airport;
	static boolean[] possible;
	
    public static void main(String args[]) throws Exception
    {
    	//System.setIn(new FileInputStream("src/res/sample_input (7).txt"));
    	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder sb=new StringBuilder();
    	StringTokenizer st;
    	int T=Integer.parseInt(br.readLine());
    	
    	
    	for(int tc=1;tc<=T;tc++) {
    		int check=0;
    		int count;
    		st=new StringTokenizer(br.readLine());
    		N=Integer.parseInt(st.nextToken());
    		X=Integer.parseInt(st.nextToken());
    		answer=0;
    		airport=new int[N][N];
    		
    		//공항 배열 생성
    		for(int i=0;i<N;i++) {
    			st=new StringTokenizer(br.readLine());
    			for(int j=0;j<N;j++) {
    				airport[i][j]=Integer.parseInt(st.nextToken());
    			}
    		}
    		
    		for(int i=0;i<N;i++) {
    			count=1;
    			possible=new boolean[N];
    			for(int j=0;j<N-1;j++) {//for문은 고정. 범위 맞음
        			if(airport[i][j]==airport[i][j+1]) count++;
        			else if(Math.abs(airport[i][j]-airport[i][j+1])!=1){//경사면 설치해도 못감.
        				//System.out.println(i+"행 높이차이가 1이상");
        				break;
        			}else if(airport[i][j]<airport[i][j+1]) {// 다음위치가 더 높음
        				if(!helper(count,j)) {// 경사면 설치 가능하면
        				//	System.out.println(i+"행 높은 곳 가는 경사면 설치 실패");
        					break;
        				}
        				count=1;//count 사용함.
        				//System.out.println(i+"행 높은 곳 가는 경사면 설치");
        			}else {//다음 위치가 더 낮음
        				if(helper2(i, j)) {
        					j+=X-1;
        					//System.out.println(i+"행 낮은 곳 가는 경사면 설치");
        					count=1;//count 초기화
        				}else {
        					//System.out.println(i+"행 낮은 곳 가는 경사면 설치 실패");
        					break;
        				}
        			}		
    				if(j>=N-2) answer++;// 수정해야할 수도
        		}
    		}
    		
    		for(int i=0;i<N;i++) {
    			count=1;
    			possible=new boolean[N];
    			for(int j=0;j<N-1;j++) {//for문은 고정. 범위 맞음
        			if(airport[j][i]==airport[j+1][i]) {
        				count++;
        			} else if(Math.abs(airport[j][i]-airport[j+1][i])!=1){//경사면 설치해도 못감.
        				//System.out.println(i+"열 높이차이가 1이상");
        				break;
        			}else if(airport[j][i]<airport[j+1][i]) {// 다음위치가 더 높음
        				if(!helper(count,j)) {// 경사면 설치 가능하면
        					//System.out.println(i+"열 높은 곳 가는 경사면 설치 실패");
        					break;
        				}
        				count=1;//count 사용함.
        				//System.out.println(i+"열 높은 곳 가는 경사면 설치");
        			}else {//다음 위치가 더 낮음
        				if(helper3(i, j)) {
        					j+=X-1;
        					//System.out.println(i+"열 낮은 곳 가는 경사면 설치");
        					count=1;//count 초기화
        				}else {
        					//System.out.println(i+"열 낮은 곳 가는 경사면 설치 실패");
        					break;
        				}
        			}		
    				if(j>=N-2) answer++;// 수정해야할 수도
        		}
    		}


    		sb.append("#").append(tc).append(" ").append(answer).append("\n");
    	}
    	System.out.println(sb);
       
    }
    
    
    //경사면 조건
    //1. 경사면 설치시 배열 범위 내.
    //2. 경사면 설치 자리에 경사면이 없어야함.
    //3. 경사면 설치하는 구역은 높이가 같아야함.
    //4. 가려는 곳과 위치가 1차이.
    //5. 내려가는 경사면의 경우, 탐색 위치를 뛰어 넘어야 한다.
  
    static boolean helper(int cnt,int j) {// 더 높은 곳 가려는 것 처리
    
    	if(cnt<X) {
    		//System.out.println("위치확인1");
    		return false;
    	}else {
    		for(int i=j;i>j-X;i--) {
    			if(possible[i]) {//경사면이 이미 세워져 있으면- 근데 이거 없어도 될걸? 일단 예비
    				//System.out.println("위치확인2");
    				return false;//불가능
    			
    			}
    			possible[i]=true;//세울 수 있으면 위치에 true
    		}
    		return true;
    	}
    	
    }
    static boolean helper2(int number,int j) {// 더 낮은 곳 가려는 것 처리-가로
    	//아직 탐색 안한 곳을 확인 하는 것이니 count나 경사면 설치 여부는 의미 없음. 높낮이가 일정한지만 확인
    	if(j+X>N-1) {
    		//System.out.println("위치확인1");
    		return false;
    	}
    	possible[j]=true;
    	for(int i=j+1;i<j+X;i++) {
    		if(airport[number][i]!=airport[number][i+1]) {
    			//System.out.println("위치확인2");
    			return false;
    		}
    		possible[i+1]=true;
    	}
    	 return true;
    }
    
    static boolean helper3(int number,int j) {// 더 낮은 곳 가려는 것 처리- 세로
    	//아직 탐색 안한 곳을 확인 하는 것이니 count나 경사면 설치 여부는 의미 없음. 높낮이가 일정한지만 확인
    	if(j+X>N-1) {
    		return false;
    	}
    	possible[j]=true;
    	for(int i=j+1;i<j+X;i++) {
    		if(airport[i][number]!=airport[i+1][number]) {
    			//System.out.println("위치확인2");
    			return false;
    		}
    		possible[i+1]=true;
    	}
    	 return true;
    }
    
    

}