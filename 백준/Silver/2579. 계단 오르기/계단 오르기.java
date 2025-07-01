import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());
        int[] dp = new int[testCase + 1];
        int[] score = new int[testCase + 1];

        for (int i = 1; i <= testCase; i++) {
            score[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = 0;
        if (testCase >= 1) dp[1] = score[1];
        if (testCase >= 2) dp[2] = score[1] + score[2];

        for (int i = 3; i <= testCase; i++) {
            int x = dp[i - 3] + score[i - 1];
            int y = dp[i - 2];
            dp[i] = Math.max(x, y) + score[i];
        }
        System.out.println(dp[testCase]);

        br.close();
    }
}