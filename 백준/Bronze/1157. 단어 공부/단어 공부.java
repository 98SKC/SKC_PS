import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        String str=br.readLine();
        int[] arr=new int[26];
        char answer='?';

        for(int i=0;i<str.length();i++){
            if(('A' <= str.charAt(i) && str.charAt(i) <= 'Z') ){// 대문자면
                arr[str.charAt(i)-'A']++;
            }else{
                arr[str.charAt(i)-'a']++;
            }
        }
        int max=-1;
        for(int i=0;i<arr.length;i++){
            if(max<arr[i]){
                max=arr[i];
                answer=(char) (i + 65);
            }else if(max==arr[i]){
                answer='?';
            }
        }
        System.out.println(answer);


    }
}
