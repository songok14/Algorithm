import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] testCase = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = testCase[0];
        int M = testCase[1];
        int[] playTime = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int end = 0;
        int start = Integer.MIN_VALUE;

        for (int i : playTime) {
            end += i;
            if (start < i) {
                start = i;
            }
        }

        while (start <= end) {
            int count = 0;
            int sum = 0;
            int mid = (start + end) / 2;

            for (int i = 0; i < N; i++) {
                if (sum + playTime[i] > mid) {
                    sum = 0;
                    count++;
                }
                sum += playTime[i];
            }
            count++;

            if (count > M) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        System.out.println(start);
        br.close();
    }
}