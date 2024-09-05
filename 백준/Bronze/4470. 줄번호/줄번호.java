import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int testCase = Integer.parseInt(br.readLine());
        List<String> inputList = new ArrayList<>();
        for (int i = 0; i < testCase; i++) {
            inputList.add(br.readLine());
        }
        System.out.print(solution(testCase, inputList));
    }

    public static String solution(int testCase, List<String> inputList) {
        StringBuilder sb = new StringBuilder();
        IntStream.range(0, testCase)
                .forEach(n -> sb
                        .append(n + 1)
                        .append(". ")
                        .append(inputList.get(n))
                        .append("\n"));

        if (sb.length() > 0) {
            sb.setLength(sb.length() - 1);
        }
        return sb.toString();
    }
}

