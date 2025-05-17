import java.util.*;
import java.io.*;


class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;

        //그리디 같은데
        //stations은 이미 설치 된 곳. w는 범위 n은 인덱스 1부터 배열크기
        //2*w

        // left~ start까지 몇칸인지
        int start=1;
        int end=n;
        //2*w+1이 범위 크기
        int range=2*w+1;
        for(int pos:stations){
            int subEnd=pos-w-1;//
            // answer+=(subEnd-start+1)/range;
            // if((subEnd-start+1)%range!=0) answer++;
       
            int empty = subEnd - start + 1;
            if (empty > 0) {
                answer += empty / range;
                if (empty % range != 0) answer++;
            }
            start=pos+w+1;//지금 설치된 기지국 범위 중 가장 끝 다음
        }
        
        if(start<=end){
            answer+=(end-start+1) / range;
            if((end-start+1)%range!=0) answer++;
        }



        return answer;
    }
    //1는 1일때  w는 5
    //1 2 3 4 5 i<1+5 i=5부터
    //1+(5-1)=5;
    /*
            int subEnd=pos-w-1;// 6
            answer+=(6-1+1)/5+1;
            start=pos+w+1;//지금 설치된 기지국 범위 중 가장 끝 다음
    */
    // 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
    //             0 0 0 0  0 
 }