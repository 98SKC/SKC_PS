import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        for (int k = 0; k < 26; k++) {
            StringBuilder shifted = new StringBuilder();
            for (int i = 0; i < line.length(); i++) {
                char c = line.charAt(i);
                if ('A' <= c && c <= 'Z') {
                    shifted.append((char)('A' + (c - 'A' + k) % 26));
                } else {
                    shifted.append(c);
                }
            }

            String s = shifted.toString();
            boolean hasChipmunks = false;
            boolean hasLive = false;
            StringBuilder word = new StringBuilder();

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if ('A' <= c && c <= 'Z') {
                    word.append(c);
                } else {
                    if (word.toString().equals("CHIPMUNKS")) hasChipmunks = true;
                    if (word.toString().equals("LIVE")) hasLive = true;
                    word.setLength(0);
                }
            }
            
            if (word.toString().equals("CHIPMUNKS")) hasChipmunks = true;
            
            if (word.toString().equals("LIVE")) hasLive = true;

            if (hasChipmunks && hasLive) {
                System.out.println(s);
                return;
            }
        }
    }
}
