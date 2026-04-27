import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        double n = Double.parseDouble(st.nextToken());
        double p = Double.parseDouble(st.nextToken());

        double answer = n * p * 55 / 1000.0;

        System.out.println(answer);
    }
}