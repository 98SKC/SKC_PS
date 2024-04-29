import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws Exception {

        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final StringTokenizer st = new StringTokenizer(br.readLine());

        final List<Integer> numA = Arrays.stream(st.nextToken().split("")).map(Integer::parseInt).collect(Collectors.toList());
        final List<Integer> numB = Arrays.stream(st.nextToken().split("")).map(Integer::parseInt).collect(Collectors.toList());

        long sum = 0;
        for (int elemA : numA) {
            for (int elemB : numB) {
                sum += elemA * elemB;
            }
        }

        System.out.print(sum);

    }
}