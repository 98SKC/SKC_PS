import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main{

    public static int max;
    public static int[] arr;
    public static int M;
    public static int N;

    public static void main(String args[])throws IOException{

        max=0;

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        String[] str=br.readLine().split(" ");

        N=Integer.parseInt(str[0]);

        M=Integer.parseInt(str[1]);
        arr=new int[N];
        String[] str2=br.readLine().split(" ");

        for(int i=0;i<N;i++) {
            arr[i]=Integer.parseInt(str2[i]);
        }
        helper(0,0, 0);
        System.out.println(max);
    }

    public static void helper(int position, int sum, int cardCount) {
        if(sum>M || cardCount>3) return;  

        if(cardCount == 3){
            max=Math.max(max,sum);
            return;
        }

        if(position == N) return;

        helper(position+1,sum+arr[position], cardCount+1);
        helper(position+1,sum, cardCount);
    }
}
