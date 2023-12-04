import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        HashSet<Integer> set=new HashSet<>();
        int N=Integer.parseInt(br.readLine());
        String[] str= br.readLine().split(" ");
        for(int i=0;i<N;i++){
            set.add(Integer.parseInt(str[i]));
        }

        int M=Integer.parseInt(br.readLine());

        String[] str2=br.readLine().split(" ");
        for(int j=0;j<M;j++){
            int sub=Integer.parseInt(str2[j]);
            if(set.contains(sub)){
                System.out.print(1+" ");
            }else{
                System.out.print(0+" ");
            }

        }


    }
}
