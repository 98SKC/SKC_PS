import java.io.*;
 
public class Main {
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = br.readLine();
 
        int open = 0;
        int ans = 0;
 
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
 
            if (c == '(') { 
                open++;
            } else { 
                open--; 
 
                if (input.charAt(i - 1) == '(') { 
                    ans += open; 
                } else { 
                    ans++; 
                }
            }
        }
 
        bw.write(ans + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
 
}
