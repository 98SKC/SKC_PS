import java.io.*;
import java.util.*;

public class Main {
    
    //오버라이드를 여기서 하면 편한가
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


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int C = Integer.parseInt(br.readLine());
        Point[] points = new Point[C];

        for (int i = 0; i < C; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long x = Long.parseLong(st.nextToken());
            long y = Long.parseLong(st.nextToken());
            points[i] = new Point(x, y);
        }

        List<Point> hull = convexHull(points);
        long answerSquared = rotatingCalipers(hull);

        System.out.println(Math.sqrt(answerSquared));
    }
    
    
    static long ccw(Point a, Point b, Point c) {
        return (b.x - a.x) * (c.y - a.y) - (b.y - a.y) * (c.x - a.x);
    }

    static long dist2(Point a, Point b) {
        long dx = a.x - b.x;
        long dy = a.y - b.y;
        return dx * dx + dy * dy;
    }

    static List<Point> convexHull(Point[] points) {
        Arrays.sort(points);

        List<Point> lower = new ArrayList<>();
        for (Point p : points) {
            while (lower.size() >= 2 &&
                    ccw(lower.get(lower.size() - 2), lower.get(lower.size() - 1), p) <= 0) {
                lower.remove(lower.size() - 1);
            }
            lower.add(p);
        }

        List<Point> upper = new ArrayList<>();
        for (int i = points.length - 1; i >= 0; i--) {
            Point p = points[i];
            while (upper.size() >= 2 &&
                    ccw(upper.get(upper.size() - 2), upper.get(upper.size() - 1), p) <= 0) {
                upper.remove(upper.size() - 1);
            }
            upper.add(p);
        }

        lower.remove(lower.size() - 1);
        upper.remove(upper.size() - 1);

        lower.addAll(upper);
        return lower;
    }

    static long rotatingCalipers(List<Point> hull) {
        int n = hull.size();

        if (n == 1) return 0;
        if (n == 2) return dist2(hull.get(0), hull.get(1));

        long max = 0;
        int j = 1;

        for (int i = 0; i < n; i++) {
            int ni = (i + 1) % n;

            while (true) {
                int nj = (j + 1) % n;

                Point edgeA = new Point(
                        hull.get(ni).x - hull.get(i).x,
                        hull.get(ni).y - hull.get(i).y
                );

                Point edgeB = new Point(
                        hull.get(nj).x - hull.get(j).x,
                        hull.get(nj).y - hull.get(j).y
                );

                long cross = edgeA.x * edgeB.y - edgeA.y * edgeB.x;

                if (cross > 0) {
                    j = nj;
                } else {
                    break;
                }
            }

            max = Math.max(max, dist2(hull.get(i), hull.get(j)));
        }

        return max;
    }
}