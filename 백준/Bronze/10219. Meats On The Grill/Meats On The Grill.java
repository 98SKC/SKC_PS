import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int T;
    static int H, W;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for(int i=0;i<T;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            StringBuilder sb = new StringBuilder();
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            for(int h=0;h<H;h++){
                String line = br.readLine();
                for(int w=W-1;w>=0;w--){
                    sb.append(line.charAt(w));
                }
                sb.append("\n");
            }
            System.out.println(sb);
        }
    }
}
