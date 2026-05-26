import java.util.Arrays;

class Solution {
    public int[] solution(int n) {
        int[] answer=new int[n];
        int test=0; 
        int sub=0;
        
        for(int i=1;i<=n;i++){
            if(n%i==0) answer[sub++]=i;
        }
        
        return Arrays.copyOf(answer,sub);
    }
}