import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = -2;

        ArrayDeque<Integer> q1 = new ArrayDeque<>();
        ArrayDeque<Integer> q2 = new ArrayDeque<>();

        long sumA = 0;
        long sumB = 0;

        int q1_size = queue1.length;
        int q2_size = queue2.length;

        for (Integer sub : queue1) {
            q1.add(sub);
            sumA += sub;
        }

        for (Integer sub : queue2) {
            q2.add(sub);
            sumB += sub;
        }

        long goal = sumA + sumB;
        if (goal % 2 != 0) {
            return -1;
        }
        goal /= 2;

        int cnt = 0;
        int limit = 2 * (q1_size + q2_size);

        while (sumA != sumB) {
            if (cnt >= limit) return -1;

            if (sumA > sumB) {
                sumA -= q1.peek();
                sumB += q1.peek();
                q2.add(q1.poll());
            } else {
                sumB -= q2.peek();
                sumA += q2.peek();
                q1.add(q2.poll());
            }

            cnt++;
        }

        answer = cnt;

        return answer;
    }
}