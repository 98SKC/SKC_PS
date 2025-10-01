import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, L, ent=0, max=0, cnt=0;
    static String str;
    
    public static void main(String args[]) throws IOException{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
            
        for(int i=0;i<N;i++){
            cnt=0;
            str = br.readLine();
            for(int j=0;j<L;j++){
                if(str.charAt(j) == '1'){
                    if(j==0){
                        cnt++;
                    }else{
                        if(str.charAt(j-1)=='0'){
                            cnt++;
                        }
                    }
                }
            }
            if(max<cnt){
                max = cnt;
                ent = 1;
            }else if(max == cnt){
                ent++;
            }
        }
        System.out.print(max + " "+ ent);
    }
}