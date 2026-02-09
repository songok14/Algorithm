import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine());

        while (testCase > 0) {
            int[] NM = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int N = NM[0];
            int M = NM[1];

            long[][] dp = new long[31][31];
            for (int i = 0; i <= M; i++) {
                dp[i][0] = 1;
                dp[i][i] = 1;

                for (int j = 1; j < i; j++) {
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                }
            }

            sb.append(dp[M][N]).append("\n");
            testCase--;
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}