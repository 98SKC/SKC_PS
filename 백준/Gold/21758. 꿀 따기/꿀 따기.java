
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();

        
        int N=Integer.parseInt(br.readLine());
        int[] leftSum=new int[N+1]; //왼쪽에서 부터의 누적합
        int[] rightSum=new int[N+1]; // 우측에서의 누적합
        
        int[] honeys=new int[N+1];
        
        StringTokenizer st=new StringTokenizer(br.readLine());
        

        //두 벌이 배열의 두 포인터에서 시작
        //한 포인터에 벌통을 설치
        //시작 지점에서는 꿀을 딸 수 없다(두 벌 모두의 시작점). 두 벌이 같은 곳을 지나면 같은 양의 꿀을 딴다.
        
        //벌들이 벌통으로 일직선으로 이동할 때 벌들이 딸 수 있는 최대의 꿀의 양을 구하라
        
        // 누적합? 이 떠오르긴 하는데
        //시간복잡도 N^2보다 작아야함 N혹은 NlogN 이어야 함.
        //i를 벌통으로 잡는 시복 N
        //포인터 두개 잡는데 logN?
        
        // 꿀이 있을 때 최대값 하나는 벌통이 한쪽 끝에 있는
        // 왼쪽 끝, 벌통우측, 그 사이 어딘가
        // 우측 끝, 벌통좌측, 그 사이 어딘가
        // 양쪽 끝 벌, 중앙 벌통 
        // 이 세가지에서 그리디?
        
        //각 배열마다 딸 수 있는 꿀의 정보이 있다.
        for(int i=1;i<=N;i++) {
        	honeys[i]=Integer.parseInt(st.nextToken());
        	//leftSum[i]=honeys[i]+leftSum[i-1];
        }
        
        for(int i=1;i<=N;i++){
        	leftSum[i]=leftSum[i-1]+honeys[i]; // →
        }
        

        for(int i=N-1;i>0;i--){
        	rightSum[i]=rightSum[i+1]+honeys[i]; //←
        }
        
        
        int max=Integer.MIN_VALUE;
        int cur;
        
        //1. 벌통이 오른쪽 끝일 때 마지막 하나의 벌 위치
        for(int i=2;i<=N-1;i++){
          //    (왼쪽 벌이 채취하는 꿀 양)  -(두번째 벌 위치 꿀) +(왼쪽 벌 위치부터 우측 벌꿀 위치까지)
          cur = (leftSum[N]-leftSum[1]-honeys[i])     +(leftSum[N]-leftSum[i]);
          max = Math.max(max, cur);
        }
        
        //2. 벌통이 왼쪽 끝일 때 마지막 하나의 벌 위치
        for(int i=N-1;i>=2;i--){
          //    (우측 벌이 채취하는 꿀 양)  -(두번째 벌 위치 꿀) +(우측 벌 위치부터 왼쪽 벌꿀 위치까지)
          cur = (rightSum[1]-rightSum[N]-honeys[i])+(rightSum[1]-rightSum[i]);
          max = Math.max(max, cur);
        }
        
        //3. 벌통이 중간일 때 양쪽 끝이 벌 위치. 아무대나 되는건 아니고 최대값을 두번 먹을 수 있는 위치
        for(int i=2;i<=N-1;i++){
          max=Math.max(max,(leftSum[i]-leftSum[1])+(rightSum[i]-rightSum[N]));
        }
        
       System.out.println(max);
        
    }
        
}


