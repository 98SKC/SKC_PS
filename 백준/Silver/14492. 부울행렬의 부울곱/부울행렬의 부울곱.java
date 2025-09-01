import java.io.*;
import java.util.*;

public class Main {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());

        boolean[][] arr1 = initArr(n);
        boolean[][] arr2 = initArr(n);
        boolean[][] arr3 = boolArrMultiplication(n, arr1, arr2);
    }

    private static boolean[][] boolArrMultiplication(int arrSize, boolean[][] arr1, boolean[][] arr2) {
        boolean[][] arr = new boolean[arrSize][arrSize];
        int count = 0;
        for (int i =0; i<arrSize;i++){
            for (int j =0; j<arrSize;j++){
                arr[i][j] = false;
                for (int k =0; k<arrSize;k++){
                    if(arr1[i][k] == true && arr2[k][j] == true){
                        arr[i][j] = true;
                        count++;
                        k = arrSize;
                    }
                }
            }
        }
        System.out.println(count);
        return arr;
    }

    static boolean[][] initArr(int arrSize) throws IOException {
        boolean[][] arr = new boolean[arrSize][arrSize];
        for (int i = 0; i < arrSize; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int j = 0;
            while (st.hasMoreTokens()) {
                if (st.nextToken().equals("0")) {
                    arr[i][j] = false;
                } else {
                    arr[i][j] = true;
                }
                j++;
            }
        }
        return arr;
    }

}
