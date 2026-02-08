import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] day = new int[N];
        int[] cow = new int[N];
        int[] change = new int[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            day[i] = Integer.parseInt(st.nextToken());

            String name = st.nextToken();
            if (name.equals("Bessie")) cow[i] = 0;
            else if (name.equals("Elsie")) cow[i] = 1;
            else cow[i] = 2;

            change[i] = Integer.parseInt(st.nextToken());
        }

       
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (day[i] > day[j]) {
                    swap(day, i, j);
                    swap(cow, i, j);
                    swap(change, i, j);
                }
            }
        }

        
        int[] milk = {7, 7, 7};

        
        boolean[] prev = {true, true, true};

        int answer = 0;

        for (int i = 0; i < N; i++) {
            milk[cow[i]] += change[i];

            int max = Math.max(milk[0], Math.max(milk[1], milk[2]));

            boolean[] curr = new boolean[3];
            for (int j = 0; j < 3; j++) {
                if (milk[j] == max) curr[j] = true;
            }

            
            if (!same(prev, curr)) {
                answer++;
                prev = curr;
            }
        }

        System.out.println(answer);
    }

    
    static boolean same(boolean[] a, boolean[] b) {
        for (int i = 0; i < 3; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }

    static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    
}
