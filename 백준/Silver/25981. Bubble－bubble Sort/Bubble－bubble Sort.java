import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][2]; 

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = i;
        }

     
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[0] == b[0]) {
                    return Integer.compare(a[1], b[1]);
                }
                return Integer.compare(a[0], b[0]);
            }
        });

        int maxHours = 0;
        int moveLimit = k - 1;

        for (int sortedIndex = 0; sortedIndex < n; sortedIndex++) {
            int originalIndex = arr[sortedIndex][1];
            int distance = originalIndex - sortedIndex;

            if (distance > 0) {
                int hours = (distance + moveLimit - 1) / moveLimit; 
                if (hours > maxHours) maxHours = hours;
            }
        }

        System.out.println(maxHours);
    }
}