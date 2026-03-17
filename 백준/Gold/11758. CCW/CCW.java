
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int x1, x2, x3;
        int y1, y2, y3;

        x1 = Integer.parseInt(st.nextToken());
        y1 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        x2 = Integer.parseInt(st.nextToken());
        y2 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        x3 = Integer.parseInt(st.nextToken());
        y3 = Integer.parseInt(st.nextToken());

        long result = calDir(x1, y1, x2, y2, x3, y3);

        if (result > 0) {
            System.out.println(1);
        } else if (result < 0) {
            System.out.println(-1);
        } else {
            System.out.println(0);
        }
    }
    //벡터 방향으로 풀기 a*d - b*c
    public static long calDir(int x1, int y1, int x2, int y2, int x3, int y3) {
        long m1 = x2 - x1;
        long c1 = y2 - y1;
        long m2 = x3 - x2;
        long c2 = y3 - y2;

        return m1 * c2 - c1 * m2;
    }
}