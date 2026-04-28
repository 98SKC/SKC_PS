import java.io.*;
import java.util.*;

public class Main {

    static class Point implements Comparable<Point> {
        long x, y;

        Point(long x, long y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point o) {
            if (this.x == o.x) return Long.compare(this.y, o.y);
            return Long.compare(this.x, o.x);
        }
    }

    static long ccw(Point a, Point b, Point c) {
        return (b.x - a.x) * (c.y - a.y)
             - (b.y - a.y) * (c.x - a.x);
    }

    static long cross(Point a, Point b, Point c, Point d) {
        long x1 = b.x - a.x;
        long y1 = b.y - a.y;
        long x2 = d.x - c.x;
        long y2 = d.y - c.y;

        return x1 * y2 - y1 * x2;
    }

    static long dist(Point a, Point b) {
        long dx = a.x - b.x;
        long dy = a.y - b.y;
        return dx * dx + dy * dy;
    }

    static Point[] convexHull(Point[] points) {
        Arrays.sort(points);

        int n = points.length;
        Point[] hull = new Point[n * 2];
        int idx = 0;

        for (int i = 0; i < n; i++) {
            while (idx >= 2 && ccw(hull[idx - 2], hull[idx - 1], points[i]) <= 0) {
                idx--;
            }
            hull[idx++] = points[i];
        }

        int lowerSize = idx;

        for (int i = n - 2; i >= 0; i--) {
            while (idx > lowerSize && ccw(hull[idx - 2], hull[idx - 1], points[i]) <= 0) {
                idx--;
            }
            hull[idx++] = points[i];
        }

        return Arrays.copyOf(hull, idx - 1);
    }

    static Point[] rotatingCalipers(Point[] hull) {
        int n = hull.length;

        if (n == 2) {
            return new Point[] { hull[0], hull[1] };
        }

        long maxDist = 0;
        Point answerA = hull[0];
        Point answerB = hull[1];

        int j = 1;

        for (int i = 0; i < n; i++) {
            int nextI = (i + 1) % n;

            while (true) {
                int nextJ = (j + 1) % n;

                long now = cross(hull[i], hull[nextI], hull[j], hull[nextJ]);

                if (now > 0) {
                    j = nextJ;
                } else {
                    break;
                }
            }

            long d = dist(hull[i], hull[j]);
            if (d > maxDist) {
                maxDist = d;
                answerA = hull[i];
                answerB = hull[j];
            }
        }

        return new Point[] { answerA, answerB };
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        StringBuilder sb = new StringBuilder();

        int T = fs.nextInt();

        while (T-- > 0) {
            int n = fs.nextInt();

            Point[] points = new Point[n];

            for (int i = 0; i < n; i++) {
                long x = fs.nextLong();
                long y = fs.nextLong();
                points[i] = new Point(x, y);
            }

            Point[] hull = convexHull(points);
            Point[] result = rotatingCalipers(hull);

            sb.append(result[0].x).append(' ')
              .append(result[0].y).append(' ')
              .append(result[1].x).append(' ')
              .append(result[1].y).append('\n');
        }

        System.out.print(sb);
    }

    static class FastScanner {
        private final InputStream in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

        FastScanner(InputStream in) {
            this.in = in;
        }

        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        long nextLong() throws IOException {
            int c;
            do {
                c = read();
            } while (c <= ' ');

            long sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }

            long val = 0;
            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = read();
            }

            return val * sign;
        }

        int nextInt() throws IOException {
            return (int) nextLong();
        }
    }
}