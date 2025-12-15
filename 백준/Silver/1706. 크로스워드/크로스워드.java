import java.io.*;
import java.util.*;

public class Main { 

	public static void main(String[] args) throws IOException {
		
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		char arr[][] = new char[r][c];
		ArrayList<String> list = new ArrayList<>();
        
        for (int i = 0; i < r; i++) {
			String str = bf.readLine();
			for (int j = 0; j < c; j++) {
				arr[i][j] = str.charAt(j);
			}
		}

  
		for (int i = 0; i < r; i++) {
			String temp = "";
			for (int j = 0; j < c; j++) {
				if (arr[i][j] != '#') {
					temp += arr[i][j];
				} else {
					if (temp.length() > 1) {
						list.add(temp);
					}
					temp = "";
				}
			}
			if (temp.length() > 1) {
				list.add(temp);
			}
		}

		for (int i = 0; i < c; i++) {
			String temp = "";
			for (int j = 0; j < r; j++) {
				if (arr[j][i] != '#') {
					temp += arr[j][i];
				} else {
					if (temp.length() > 1) {
						list.add(temp);
					}
					temp = "";
				}
			}
			if (temp.length() > 1) {
				list.add(temp);
			}
		}

		Collections.sort(list);
		System.out.println(list.get(0));

	}
}
