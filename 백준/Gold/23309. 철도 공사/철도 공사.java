
import java.util.*;
import java.io.*;

public class Main{

	public static int N,M;
//	public static HashMap<Integer, Integer> next=new HashMap<>();// key역의 다음 역을 반환한다.
//	public static HashMap<Integer, Integer> before=new HashMap<>();//key역의 이전 역을 반환한다.
	public static int[] next=new int[1000001];
	public static int[] before =new int[1000001];
	
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        
        StringTokenizer st=new StringTokenizer(br.readLine());
        
        
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        
        int[] sub=new int[N];
        
        st=new StringTokenizer(br.readLine());
        for(int n=0;n<N;n++) {
        	sub[n]=Integer.parseInt(st.nextToken());
        }
        

        
        for(int n=0;n<N-1;n++) {
        	//sub[n]의 다음역은 sub[n+1]이다.
        	//next.put(sub[n], sub[n+1]);
        	next[sub[n]]=sub[n+1];
        }
        
        //next.put(sub[N-1], sub[0]);
        next[sub[N-1]]=sub[0];
        //sub[N-1]의 다음역은 0역이다.

        for(int n=N-1;n>0;n--) {
        	//sub[n]의 이전역은 sub[n+1]이다.
        	//before.put(sub[n], sub[n-1]);
        	before[sub[n]]=sub[n-1];
        }
        
        //n-1역은 0역의 이전이다 (순환)
        //before.put(sub[0], sub[N-1]);
        before[sub[0]]=sub[N-1];
        String[] str;
        String order;
        int i,j;
        int answer;
        for(int m=0;m<M;m++) {
        	st=new StringTokenizer(br.readLine());
        	order = st.nextToken();
        	i=Integer.parseInt(st.nextToken());;
        	
        	//역을 설립한다. i,j 두개의 파라미터
        	if(order.charAt(0)=='B') {
        		j=Integer.parseInt(st.nextToken());
        		if(order.charAt(1)=='N') {
        			sb.append(calBn(i,j)+"\n");
        		}else if(order.charAt(1)=='P') {
        			sb.append(calBp(i,j)+"\n");
        		}else {
        			System.out.println("문자열을 못읽는 오류");
        			return;
        		}
        		
        	}else {//역을 폐쇠한다. i 한개만의 파라미터
        		if(order.charAt(1)=='N') {
        			sb.append(calCn(i)+"\n");
        		}else if(order.charAt(1)=='P') {
        			sb.append(calCp(i)+"\n");
        		}else {
        			System.out.println("문자열을 못읽는 오류");
        			return;
        		}
        		
        	}
        	
        }

        System.out.println(sb);
        
        
        
    }
    
    //고유 번호 i를 가진 역의 다음 역의 고유 번호를 출력하고, 그 사이에 고유 번호 j인 역을 설립한다.
    public static int calBn(int i, int j) {
    	//int answer=next.get(i);// 기존의 다음역을 먼저 출력 및 저장
    	int answer=next[i];// 기존의 다음역을 먼저 출력 및 저장
    	
    	//j를 새로 설립하려면 다음과 같은 과정을 거친다.
    	
    	//i의 next를 j로 바꾸며, answer의 before를 j로 바꾼다.
//    	next.put(i, j);
//    	before.put(answer, j);
    	next[i]=j;
    	before[answer]=j;
    	
    	//또한 j의 before을 i로, j의 next를 answer로 바꾼다. 
//    	before.put(j, i);
//    	next.put(j, answer);
    	before[j]=i;
    	next[j]=answer;
    	    	
    	return answer;
    }
    
    //고유 번호 i를 가진 역의 이전 역의 고유 번호를 출력하고, 그 사이에 고유 번호 j인 역을 설립한다.
    public static int calBp(int i, int j) {
//    	int answer=before.get(i);// 기존의 이전역을 먼저 출력 및 저장
    	int answer=before[i];// 기존의 이전역을 먼저 출력 및 저장
    	
    	//j를 새로 설립하려면 다음과 같은 과정을 거친다.
    	
    	//i의 before를 j로 바꾸며, answer의 next를 j로 바꾼다.
//    	before.put(i, j);
//    	next.put(answer, j);
    	before[i]=j;
    	next[answer]=j;
    	
    	//또한 j의 next을 i로, j의 before를 answer로 바꾼다. 
//    	next.put(j, i);
//    	before.put(j, answer);
    	next[j]=i;
    	before[j]=answer;
    	
    	return answer;
    }
    
    //고유 번호 i를 가진 역의 다음 역을 폐쇄하고 그 역의 고유 번호를 출력한다.
    public static int calCn(int i) {
//    	int answer=next.get(i);//i역의 다음 역의 고유번호
//    	int jump=next.get(answer);
    	int answer=next[i];//i역의 다음 역의 고유번호
    	int jump=next[answer];
    	//역을 폐쇄하기 위해서는 다음과 같은 과정을 거친다.
    	
    	//i의 next를 answer의 next로 바꾸고,
//    	next.put(i, jump);
    	next[i]=jump;    	
    	
    	//answer의 next의 before를 i로 바꾼다.
//    	before.put(jump, i);
    	before[jump]=i;
    	
    	//i의 Hash 2개를 삭제한다.
//    	next.remove(answer);
//    	before.remove(answer);
    	next[answer]=-1;
    	before[answer]=-1;
    	
    	return answer;
    }
    //고유 번호 i를 가진 역의 이전 역을 폐쇄하고 그 역의 고유 번호를 출력한다.
    public static int calCp(int i) {
//    	int answer=before.get(i);
//    	int jump=before.get(answer);
    	int answer=before[i];
    	int jump=before[answer];
    	
    	//역을 폐쇄하기 위해서는 다음과 같은 과정을 거친다.
    	
    	//i의 before를 answer의 before로 바꾸고,
//    	before.put(i, jump);
    	before[i]= jump;
    	
    	//answer의 before의 next를 i로 바꾼다.
//    	next.put(jump, i);
    	next[jump]=i;
    	
    	//i의 Hash 2개를 삭제한다.
//    	next.remove(answer);
//    	before.remove(answer);
    	next[answer]=-1;
    	before[answer]=-1;    	
    	
    	return answer;
    }
    
}


