import java.io.*;
import java.util.*;

public class Main {

    static long key(long x, long y, long offX, long offY, long base) {
        long sx = x + offX;   // shifted x (>=0)
        long sy = y + offY;   // shifted y (>=0)
        return sx * base + sy;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // N개의 점에서 점 4개를 선택.
        // x,y축에 평행한 직사각형을 만든다.
        // 가로가 A, 세로가 B인 사각형을 몇개 만들 수 있는가
        
        // N은 최대 500000 조합으로는 안되고
                
        //좌표를 저장할 자료구조를 택하고
        
        //A,B가 정해져 있으니까. 완탐을 해도. A에 해당하는 점 3개가 있는지 한번에 알 수 있으면 되는데
        //중복을 거르려면 한 방향으로만. 우측 하향으로
        //좌표가 음수인걸 감안하면 모든 좌표가 0이상이 되도록 최소값을 기준으로 다 옮겨버리면
        
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken()); // 가로: x 방향
        long B = Long.parseLong(st.nextToken()); // 세로: y 방향

        long[] xs = new long[N];
        long[] ys = new long[N];

        long minX = Long.MAX_VALUE, maxX = Long.MIN_VALUE;
        long minY = Long.MAX_VALUE, maxY = Long.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            long x = Long.parseLong(st.nextToken());
            long y = Long.parseLong(st.nextToken());

            xs[i] = x;
            ys[i] = y;

            if (x < minX) minX = x;
            if (x > maxX) maxX = x;
            if (y < minY) minY = y;
            if (y > maxY) maxY = y;
        }

        long offX = -minX;
        long offY = -minY;

        
        long base = (maxY - minY + 1);

        HashSet<Long> set = new HashSet<>();

        for (int i = 0; i < N; i++) {
            set.add(key(xs[i], ys[i], offX, offY, base));
        }

        long answer = 0;

        for (int i = 0; i < N; i++) {
            long x = xs[i], y = ys[i];
            long x2 = x + A;
            long y2 = y + B;

           
            if (x2 < minX || x2 > maxX || y2 < minY || y2 > maxY) continue;

            long k1 = key(x2, y,  offX, offY, base);
            long k2 = key(x,  y2, offX, offY, base);
            long k3 = key(x2, y2, offX, offY, base);

            if (set.contains(k1) && set.contains(k2) && set.contains(k3)) {
                answer++;
            }
        }

        System.out.println(answer);
    }
}