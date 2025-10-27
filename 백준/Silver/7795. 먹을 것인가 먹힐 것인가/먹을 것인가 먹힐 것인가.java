import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer;
        StringBuilder sb = new StringBuilder();

        int testCases = Integer.parseInt(br.readLine()); // 테스트 케이스 수
        //이분탐색 재활하기. 
        for (int tc = 0; tc < testCases; tc++) {
            tokenizer = new StringTokenizer(br.readLine());
            int lenA = Integer.parseInt(tokenizer.nextToken());
            int lenB = Integer.parseInt(tokenizer.nextToken());

            int[] arrA = new int[lenA];
            int[] arrB = new int[lenB];

            tokenizer = new StringTokenizer(br.readLine());
            for (int i = 0; i < lenA; i++) {
                arrA[i] = Integer.parseInt(tokenizer.nextToken());
            }

            tokenizer = new StringTokenizer(br.readLine());
            for (int i = 0; i < lenB; i++) {
                arrB[i] = Integer.parseInt(tokenizer.nextToken());
            }

            Arrays.sort(arrB);

            int totalPairs = 0;
            for (int a : arrA) {
                int left = 0, right = lenB - 1;
                int lessCount = 0;

                while (left <= right) {
                    int mid = (left + right) >>> 1; // (left+right)/2 의 안전한 버전
                    if (arrB[mid] < a) {
                        left = mid + 1;
                        lessCount = mid + 1; // a보다 작은 원소 개수
                    } else {
                        right = mid - 1;
                    }
                }
                totalPairs += lessCount;
            }

            sb.append(totalPairs).append('\n');
        }

        System.out.print(sb.toString());
    }
}
