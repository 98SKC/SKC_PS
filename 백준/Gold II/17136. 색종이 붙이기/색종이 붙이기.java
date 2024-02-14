import java.io.*;
import java.util.*;

public class Main {

    static int[][] paper = new int[10][10];
    //static boolean[][] visit=new boolean[10][10];//그냥 방문 시 0으로 바꾸는게 나을지도
    static int[] colorPaper = {0, 5, 5, 5, 5, 5};//인덱스 i에 해당하는 색종이를 colorPapper[i]만큼 보유하고 있다.
    static int min = Integer.MAX_VALUE;


    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        boolean check=false;


        for (int i = 0; i < 10; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 10; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //처음 0,0부터 재귀하며 메서드를 스택하기 보다 1이 처음 발견되면 거기부터 하자.
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (paper[i][j] == 1){
                    dfs(i,j,0);
                    check=true;
                    break;
                }
                if(i==9&&j==9) min=0;
            }
            if(check) break;

        }


      //  dfs(0,0,0);


        if(min==Integer.MAX_VALUE){
            min=-1;
        }

        System.out.println(min);

    }

    //위에서부터 1을 찾아서 가능한 가장 큰 색종이를 붙이려 했음.
    //근데 이 1이 포함된 전체 범위에서 아래쪽에 더 큰 종이가 붙는 경우, 위의 경우는 out.
    //1을 찾았을 때 1~5까지중 붙일 수 있는 색종이를 붙였다 땠다 하면서 백트래킹을 시도.
    //
    static void dfs(int i, int j, int count) {
      //  System.out.println("i: "+i+" "+" j:"+" "+j);
        if (count >= min) {
            return;
        }

        //틀렸던 부분. j를 9까지는 1을 탐색하도록 하고, 10으로 넘어가면 아래줄로 이동.
        //i는 왜 i>=9 인가? i>9 를 하면 i==9에서 아래쪽의 j>9로 1==10, j=0으로 넘어가게됨.
        // 그럼 10,0 에서  10>=9 , 0>9로 false가 되어 끝내지 않는다.
        if (i >= 9 && j >9) {
            min = Math.min(min, count);
            return;
        }

        if (j > 9) {
            dfs(i + 1, 0, count);
            return;
        }

        if (paper[i][j] == 1) {// 1을 찾으면
            for (int a = 5; a >= 1; a--) {// 1~5까지의 색종이를 붙이는 경우를 찾는다.


                //a크기의 색종이가 남나있고, 이 a를 붙일 수 있으면 그 범위만큼 0으로 바꾼다.
                if (colorPaper[a] > 0 && possible(i, j, a)) {
                    for (int b = i; b < i + a; b++) {// 시작점은 i, a크기의 정사각형 색종이 이므로 a크기만큼의 범위.
                        for (int c = j; c < j + a; c++) {
                            paper[b][c] = 0;
                        }
                    }

                    colorPaper[a]--;// 사용한 색종이 감소.

                    dfs(i, j + 1, count + 1);// 사용한 색종이를 늘린 상태로 dfs 재귀. 시작 지점은 다음 탐색칸.

                    for (int b = i; b < i + a; b++) {// 시작점은 i, a크기의 정사각형 색종이 이므로 a크기만큼의 범위.
                        for (int c = j; c < j + a; c++) {
                            paper[b][c] = 1;
                        }
                    }

                    colorPaper[a]++;
                }
            }
        } else { // 오른쪽으로 이동.
            dfs(i, j + 1, count);// 그냥 다음칸으로 넘어감.
        }


    }

    // 색종이를 붙일 수 있는지 확인.
    static boolean possible(int i, int j, int size) {//입력 받은 i,j가 좌측 상단 모서리라고 가정할 떄 size 크기의 색종이를 붙일수 있는지 확인.
        for (int a = i; a < i + size; a++) {
            for (int b = j; b < j + size; b++) {
                if (a < 0 || a >= 10 || b < 0 || b >= 10) {//색종이가 종이 범위를 넘어가면 불가능.
                    return false;
                }

                if (paper[a][b] == 0) {// 붙이려는 범위에 0이 있으면 불가
                    return false;
                }
            }
        }
        return true;
    }

}


