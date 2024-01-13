import java.util.*;
import java.io.*;

class Solution
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());
        StringBuilder sb=new StringBuilder();

        for(int test_case = 1; test_case <= T; test_case++) {
            String memory = br.readLine();
            int count = 0;
            char cur = '0';

            for(int i = 0; i < memory.length(); i++) {
                if(memory.charAt(i) != cur) {
                    cur = memory.charAt(i);
                    count++;
                }
            }
            sb.append("#").append(test_case).append(" ").append(count).append("\n");
        }
        System.out.println(sb);
    }
}
