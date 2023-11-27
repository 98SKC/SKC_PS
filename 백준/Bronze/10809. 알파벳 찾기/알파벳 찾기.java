import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int[] arr=new int[26];
        Arrays.fill(arr,-1);// 배열을 채우기.
        String str=br.readLine();

        for(int i=0;i<str.length();i++){
            int position=str.charAt(i)-'a';// char->int 묵시적 형변환
            if(arr[position]==-1){
                arr[position]=i;
            }
        }
        for(int j:arr){
            System.out.print(j+" ");
        }

    }
}