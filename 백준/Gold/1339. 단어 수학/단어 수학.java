import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[] alpha=new int[26];
    static List[] list=new List[8];

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());

        for(int i=0;i<8;i++){
            list[i]=new ArrayList<Integer>();
        }
        String str;
        int ten;
        int answer=0;
        for(int i=0;i<N;i++){
            str=br.readLine();
            ten=1;
            for(int j=str.length()-1;j>=0;j--){
                alpha[str.charAt(j)-'A']+=ten;
                ten*=10;
            }
        }
        Arrays.sort(alpha);
        int idx=9;
        for(int a=alpha.length-1;a>=0;a--){
            answer+=idx*alpha[a];
            idx--;
        }

//        for(int a:alpha){
//            System.out.print(a+" ");
//        }
//        System.out.println();
        System.out.println(answer);

    }


}
