import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int bestIndex = 0;
        int minDist = Integer.MAX_VALUE;

        for (int i = 1; i <= k; i++) {
            st = new StringTokenizer(br.readLine());
            int f = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            // (f - 1) + ((m + 1) - d)
            int dist = (f - 1) + ((m + 1) - d);

            if (dist < minDist) {
                minDist = dist;
                bestIndex = i;
            }
        }

        System.out.print(bestIndex);
    }
}
