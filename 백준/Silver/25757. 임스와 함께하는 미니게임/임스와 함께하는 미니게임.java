import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        String type = input[1];
        HashSet<String> friend = new HashSet<>();
        for(int i=0; i<N; i++) {
            friend.add(br.readLine());
        }

        switch (type) {
            case "Y":
                System.out.print(friend.size());
                break;
            case "F":
                System.out.print(friend.size()/2);
                break;
            case "O":
                System.out.print(friend.size()/3);
                break;
            default:
                break;
        }
        
    }
}