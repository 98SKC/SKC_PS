import java.util.*;
import java.io.*;

class Solution {
    public int solution(int temperature, int t1, int t2, int a, int b, int[] onboard) {
        
        
        
        int time=onboard.length;

        int answer = 100*time;
        // 배열 인덱스에 음수 들어가는걸 막는 방법으로  temp를 0으로 설정, t1, t2를 그에 맞게 설정
        // temp가 t1~t2 밖에 있으니 가능한 방법인데, 조건에 따라 t1과 t2자리가 바뀜
        // 에어컨을 키면 무조건 온도가 오른다(히터로 바꾸는 느낌) 온도가 t2 이상이면 더 올리는 것은 비효율 적
        // 그러니 최고 온도가 t2인 것으로
        
        int changeTemp=temperature>t2?t1-(temperature-t2):temperature;// 외부(초반) 온도
        t1=t1-changeTemp;// 희망 온도 최저값
        t2=t2-changeTemp;// 희망 온도 최고값
        changeTemp=0;// changeTemp-changeTemp 임
        int[][] dp=new int[time][t2+2]; //i시간 n온도일 때 최소 전력
        
        for(int i=0;i<time;i++){ 
            for(int j=0;j<t2+2;j++){ 
                dp[i][j]=987654321;
            }   
        }
        
        dp[0][0]=0;// 초반 온도는 전력 0
       // System.out.println(Arrays.toString(dp[0]));
        int min=Integer.MAX_VALUE;
        for(int i=1;i<time;i++){ 
            for(int j=0;j<t2+2;j++){
                //사람이 타고 있다면 가능한 온도는 정해져 있음. 다른건 볼 필요 없다.
                if (onboard[i] == 1 && (j < t1 || j > t2)) continue;
                
                min=987654321;

                //외부온도와 온도가 같다
                if (j == 0) {
                    //온도를 올려서 - 0도보다 온도가 낮은 경우는 없다. 스킵
                    
                    //온도 유지하기
                    min = Math.min(min, dp[i-1][j]);//0도는 에어컨을 꺼도 유지가 됨
                    //온도 내려서 오는 방법
                    if (j + 1 <= t2 + 1) min = Math.min(min, dp[i-1][j+1]);
                }
                //외부온도와 온도가 다르다
                else {
                    //온도 올리기
                    if (j - 1 >= 0) min = Math.min(min, dp[i-1][j-1] + a);
                    //온도 유지하기
                    min = Math.min(min, dp[i-1][j] + b);
                    //온도 내리기
                    if (j + 1 <= t2 + 1) min = Math.min(min, dp[i-1][j+1]);
                }
                dp[i][j] = min;
            }
            //System.out.println(Arrays.toString(dp[i]));
        }
        
        //System.out.println(Arrays.toString(dp[time-1]));
        
        for(int i=0;i<=t2;i++){ 
            answer=Math.min(answer,dp[time-1][i]);
        }
        
        return answer;
    }
}