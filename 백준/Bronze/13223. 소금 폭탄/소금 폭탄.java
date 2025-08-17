import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String srcTime = in.nextLine().trim();   // 현재 시각
        String dstTime = in.nextLine().trim();   // 목표 시각
        in.close();

        String[] src = srcTime.split(":");
        String[] dst = dstTime.split(":");

        int srcH = Integer.parseInt(src[0]);
        int srcM = Integer.parseInt(src[1]);
        int srcS = Integer.parseInt(src[2]);

        int dstH = Integer.parseInt(dst[0]);
        int dstM = Integer.parseInt(dst[1]);
        int dstS = Integer.parseInt(dst[2]);

        int secSrc = srcH * 3600 + srcM * 60 + srcS;
        int secDst = dstH * 3600 + dstM * 60 + dstS;

        int gap = secDst - secSrc;
        if (gap <= 0) gap += 24 * 3600; // 동일 시각 포함, 다음날로 보정

        int outH = gap / 3600;
        int outM = (gap % 3600) / 60;
        int outS = gap % 60;

        System.out.printf("%02d:%02d:%02d%n", outH, outM, outS);
    }
}
