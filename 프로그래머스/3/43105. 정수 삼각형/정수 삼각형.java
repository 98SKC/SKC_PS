import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int len=triangle.length;
        int row=0;
        
        for(int i=1;i<len;i++){// 삼각형 높이만큼 
            row=triangle[i].length;// 해당 높이의 개수만큼
            for(int j=0;j<row;j++){
                if(j==0){
                    triangle[i][j]=triangle[i-1][0]+triangle[i][j];
                }else if(j==(row-1)){
                    triangle[i][j]=triangle[i-1][j-1]+triangle[i][j];
                }else{
                    triangle[i][j]=Math.max(triangle[i-1][j-1],triangle[i-1][j])+triangle[i][j];
                }
                answer=Math.max(answer,triangle[i][j]);
            }
        }
       // System.out.println(Arrays.toString(triangle[row-1]));
        return answer;
    }
}