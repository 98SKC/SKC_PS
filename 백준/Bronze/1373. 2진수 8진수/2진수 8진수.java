import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String bin = br.readLine().trim();

        int r = bin.length() % 3;
        if (r == 1)      bin = "00" + bin;
        else if (r == 2) bin = "0"  + bin;


        StringBuilder sb = new StringBuilder(bin.length() / 3);
        for (int i = 0; i < bin.length(); i += 3) {
            int v = (bin.charAt(i)   - '0') * 4
                  + (bin.charAt(i+1) - '0') * 2
                  + (bin.charAt(i+2) - '0');
            sb.append((char)('0' + v));
        }

        System.out.println(sb);
    }
}
