import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
 
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
 
		int T = Integer.parseInt(br.readLine());
		String str;
		String answer;
		boolean check;
 
		 for(int test_case=0;test_case<T;test_case++) {
			check=true;
			 str=br.readLine();

			int count = 0;
			 
			for (char c : str.toCharArray()) {
	 
				// 여는 괄호일 경우 카운트 증가
				if (c == '(') {
					count++;
				}
	 
				// 아래는 모두 닫는 괄호. 
				// count 가 0인 경우. 즉, 닫는 괄호를 입력받았으나 pop할 원소가 없을 경우
				else if (count == 0) {
					answer= "NO";
					check=false;
					break;
				}
				// 그 외의 경우 count를 감소.
				else {
					count--;
				}
			}
	 
			/*
			 * 모든 검사 마치고도 남았으면 (count > 0), 여는 괄호가 많은 경우는 "NO" 
			 * 요소가 비어있으면(count = 0) 온전한 수식이므로 "YES" .
			 */
	 
			if (count == 0&&check) {
				answer= "YES";
			} 
			else {
				answer= "NO";
			}
			sb.append(answer).append('\n');
		}
		System.out.println(sb);
 
	}

}