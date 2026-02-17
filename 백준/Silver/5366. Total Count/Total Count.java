import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

// LinkedHashMap 한 번 사용해보기
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        int grandTotal = 0;
        
        while (true) {
            String input = br.readLine();
            
            if (input.equals("0")) {
                break;
            }
            
            map.put(input, map.getOrDefault(input, 0) + 1);
            grandTotal++;
        }
        
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        
        System.out.println("Grand Total: " + grandTotal);
    }
}
