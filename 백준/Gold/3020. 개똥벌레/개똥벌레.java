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

        int up=H;
        int douwn=1;
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


        for(int i=1;i<=H;i++){
            prefix[i]+=prefix[i-1];

        }

        Arrays.sort(prefix);
        int min=prefix[1];
        int count=1;
        for(int i=2;i<=H;i++){
            if(prefix[i]==min) count++;
            else break;
        }
        sb.append(min+"\n"+count);

        System.out.println(sb);



        //System.out.println("hello");
    }

}
