
import java.util.*;
import java.io.*;

public class Main {


	public static int N,K,M;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        N=Integer.parseInt(st.nextToken()); //N명이서 게임을
        K=Integer.parseInt(st.nextToken()); //k를 말하면 탈락
        M=Integer.parseInt(st.nextToken()); //내 위치


        int total=N;//
        int pos=0;//삭제할 인덱스. 0~N-1 까지/  N이 5면  0 1 2 3 4 0 1 2 3 4
        int del=M-1;//삭제해야 하는 위치
        int turn=0;
        while(true){
        	turn++;
        	//System.out.println("시작 위치: "+pos+" 내 위치: "+del);
        	pos+=(K-1)%total;//삭제될 위치
        	pos%=total;
        	if(pos==del) break;
        	if(pos<del){//
        		del-=1;
        	}
        	total--;
        	//System.out.println("이번 삭제 위치: "+pos+" 옮긴 내 위치: "+del);
        	//System.out.println();
        }
        
        System.out.println(turn);
        //N명이 게임. 1~N까지 시계방향. 1번부터 시작. 시계방향으로 1,2,3,4...K를 세고, K를 말하면 퇴장
        //그 다음부터 1 다시 센다.
        //M번으로 참가. 자신은 몇번째로 퇴장 당하는가?
        
    }
    //1 2 3 4 5
    

}
