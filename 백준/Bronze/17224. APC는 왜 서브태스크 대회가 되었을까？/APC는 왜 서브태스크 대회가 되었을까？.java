import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");	

		int n = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
			
		int[] sub1 = new int[n];
		int[] sub2 = new int[n];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			sub1[i] = Integer.parseInt(st.nextToken());
			sub2[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(sub1);
		Arrays.sort(sub2);

		int result = 0;
		int cnt = 0;
		for (int i = 0; i < n; i++) {
			if (cnt == k) break;
			
			if (l >= sub2[i]) {
				result += 140;
				cnt++;
			}				
			else if (l >= sub1[i]) {
				result += 100;
				cnt++;
			}				
		}
		System.out.println(result);
	}	
}
