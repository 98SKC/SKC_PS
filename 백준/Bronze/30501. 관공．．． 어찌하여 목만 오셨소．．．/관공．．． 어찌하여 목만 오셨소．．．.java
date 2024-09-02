import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main extends Exception {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int num = Integer.parseInt(br.readLine());
        String answer = "";

        for (int i = 0; i < num; i++) {
            String str = br.readLine();

            if (str.contains("S")){
                answer = str;
            }
        }

        sb.append(answer);
        System.out.println(sb.toString());
    }
}