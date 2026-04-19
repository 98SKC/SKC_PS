import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.Function;

public class Main {
    private static final int LIMIT = 1_000_000_007;
    private static final int BLOCK = 0;
    private static final int NOT_VALID = -1;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int m = stoi.apply(st.nextToken());
        int[][] map = new int[n][m];
        int[][] dp = new int[n][m];
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < m ; j++){
                map[i][j] = stoi.apply(st.nextToken());
                dp[i][j] = NOT_VALID;
            }
        }
        int result = 0;
        for(int i = 0 ; i < m ; i++){
            if(map[0][i] == BLOCK){
                continue;
            }
            result += cal(0,i,n,m,map,dp);
            result %= LIMIT;
        }
        System.out.println(result);
    }

    private static int cal(int y, int x, int n, int m, int[][] map, int[][] dp) {
        if(y == n-1){
            return 1;
        }
        if(dp[y][x] != NOT_VALID){
            return dp[y][x];
        }
        int result = 0;
        for(int i = -1 ; i <= 1 ; i++){
            int ny = y +1;
            int nx = x + i;
            if(nx < 0 || nx >= m || map[ny][nx] == BLOCK){
                continue;
            }
            result += cal(ny,nx,n,m,map,dp);
            result %= LIMIT;
        }
        dp[y][x] = result;
        return result;
    }
}