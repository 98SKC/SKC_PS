
import java.util.*;
import java.io.*;

public class Main{

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N=Integer.parseInt(br.readLine());
        int K=Integer.parseInt(br.readLine());
        StringTokenizer st=new StringTokenizer(br.readLine());
        
        if(K>=N) {
        	System.out.println(0);
            return;
        }
        
        int answer=0;

        //고속도로 위에 N개의 센서
        //k개의 자료수집 센터를 세울 예정
        //각 센터는 수신 가능 영역을 조절가능
        
        //고속도로는 평면상의 직선.
        //센서들은 원점으로부터 정수 거리의 위치
        //각 센서의 죄표는 정수 하나로 표현
        //각 센터의 수신 가능 역역의 거리의 합의 최소를 구하라.
        int[] arr=new int[N];
        for(int i=0;i<N;i++) {
           int temp=Integer.parseInt(st.nextToken());
           arr[i]=temp;
        }
        
        Arrays.sort(arr);
 
        int[] diff=new int[N-1];
        
        for(int i=0;i<N-1;i++) {
           diff[i]=arr[i+1]-arr[i];
        }
        
        Arrays.sort(diff);

        for(int i=0;i<N-K;i++) {
           answer+=diff[i];
        }
        
        System.out.println(answer);
    }
        
}


