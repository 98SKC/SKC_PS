import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
        
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String answer=br.readLine();
		String find=br.readLine();
		int alen=answer.length();
		
		int flen=find.length();
		
		int count=0;
		for(int i=0;i<=alen-flen;i++) {
			if(answer.substring(i, i + flen).equals(find)) {
				count++;
				i += flen-1;  // 일치하면 find 문자열의 길이만큼 건너뜀
			}
		}
		  System.out.println(count);
		
	}
}