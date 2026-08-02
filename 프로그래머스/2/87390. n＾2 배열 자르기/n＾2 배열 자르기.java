import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int n, long left, long right) {
//         int[][] map=new int[n][n];

        
        
//         for(int i=0;i<n;i++){
//             int k=i+1;
//             for(int j=0;j<n;j++){
//                 map[i][j]=k;
//             }
//         }
        
//         for(int j=1;j<n;j++){
//             int k=j+1;
//             for(int i=0;i<=j;i++){
//                 map[i][j]=k;
//             }
//         }
        
        
        long size=right-left+1;
        int[] answer=new int[(int)size];
        long N = (long) n;
        int cnt=0;
        
        for(long i=left;i<=right;i++){
        int l = (int)(i / N);
        int r = (int)(i % N);
            int p=Math.max(l,r)+1;
            answer[cnt++]=p;
        }
        
        
//         for(int[] a:map){
//             System.out.println(Arrays.toString(a));
//         }
        
        return answer;
    }
}