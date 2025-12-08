import java.io.*;

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String pattern = br.readLine();
		String[] pArr = pattern.split("\\*");	
		
		for (int i = 0; i < N; i++) {
			String str = br.readLine();	

			if (pArr[0].length() + pArr[1].length() > str.length()) {
				System.out.println("NE");
				continue;
			}
			
			String front = str.substring(0, pArr[0].length());	//파일이름 앞부분
			String back = str.substring(str.length()-pArr[1].length(), str.length());	//파일이름 뒷부분
			
			if (front.equals(pArr[0]) && back.equals(pArr[1])) {	//앞, 뒤 모두 패턴과 같다면 일치
				System.out.println("DA");
			} else {
				System.out.println("NE");
			}
		}
	}
}