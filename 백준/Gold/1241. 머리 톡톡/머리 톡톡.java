
import java.util.*;
import java.io.*;

public class Main{

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        
        int[] arr=new int[N+1];
        int[] answer=new int[N+1];
        
        HashMap<Integer, Integer> save=new HashMap<>();
        int max=0;
        for(int i=1;i<=N;i++) {
        	arr[i]=Integer.parseInt(br.readLine());
        	max=Math.max(max, arr[i]);
        }
        //값의 빈도. (arr에 freq[i]가 몇번 나왔다.)
        int[] freq=new int[max+1];
        for(int i:arr) freq[i]++;
        
        //divCnt[m]=m을 나눌 수 있는 값(약수)의 등장 횟수 총합
        int[] divCnt=new int[max+1];
        
        
        //1번부터 N번까지의 학생.
        //원으로 순서대로 앉아있다. N번 학생은 1번과 N-1번 사이에 있다.
        //각각의 학생들은 머리 위에 1000000이하의 자연수 중 하나를 쓴다.
        //1번부터 N번까지 차례대로 원을 돌면서 자신의 숫자가 다른사람의 배수이면 그 사람을 톡톡 친다.
        //각 학생이 자신의 자리로 돌아올 때 까지 총 몇명의 머리를 치는지 구하라.
        // 1 2 3 4 5 
        // 3에서 시작, j는 2에서 5, j는 3에서 1.
        
        
        StringBuilder sb=new StringBuilder();
        
        // 존재하는 값만 배수 순회
        
        for (int v = 1; v <= max; v++){
            int fv = freq[v];//fv는 v가 나온 횟수
            if (fv == 0) continue;//나온적 없는 수다.
            for (int m = v; m <= max; m += v) {// 나왔다면 이 수가 영향을 미칠 배수들에 ++;
                divCnt[m] += fv;
            }
        }

       
        for(int i=1;i<=N;i++) {
            sb.append((divCnt[arr[i]]-1)+"\n");//자기 자신 빼기
        }

        System.out.print(sb);
    }
}
