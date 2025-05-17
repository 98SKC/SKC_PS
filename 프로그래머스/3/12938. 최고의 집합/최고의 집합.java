import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int n, int s) {
        int[] answer = new int[n];
        if(n>s) {
            answer=new int[]{-1};
            return answer;
        }
        //n개로 이루어진 중복 집합
        //각 원소의 합이 S이면서 원소의 곱이 최대가 되는 집합
        //반환 시 오름차순
        
        //S를 n개로 나누면서?
        //n은 10000이하의 자연수. s는 100000000이하의 자연수
        //재귀는 x. dp 혹은 이분탐색?
        //dp는 아닌 것 같은데 -> 합 혹은 곱을 구하면 dp일텐데
        //배열을 기억해야하니.
        //최대 n크기의 배열을 다 dp로 남기기에는 메모리 비효율
        
        
        //15 3으로 나누면
        // 5 5 5    6 4 5
        // 125       120
        // 세 수의 분포가 적을 수록 최고의 집합에 가까움
        // 30를 7로 나누면
        // 4 4 4 4 4 4 3      4 4 4 4 4 5 5
        // 4^6 *6       4^5 *25
        int sub=s/n;// 9 2
        answer[0]=s-(sub*(n-1));
        
        for(int i=1;i<n;i++){
            
            answer[i]+=sub;
            if(answer[0]>answer[i]){
                answer[0]--;
                answer[n-i]++;
            }else if(answer[0]<answer[i]-1){
                answer[0]++;
                answer[i]--;
            }
        }
        Arrays.sort(answer);
        
        return answer;
    }
}