import java.util.*;
import java.io.*;

public class Main {

	static long answer=0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Long> positives = new ArrayList<>();
        List<Long> negatives = new ArrayList<>();
        boolean hasZero = false;
        long oneCount = 0;

        for (int i = 0; i < N; i++) {
            long num = Long.parseLong(br.readLine());
            if (num > 1) {
                positives.add(num);
            } else if (num < 0) {
                negatives.add(num);
            } else if (num == 1) {
                oneCount++;
            } else {
                hasZero = true;
            }
        }

        Collections.sort(positives, Collections.reverseOrder());
        Collections.sort(negatives);


        for (int i = 0; i < positives.size(); i += 2) {
            if (i + 1 < positives.size()) {
                answer += positives.get(i) * positives.get(i + 1);
            } else {
                answer += positives.get(i);
            }
        }


        for (int i = 0; i < negatives.size(); i += 2) {
            if (i + 1 < negatives.size()) {
                answer += negatives.get(i) * negatives.get(i + 1);
            } else if (!hasZero) {
                answer += negatives.get(i);
            }
        }

        answer += oneCount;

        System.out.println(answer);
    }
    
    
}