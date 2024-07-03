import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        StringBuilder sb=new StringBuilder();
        int N=Integer.parseInt(st.nextToken());
        int H=Integer.parseInt(st.nextToken());

        int sub;
        int[] prefix=new int[H+1];
        for(int i=0;i<N;i++){
            sub=Integer.parseInt(br.readLine());
            if(i%2==0){// 아래에서 위로
                prefix[1]++;
                if(sub<H){
                    prefix[sub+1]--;
                }
            }else{//위에서 아래로
                prefix[H-sub+1]++;
            }
        }
        int min=200000;
        int count=0;
        for(int i=1;i<=H;i++){
            prefix[i]+=prefix[i-1];
            if(min>prefix[i]) {
            	min=prefix[i];
            	count=1;
            }else if(min==prefix[i]){
            	count++;
            }     
        }
        sb.append(min).append(" ").append(count);;
        System.out.println(sb);
    }

}