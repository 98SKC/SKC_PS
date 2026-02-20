import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int h = Integer.parseInt(br.readLine());
        int eight = h / 2;
        h %= 2;

        if (eight == 0 && h == 0) {
            System.out.println(1);
        } else if (eight == 0 && h == 1) {
            System.out.println(0);
        } else {
            for (int i = 0; i < h; i++) {
                System.out.print(4);
            }
            for (int i = 0; i < eight; i++) {
                System.out.print(8);
            }
        }
    }
}