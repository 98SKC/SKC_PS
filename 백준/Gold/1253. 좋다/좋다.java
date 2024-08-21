import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] numbers = new int[N];
        for(int i=0;i<N;i++){
            numbers[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(numbers);
        int result = 0;
        for(int i = 0 ; i < N ; i++){
            int left = 0;
            int right = N-1;    // 음수값이 있음에 유의!
            while(true){
                // 현재 나(i)의 위치에 있는 경우
                if(left == i) left++;
                else if(right == i) right--;

                if(left >= right) break;

                if(numbers[left] + numbers[right] > numbers[i]) right--;
                else if(numbers[left] + numbers[right] < numbers[i]) left++;
                else{      // 좋다!
                    result++;
                    break;
                }
            }
        }
        System.out.println(result);
    }

}