import java.util.*;
import java.io.*;



public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //스마일 이모티콘 S개를 보낸다.
        //화면이 이미 한개의 이모티콘을 입력

        //다음 규칙을 따라 이모티콘 S개를 만든다.
        //1. 화면에 있는 모든 이모티콘을 복사하여 저장한다.
        //2. 저장되어있는 이모티콘을 화면에 붙여넣는다.
        //3. 화면에 있는 이모티콘 중 하나를 삭제한다.

        //모든 연산은 1초 걸린다.
        //S기 종류의 개수가 아니라 이모티콘 문자열 길이였네


        int S=Integer.parseInt(br.readLine());

        ArrayDeque<int[]> q=new ArrayDeque<>();

        int[] p;
        int answer=0;
        q.add(new int[]{1,0,0});
        boolean[][] v=new boolean[3000][3000];

        while(!q.isEmpty()){
            //지금 길이, 복사되어있는 이모티콘 길이, 시간
            p=q.poll();
            //System.out.println("????");

            if(v[p[0]][p[1]]) continue;

            v[p[0]][p[1]]=true;

            if(p[0]==S){
                answer=p[2];
                break;
            }

            //둘이 같지 않으면 => 이전이 복사턴이 아니면
            if(p[0]!=p[1]){
                q.add(new int[]{p[0],p[0],p[2]+1});
            }
            
            //간적 없는 경우의 수고, 복사된 이모티콘이 있으면
            if (
                    p[1] != 0 &&
                            p[0] + p[1] < 3000 &&
                            !v[p[0] + p[1]][p[1]]
            ) {
                q.add(new int[]{p[0] + p[1], p[1], p[2] + 1});
            }
            if(p[0]>0&&!v[p[0]-1][p[1]]) q.add(new int[]{p[0]-1,p[1],p[2]+1});

        }

        System.out.println(answer);
    }

}

//public class Main {
//
//    public static void main(String[] args) throws Exception {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//
//
//    }
//
//}