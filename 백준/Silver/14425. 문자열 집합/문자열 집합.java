import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str= br.readLine().split(" ");
        int N=Integer.parseInt(str[0]);
        int M=Integer.parseInt(str[1]);
        int count=0;

        HashSet<String> set=new HashSet<>();


        for(int i=0;i<N;i++){
            set.add(br.readLine());
        }



        for(int j=0;j<M;j++){
            String sub=br.readLine();

            if(set.contains(sub)){
                count++;
            }
        }
        System.out.println(count);
    }
}
