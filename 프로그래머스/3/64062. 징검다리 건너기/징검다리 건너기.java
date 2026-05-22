import java.util.*;
import java.io.*;




class Solution{
    public int solution(int[] stones, int k) {

        int answer = 0;


        //모든 구간을 1씩 일괄감소 시켰을 때,
        //연속적으로 0인 구간이 k를 넘는
        //cnt값을 구하라.

        //최대 cnt는 20만.
        //돌의 숫자는 2억.
        int left=1;
        int right=200000000;

        while(left<=right){
            int mid=left+(right-left)/2;

            boolean possible=helper(stones,k,mid);
            if(possible){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }

        answer=right;



        return answer;
    }

    public static boolean helper(int[] stones,int K, int minus){
        int continuous=0;
        for(int i=0;i<stones.length;i++){
            if(continuous>=K) return false;

            if(stones[i]-minus<0) continuous++;
            else continuous=0;

        }

        if(continuous>=K) return false;
        return true;
    }
}