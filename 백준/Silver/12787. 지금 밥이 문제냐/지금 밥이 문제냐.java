import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcase = Integer.parseInt(br.readLine());
		StringBuilder answer = new StringBuilder();
		for(int tc = 0; tc<testcase; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int isCode = Integer.parseInt(st.nextToken()); 
			if (isCode == 1) { 
				StringBuilder bin = new StringBuilder();
                st = new StringTokenizer(st.nextToken(), ".");
                for (int i = 0; i < 8; i++) {
                    int num = Integer.parseInt(st.nextToken());
                   
                    String part = String.format("%8s", Integer.toBinaryString(num))
                                         .replace(' ', '0');
                    bin.append(part);
                }
                BigInteger value = new BigInteger(bin.toString(), 2);
                answer.append(value).append("\n");
			}else {
				BigInteger number = new BigInteger(st.nextToken());
                String bin = String.format("%64s", number.toString(2))
                                   .replace(' ', '0');

                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < 8; i++) {
                    String part = bin.substring(i * 8, (i + 1) * 8);
                    int num = Integer.parseInt(part, 2);
                    sb.append(num);
                    if (i < 7) sb.append(".");
                }
                answer.append(sb).append("\n");
			}
		}
		System.out.println(answer);
	}
}