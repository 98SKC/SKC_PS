import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<Integer,Integer> map = new HashMap<>();
        int N = Integer.parseInt(br.readLine());

        int sub;
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++){
            sub = Integer.parseInt(st.nextToken());
            map.put(sub, map.getOrDefault(sub, 0) + 1);
        }
        int M = Integer.parseInt(br.readLine());

        int number;

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int j = 0; j < M; j++){
            number = Integer.parseInt(st2.nextToken());
            if(map.containsKey(number)){
                sb.append(map.get(number)).append(" ");
            }else{
                sb.append(0).append(" ");
            }
        }
        System.out.println(sb);
    }
}
