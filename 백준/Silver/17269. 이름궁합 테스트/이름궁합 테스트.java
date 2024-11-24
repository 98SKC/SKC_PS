import java.util.StringTokenizer;
import java.io.*;
 
public class Main {
	public static int answer1 = 0;
	public static int answer2 = 0;
 
	public static void main(String[] args) throws IOException {
 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
        
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
        	st = new StringTokenizer(br.readLine());
		String str1 = st.nextToken();
		String str2 = st.nextToken();
 
		int[] vals = { 3, 2, 1, 2, 4, 3, 1, 3, 1, 1, 3, 1, 3, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1 };
		String newStr = "";
		int maxLength = 0;
		String result;
        
        	if (N > M)
			maxLength = N;
		else
			maxLength = M;
        
        // 새로 문자열 조합하면서 남은 문자열 뒤에 붙이기
        	for (int i = 0; i < maxLength; i++) {
			if (N > i)
				newStr = newStr + str1.charAt(i);
			if (M > i)
				newStr = newStr + str2.charAt(i);
		}
 
		int[] newStrAlb = new int[newStr.length()];
		int[] newStrVals = new int[newStr.length()];
		
        // 아래 for문 2개로 새로 조합한 문자열의 알파벳을 숫자값으로 변경
		for (int i = 0; i < newStr.length(); i++)
			newStrAlb[i] = newStr.charAt(i) - 'A';
 
		for (int i = 0; i < newStrVals.length; i++)
			newStrVals[i] = vals[newStrAlb[i]];
        
        // 숫자값 2개 남을때까지 합산
		dfs(newStrVals, true);
 
        // 십의 자리 0인 경우 처리
		if (answer1 == 0)
			result = "" +answer2+"%" ;
		else
			result = answer1 + "" + answer2 + "%";
        
		bw.write(result);
		br.close();
		bw.flush();
		bw.close();
	} // Main
 
	public static void dfs(int[] vals, boolean flag) {
		if (vals.length > 2 && flag == true) {
			flag = true;
			int[] tmp = new int[vals.length - 1];
			for (int i = 0; i < vals.length - 1; i++) {
				tmp[i] = vals[i] + vals[i + 1];
				if (tmp[i] > 0 && tmp[i] >= 10)
					tmp[i] = tmp[i] % 10;
			}
			dfs(tmp, flag);
		} else {
			answer1 = vals[0];
			answer2 = vals[1];
			flag = false;
			return;
		}
	} 
} 