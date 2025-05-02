
import java.util.*;
import java.io.*;

public class Main{

	//아래 min으로 다시
	//public static int[] number=new int[] {6,2,5,5,4,5,6,3,7,6};
	public static int N, T;
	public static long[] min;
	public static String[] max;
	//100개의 성냥개비로 만들 수 있는 가장 큰수-> 1로 이루어진 50자리수. bigInteger 혹은 문자열을 생각
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());
		min = new long[101];
		max = new String[101];

		StringBuilder sb = new StringBuilder();
		calMin();
		calMax();
		for (int i = 0; i < T; ++i) {
			N = Integer.parseInt(br.readLine());
			sb.append(min[N]+" "+max[N]+"\n");
		}
		System.out.println(sb);
		
	}

	public static void calMin() {
		Arrays.fill(min, Long.MAX_VALUE);
		min[2] = 1;
		min[3] = 7;
		min[4] = 4;
		min[5] = 2;
		min[6] = 6;
		min[7] = 8;
		min[8] = 10;
		//	숫자 	: 0 1 2 3 4 5 6 7 8 9
		//	성냥	: 6 2 5 5 4 5 6 3 7 6
		int[] count = {1, 7, 4, 2, 0, 8};
		for (int i = 9; i <= 100; ++i) {
			for (int j = 2; j <= 7; ++j) {
				min[i] = Math.min((min[i-j] * 10) + count[j-2], min[i]);
			}
		}
	}

	public static void calMax() {
		max[2] = "1";
		max[3] = "7";
		for (int i = 4; i <= 100; ++i) {
			if (i%2== 1) {
				max[i] = "7" + max[i - 3];
			} else {
				max[i] = max[i - 2] + "1";
			}
		}

	}


}