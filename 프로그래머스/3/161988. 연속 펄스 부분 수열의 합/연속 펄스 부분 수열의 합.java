import java.io.*;
import java.util.*;

public class Solution {
    public long solution(int[] sequence) {
        int n = sequence.length;
        long[] psum = new long[n + 1];

        for (int i = 0; i < n; i++) {
            psum[i + 1] = psum[i] + (long) sequence[i] * ((i % 2 == 0) ? 1 : -1);
        }

        long max = Long.MIN_VALUE;
        long min = Long.MAX_VALUE;
        for (int i = 0; i <= n; i++) {
            max = Math.max(max, psum[i]);
            min = Math.min(min, psum[i]);
        }

        return max - min;
    }
}
