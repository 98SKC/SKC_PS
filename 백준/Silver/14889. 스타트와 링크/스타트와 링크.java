import java.util.*;
import java.io.*;

public class Main {
    static int[][] arr;
    static int N;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        arr = new int[N][N];
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        List<Integer> start = new LinkedList<>();
        List<Integer> link = new LinkedList<>();
        helper(start, link, 0);
        System.out.println(result);
    }

    static void helper(List<Integer> list1, List<Integer> list2, int number) {
        if (number == N) {
            if (list1.size() == N / 2 && list2.size() == N / 2) {
                result = Math.min(result, calculation(list1, list2));
            }
            return;
        }

        list1.add(number);
        helper(list1, list2, number + 1);
        list1.remove(list1.size() - 1);

        list2.add(number);
        helper(list1, list2, number + 1);
        list2.remove(list2.size() - 1);
    }

    static int calculation(List<Integer> list1, List<Integer> list2) {
        int start = 0;
        int link = 0;

        for (int i = 0; i < list1.size(); i++) {
            for (int j = i + 1; j < list1.size(); j++) {
                int a = list1.get(i);
                int b = list1.get(j);
                start += arr[a][b] + arr[b][a];
            }
        }

        for (int i = 0; i < list2.size(); i++) {
            for (int j = i + 1; j < list2.size(); j++) {
                int a = list2.get(i);
                int b = list2.get(j);
                link += arr[a][b] + arr[b][a];
            }
        }

        return Math.abs(start - link);
    }
}