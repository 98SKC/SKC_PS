import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int[] arr=new int[4];
        int T=Integer.parseInt(br.readLine());




        for(int test_case=0;test_case<T;test_case++){

            double money=Double.parseDouble(br.readLine());


            arr[0]=(int)(money/25);
            money%=25;
            arr[1]=(int)(money/10);
            money%=10;
            arr[2]=(int)(money/5);
            money%=5;
            arr[3]=(int)(money/1);

            for(int i=0;i<arr.length;i++){
                System.out.print(arr[i]+" ");
            }
            System.out.println();
        }

    }
}
