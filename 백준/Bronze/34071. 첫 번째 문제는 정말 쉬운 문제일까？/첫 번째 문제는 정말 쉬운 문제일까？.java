import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] problem_level = new int[N];

        for (int i = 0; i < N; i++) {
            problem_level[i] = sc.nextInt();
        }

        int min = problem_level[0];
        int max = problem_level[0];

        for (int i = 1; i < N; i++) {
            if (problem_level[i] < min) {
                min = problem_level[i];
            }
            if (problem_level[i] > max) {
                max = problem_level[i];
            }
        }

        if (problem_level[0] == min) {
            System.out.println("ez");
        } else if (problem_level[0] == max) {
            System.out.println("hard");
        } else {
            System.out.println("?");
        }

        sc.close();
    }
}