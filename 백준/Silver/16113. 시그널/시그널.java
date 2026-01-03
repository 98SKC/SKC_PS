
import java.util.*;
import java.io.*;

public class Main {

	
	public static char[][][] number=new char[10][5][3];
	public static char[][] map;
	public static int N;
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        
        N=Integer.parseInt(br.readLine());
        
        String signal=br.readLine();
        int len=N/5;
        map=new char[5][len];
        int answer;
        int left=0;
        init();
        
    
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < len; j++) {
                map[i][j] = signal.charAt(i * len + j);
            }
        }
        
        
        while (left < len) {

            // 공백이면 그냥 한 칸 이동
            if (map[0][left] == '.') {
                left++;
                continue;
            }

            // 숫자 1 판별
            if (isOne(left)) {
                sb.append(1);
                left += 2; // 1칸 + 공백
                continue;
            }

            // 나머지 숫자
            answer = calNumber(left);
            sb.append(answer);

            // 3칸 숫자 + 공백 1칸
            left += 4;
        }
        
        System.out.println(sb);
        
    }
    public static boolean isOne(int left) {
        // 왼쪽 세로줄 5칸이 전부 #
        for (int i = 0; i < 5; i++) {
            if (map[i][left] != '#') return false;
        }

        // 오른쪽 칸이 존재하면 전부 . 이어야 함
        if (left + 1 < map[0].length) {
            for (int i = 0; i < 5; i++) {
                if (map[i][left + 1] != '.') return false;
            }
        }

        return true;
    }
    
    //0-12, 1-5, 2-11, 3-
    public static int calNumber(int left) {
    	
    	int answer=-1;
    	boolean find;
    	for(int k=0;k<10;k++){
    		find=true;
    		for(int i=0;i<5;i++){
    			for(int j=0;j<3;j++) {
    				if(number[k][i][j]!=map[i][left+j]) {
    					find=false;
    					break;
    				}
    			}
    			if(!find) break;
    		}
    		
    		if(find) answer=k;
    		
    	}
    	
    	return answer;
    }
    
    //숫자 넣어두기
  //숫자 넣어두기
    public static void init() {
        // 0
        number[0][0][0] = '#'; number[0][0][1] = '#'; number[0][0][2] = '#';
        number[0][1][0] = '#'; number[0][1][1] = '.'; number[0][1][2] = '#';
        number[0][2][0] = '#'; number[0][2][1] = '.'; number[0][2][2] = '#';
        number[0][3][0] = '#'; number[0][3][1] = '.'; number[0][3][2] = '#';
        number[0][4][0] = '#'; number[0][4][1] = '#'; number[0][4][2] = '#';

        // 1
        number[1][0][0] = '#'; number[1][0][1] = '.'; number[1][0][2] = '.';
        number[1][1][0] = '#'; number[1][1][1] = '.'; number[1][1][2] = '.';
        number[1][2][0] = '#'; number[1][2][1] = '.'; number[1][2][2] = '.';
        number[1][3][0] = '#'; number[1][3][1] = '.'; number[1][3][2] = '.';
        number[1][4][0] = '#'; number[1][4][1] = '.'; number[1][4][2] = '.';

        // 2
        number[2][0][0] = '#'; number[2][0][1] = '#'; number[2][0][2] = '#';
        number[2][1][0] = '.'; number[2][1][1] = '.'; number[2][1][2] = '#';
        number[2][2][0] = '#'; number[2][2][1] = '#'; number[2][2][2] = '#';
        number[2][3][0] = '#'; number[2][3][1] = '.'; number[2][3][2] = '.';
        number[2][4][0] = '#'; number[2][4][1] = '#'; number[2][4][2] = '#';

        // 3
        number[3][0][0] = '#'; number[3][0][1] = '#'; number[3][0][2] = '#';
        number[3][1][0] = '.'; number[3][1][1] = '.'; number[3][1][2] = '#';
        number[3][2][0] = '#'; number[3][2][1] = '#'; number[3][2][2] = '#';
        number[3][3][0] = '.'; number[3][3][1] = '.'; number[3][3][2] = '#';
        number[3][4][0] = '#'; number[3][4][1] = '#'; number[3][4][2] = '#';

        // 4
        number[4][0][0] = '#'; number[4][0][1] = '.'; number[4][0][2] = '#';
        number[4][1][0] = '#'; number[4][1][1] = '.'; number[4][1][2] = '#';
        number[4][2][0] = '#'; number[4][2][1] = '#'; number[4][2][2] = '#';
        number[4][3][0] = '.'; number[4][3][1] = '.'; number[4][3][2] = '#';
        number[4][4][0] = '.'; number[4][4][1] = '.'; number[4][4][2] = '#';

        // 5
        number[5][0][0] = '#'; number[5][0][1] = '#'; number[5][0][2] = '#';
        number[5][1][0] = '#'; number[5][1][1] = '.'; number[5][1][2] = '.';
        number[5][2][0] = '#'; number[5][2][1] = '#'; number[5][2][2] = '#';
        number[5][3][0] = '.'; number[5][3][1] = '.'; number[5][3][2] = '#';
        number[5][4][0] = '#'; number[5][4][1] = '#'; number[5][4][2] = '#';

        // 6
        number[6][0][0] = '#'; number[6][0][1] = '#'; number[6][0][2] = '#';
        number[6][1][0] = '#'; number[6][1][1] = '.'; number[6][1][2] = '.';
        number[6][2][0] = '#'; number[6][2][1] = '#'; number[6][2][2] = '#';
        number[6][3][0] = '#'; number[6][3][1] = '.'; number[6][3][2] = '#';
        number[6][4][0] = '#'; number[6][4][1] = '#'; number[6][4][2] = '#';

        // 7
        number[7][0][0] = '#'; number[7][0][1] = '#'; number[7][0][2] = '#';
        number[7][1][0] = '.'; number[7][1][1] = '.'; number[7][1][2] = '#';
        number[7][2][0] = '.'; number[7][2][1] = '.'; number[7][2][2] = '#';
        number[7][3][0] = '.'; number[7][3][1] = '.'; number[7][3][2] = '#';
        number[7][4][0] = '.'; number[7][4][1] = '.'; number[7][4][2] = '#';

        // 8
        number[8][0][0] = '#'; number[8][0][1] = '#'; number[8][0][2] = '#';
        number[8][1][0] = '#'; number[8][1][1] = '.'; number[8][1][2] = '#';
        number[8][2][0] = '#'; number[8][2][1] = '#'; number[8][2][2] = '#';
        number[8][3][0] = '#'; number[8][3][1] = '.'; number[8][3][2] = '#';
        number[8][4][0] = '#'; number[8][4][1] = '#'; number[8][4][2] = '#';

        // 9
        number[9][0][0] = '#'; number[9][0][1] = '#'; number[9][0][2] = '#';
        number[9][1][0] = '#'; number[9][1][1] = '.'; number[9][1][2] = '#';
        number[9][2][0] = '#'; number[9][2][1] = '#'; number[9][2][2] = '#';
        number[9][3][0] = '.'; number[9][3][1] = '.'; number[9][3][2] = '#';
        number[9][4][0] = '#'; number[9][4][1] = '#'; number[9][4][2] = '#';
    }

        
}


