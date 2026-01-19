import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String vowels = "aiyeou";
        String consonants = "bkxznhdcwgpvjqtsrlmf";

        HashMap<Character, Integer> vowelPoint = new HashMap<>();
        HashMap<Character, Integer> consonantPoint = new HashMap<>();

        for (int i = 0; i < vowels.length(); i++) {
            vowelPoint.put(vowels.charAt(i), i);
        }
        for (int i = 0; i < consonants.length(); i++) {
            consonantPoint.put(consonants.charAt(i), i);
        }

      
        String str;
        while ((str = br.readLine()) != null) {
            StringBuilder sb = new StringBuilder();
            int len = str.length();
            int vp = 0;
            int cp = 0;
            char c;

            for (int i = 0; i < len; i++) {
                c = str.charAt(i);
                char lower = Character.toLowerCase(c);

                if (vowelPoint.containsKey(lower)) {
                    vp = vowelPoint.get(lower) - 3;
                    if (vp < 0) vp += 6;

                    char mapped = vowels.charAt(vp);
                    if (Character.isUpperCase(c)) {
                        sb.append(Character.toUpperCase(mapped));
                    } else {
                        sb.append(mapped);
                    }
                } else if (consonantPoint.containsKey(lower)) {
                    cp = consonantPoint.get(lower) - 10;
                    if (cp < 0) cp += 20;

                    char mapped = consonants.charAt(cp);
                    if (Character.isUpperCase(c)) {
                        sb.append(Character.toUpperCase(mapped));
                    } else {
                        sb.append(mapped);
                    }
                } else {
                    sb.append(c);
                }
            }
            System.out.println(sb.toString());
        }
    }
}