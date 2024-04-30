import java.io.*;
 import java.util.Stack;

 public class Main {
     static int[][] lcs;
     static StringBuilder sb = new StringBuilder();
     
     public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


         char[] str1 = br.readLine().toCharArray();
         char[] str2 = br.readLine().toCharArray();

         int length_1 = str1.length;
         int length_2 = str2.length;

         lcs = new int[length_1 + 1][length_2 + 1];

         for(int i = 1; i <= length_1; i++) {
             for(int j = 1; j <= length_2; j++) {
                 if(str1[i - 1] == str2[j - 1]) {
                     lcs[i][j] = lcs[i - 1][j - 1] + 1;
                 } else {
                     lcs[i][j] = Math.max(lcs[i - 1][j], lcs[i][j - 1]);
                 }
             }
         }
         int[] answer=new int[]{length_1,length_2};
         Stack<Character> st = new Stack<>();
         while (length_1 > 0 && length_2 > 0) {
             if (lcs[length_1][length_2] == lcs[length_1 - 1][length_2]) {
            	 length_1--;
             } else if (lcs[length_1][length_2] == lcs[length_1][length_2 - 1]) {
            	 length_2--;
             } else {
                 st.push(str1[length_1-1]);
                 length_1--;
                 length_2--;
             }
         }
         while (!st.isEmpty()) {
             sb.append(st.pop());
         }
         System.out.println(lcs[answer[0]][answer[1]]);
         System.out.println(sb);
     }

 }