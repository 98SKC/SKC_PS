import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(br.readLine());
        int testCaseCount = Integer.parseInt(tokenizer.nextToken());

        for (int testCase = 0; testCase < testCaseCount; testCase++) {
            tokenizer = new StringTokenizer(br.readLine());
            long totalFeed = Long.parseLong(tokenizer.nextToken()); // 전체 사료 양

            long[] dailyConsumption = new long[6];
            long currentConsumptionSum = 0;
            int dayCount = 1;

            tokenizer = new StringTokenizer(br.readLine());
            for (int i = 0; i < 6; i++) {
                dailyConsumption[i] = Long.parseLong(tokenizer.nextToken());
                currentConsumptionSum += dailyConsumption[i];
            }

            while (currentConsumptionSum <= totalFeed) {
                currentConsumptionSum *= 4;
                dayCount++;
            }

            System.out.println(dayCount);
        }

   
    }
}
