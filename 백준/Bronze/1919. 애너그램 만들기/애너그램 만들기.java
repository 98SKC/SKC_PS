
import java.util.*;
import java.io.*;

public class Main {

	
	//문자열 생 기초부터 재활하기 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //단어의 순서를 바꿔 같아질 수 있으면 두 단어는 애너그램이다.
        
        String first=br.readLine();
        String second=br.readLine();

        int[] freq = new int[26];

        // 첫 문자열은 +1, 두 번째 문자열은 –1
        for (char c : first.toCharArray())  freq[c - 'a']++;
        for (char c : second.toCharArray()) freq[c - 'a']--;

        // 절대값의 합이 정답
        int answer = 0;
        for (int v : freq) answer += Math.abs(v);

        System.out.println(answer);
    }
    
}
