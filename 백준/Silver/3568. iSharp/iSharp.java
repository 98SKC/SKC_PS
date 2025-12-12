import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static StringBuilder result = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        String[] tokens = input.split(" ");

        for (int i = 1; i < tokens.length; i++) {
            parseVariable(tokens[0], tokens[i]);
        }

        System.out.println(result.toString());
    }

    public static void parseVariable(String type, String str) {
        String varName = "";
        StringBuilder modifier = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch == '*' || ch == '&') {
                modifier.append(ch);
            } else if (ch == '[') {
                modifier.append(']');
            } else if (ch == ']') {
                modifier.append('[');
            } else if (Character.isLetter(ch)) {
                varName += ch;
            }
        }

        result.append(type)
              .append(modifier.reverse())
              .append(" ")
              .append(varName)
              .append(";\n");
    }
}
