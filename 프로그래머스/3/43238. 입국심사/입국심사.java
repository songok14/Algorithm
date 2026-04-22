import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = Long.MAX_VALUE;

        Arrays.sort(times);

        long min = 1;
        long max = (long) times[times.length - 1] * n;

        while (min <= max) {
            long mid = (min + max) / 2;
            long count = 0;

            for (int t : times) {
                count += mid / t;
            }

            if (count >= n) {
                max = mid - 1;
                answer = Math.min(answer, mid);
            } else {
                min = mid + 1;
            }
        }

        return answer;
    }
}