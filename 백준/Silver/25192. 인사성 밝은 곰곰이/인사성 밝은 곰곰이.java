import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        HashSet<String> set = new HashSet<>();
        int count = 0;

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            if (str.equals("ENTER")) {
                // ENTER를 만날 때마다 새로운 채팅 시작
                count += set.size(); // 곰곰티콘 사용 횟수 추가
                set.clear(); // 채팅방 초기화
            } else {
                // 유저 닉네임 추가
                set.add(str);
            }
        }

        count += set.size(); // 마지막 채팅방 처리
        System.out.println(count);
    }
}


