import java.io.*;
import java.util.*;

public class Main {
    static final int MAX = 1000000009;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine());

        while (testCase > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] dp = new int[n];

            dp[0] = 1;
            if (n > 1) dp[1] = 2;
            if (n > 2) dp[2] = 4;

            for (int i = 3; i < n; i++) {
                dp[i] = (int)(((long)dp[i - 1] + dp[i - 2] + dp[i - 3]) % MAX);
            }

            sb.append(dp[n - 1]).append("\n");
            testCase--;
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}