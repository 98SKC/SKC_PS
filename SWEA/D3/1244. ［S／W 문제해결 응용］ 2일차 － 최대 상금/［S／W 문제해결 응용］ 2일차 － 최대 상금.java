import java.util.*;
import java.io.*;
import java.lang.*;


class Solution
{
    public static int[] arr;
	public static int max;
	public static int chance;
	public static void main(String args[]) throws Exception
	{

		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String Test=br.readLine();
		int T=Integer.parseInt(Test);


		for(int test_case = 1; test_case <= T; test_case++)
		{
            String[] number=br.readLine().split(" ");
            String reward=number[0];
            chance=Integer.parseInt(number[1]);
             if(chance>reward.length()) chance = reward.length();
		
            arr=new int[number[0].length()];
            for(int i=0;i<number[0].length();i++){// 처음 수의 각 자리수를 배열에 넣고자 함.
                arr[i]=reward.charAt(i)- '0';
            }

            max=0;
            dfs(0,0,chance);

            System.out.println("#"+test_case+" "+max);

		}
	}
    
    public static void dfs(int idx, int cur, int chance){
        
        if(cur==chance){
            String s="";
            for(int k:arr){
            s+=Integer.toString(k);
            }
            max = Math.max(max,Integer.parseInt(s));
            return;
        }
        for(int i=idx;i<arr.length-1;i++){
            for(int j=i+1;j<arr.length;j++){
                 	// 큰수와 앞자리를 바꾸는게 아닌, 각 자리를 모두 바꾸는 경우의 수를 구함
                	int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                    dfs(i, cur+1,chance);//위에가 바꾸는 과정. 바꿨으니 다음 dfs는 cur+!
                 	//다음 케이스에는 원래대로 복귀
					arr[j] = arr[i];
					arr[i] = temp;
            }
        }
    }
}