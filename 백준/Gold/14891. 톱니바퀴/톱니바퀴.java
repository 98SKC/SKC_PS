import java.util.*;
import java.io.*;



public class Main {
	static int[] arr=new int[4];

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		
		for(int i=0;i<4;i++){
			arr[i]=Integer.parseInt(br.readLine(),2);// 2진수로 넣는데, 들어갈때는 10진수
		}
		// 나중에 2진수 문자열로 가져오기
		//String binaryString = Integer.toBinaryString(arr[i]);
		
		int k=Integer.parseInt(br.readLine());// 톱니 번호는 1~4로 나옴
		
		for(int i=0;i<k;i++) {
			st=new StringTokenizer(br.readLine());			
			int number=Integer.parseInt(st.nextToken())-1;// 먼저 돌아갈 톱니의 인덱스.
			int dir=Integer.parseInt(st.nextToken());// 1이 시계, -1이 반시계
			rotate(number,dir);
		
		}
		System.out.println(Score());
		
	}
	
	static int Score() {
		int score=0;
		// 각 톱니바퀴의 12시 방향 비트(가장 왼쪽 비트)가 1이면 해당 점수를 합산
		score +=((arr[0])&(1<<7))==0?0:1;
		score +=((arr[1])&(1<<7))==0?0:2;
		score +=((arr[2])&(1<<7))==0?0:4;
		score +=((arr[3])&(1<<7))==0?0:8;
		
		return score;
	}
	// 톱니바퀴 회전 함수
	static void rotate(int idx,int dir) {
		// 각 톱니바퀴의 회전 방향 저장
		int[] direction=new int[4];
		direction[idx]=dir;
		
		// 현재 톱니바퀴와 인접한 톱니바퀴의 회전 여부 및 방향 결정
		for(int i=idx;i>0;i--) {
			if(isSame(i-1,i))break;
			direction[i-1]=-direction[i];
		}
		
		for(int i=idx;i<3;i++) {
			if(isSame(i,i+1))break;
			direction[i+1]=-direction[i];
		}
		turnGear(direction);
	}
	
	
	static void turnGear(int[] dir) {
		for(int i=0;i<4;i++) {
			if(dir[i]==1) {
				turnInClockwise(i);
			}else {
				if(dir[i]==-1) {
				turnInReverseClockwise(i);	
				}
			}
		}
	}
	/*
	 << : 피연산자의 비트열을 왼쪽으로 이동시키며 이동에 따른 빈공간은 0으로 채움.
	 >> : 피연산자의 비트열을 오른쪽으로 이동시키며, 이동에 따른 빈공간은 음수의경우엔 1, 
	      양수의 경우엔 0으로 채움.
	 >>> :피연산자의 비트열을 오른쪽으로 이동시키며, 이동에 따른 빈공간은 0으로 채움.
	 * */
	// 두 톱니바퀴가 서로 맞물려 있는지 확인하는 함수
	static void turnInReverseClockwise(int i) {
		if((arr[i]&(1<<7))>0) {//1001&0001->1001,  1000&0001->1000
			arr[i]<<=1;//
			arr[i]|=1;//arr[i] |= (1 << 7) 연산은 arr[i]와 10000000을 비트별로 OR 연산하고, 그 결과를 arr[i]에 저장
		}else {
			arr[i]<<=1;//
		}
		
	}
	static void turnInClockwise(int i) {
		if((arr[i]&1)>0) {//1001&0001->1001,  1000&0001->1000
			arr[i]>>>=1;//
			arr[i]|=(1<<7);//arr[i] |= (1 << 7) 연산은 arr[i]와 10000000을 비트별로 OR 연산하고, 그 결과를 arr[i]에 저장
		}else {
			arr[i]>>>=1;//
		}
	}
	static boolean isSame(int i,int j) {
		int a=(arr[i]&(1<<5))>0?1:0;// i번째 톱니바퀴의 오른쪽 비트
		int b=(arr[j]&(1<<1))>0?1:0;// j번째 톱니바퀴의 왼쪽 비트
		
		return a==b;// 두 비트가 같으면 맞물려 있지 않음
	}

	

}