import java.util.*;
import java.io.*;

public class Main {
	//공간에 대한 정보 관련 클래스
    static class position{
        int x, y, count;
        public position(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;	//이동한 횟수
        }
    }
    
    static int N,M;
    static int[][] space;		//공간에 대한 정보 저장 배열
    static int[] dx = {-1, 0, 1, -1, 1, -1, 0, 1};	//이동관련 X 변경값
    static int[] dy = {-1, -1, -1, 0, 0, 1, 1, 1};	//이동관련 y 변경값
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //입력값 처리하는 BufferedReader
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //결과값 출력하는 BufferedWriter
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        space = new int[N][M];
        //공간에 대한 정보 저장
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<M;j++){
                space[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int answer = Integer.MIN_VALUE;
        //공간이 0인 공간 BFS 탐색 진행 및 최대 안전거리 구하기
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(space[i][j] == 0)
                    answer = Math.max(answer, bfs(j, i));
            }
        }
        bw.write(answer + "");	//최대 안전거리 BufferedWriter 저장
        bw.flush();
        bw.close();
        br.close();
    }

    static int bfs(int x, int y){
        Queue<position> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][M];
        visited[y][x] = true;
        queue.add(new position(x, y, 0));
        while(!queue.isEmpty()){
            position cur = queue.poll();
            for(int i=0;i<8;i++){	//공간 이동.
                int tempX = cur.x + dx[i];
                int tempY = cur.y + dy[i];
                if(inSpace(tempX,tempY) && !visited[tempY][tempX]){
                    if(space[tempY][tempX]==0){	//빈공간일 때
                        visited[tempY][tempX] = true;
                        queue.add(new position(tempX,tempY, (cur.count+1)));
                    }else{		//아기 상어 만날 때
                        return cur.count+1;
                    }
                }
            }
        }
        return -1;	
    }

    static boolean inSpace(int x, int y){
        if(x>=0 && y>=0 && x<M && y<N)
            return true;
        return false;
    }
}