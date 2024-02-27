import java.io.*;
import java.util.*;
 
public class Main {
    
    
	static HashSet<Integer> set=new HashSet<>();
    static boolean[][] map = new boolean[101][101];
 
    public static void main(String[] args) throws Exception {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine()); // 커브의 개수
        int x,y,d,g;
        StringTokenizer st;
        
        for(int i=0;i<N;i++) {
        	st=new StringTokenizer(br.readLine());
        	x = Integer.parseInt(st.nextToken());// i역할
            y = Integer.parseInt(st.nextToken());// j역할
            d = Integer.parseInt(st.nextToken()); // 시작 방향
            g = Integer.parseInt(st.nextToken()); // 세대
 
            dragonCurve(x, y, getDir(d, g));
        }
 
        System.out.println(getNumberOfSquares());
    }
 
    //선을 그을 방향을 리스트로 정리. d가 전체 방향. g가 세대.
    public static List<Integer> getDir(int d, int g) {
        List<Integer> directions = new ArrayList<>(); // 방향을 담아줄 list 생성
        directions.add(d); // 초기 d 입력
 
        while (g-- > 0) { // g세대까지 반복. 끝점으로 시작해서 시작점까지의 선과 방향이 시계방향으로 90도씩 꺾이며 뻗어나감.
            for (int i = directions.size() - 1; i >= 0; i--) { // 마지막 방향 -> 처음방향까지 순서로 반복
                int direction = (directions.get(i) + 1) % 4; // (기존의 d+1)%4  
                directions.add(direction); // 새로운 방향 추가
            }
        }
        return directions;
    }

    
    public static void dragonCurve(int i, int j, List<Integer> directions) {
        map[i][j] = true;
        set.add(i*101+j);
        for (int direction : directions) {
            switch (direction) {
                case 0:
                    map[++i][j] = true;
                    set.add(i*101+j);
                    break;
                case 1:
                    map[i][--j] = true;
                    set.add(i*101+j);
                    break;
                case 2:
                    map[--i][j] = true;
                    set.add(i*101+j);
                    break;
                case 3:
                    map[i][++j] = true;
                    set.add(i*101+j);
                    break;
            }
        }
    }
 
    private static int getNumberOfSquares() {
        int count = 0;
        //4개가 다 true면
        int i;
        int j;
        for(int a:set) {
        	i=a/101;
        	j=a%101;
        	if (i!=100&&j!=100&&map[i][j] && map[i + 1][j] && map[i][j + 1] && map[i + 1][j + 1])
        		count++;
        }

        return count;
    }
}