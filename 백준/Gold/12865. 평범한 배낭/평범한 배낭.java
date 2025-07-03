import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] testCase = br.readLine().split(" ");
        int N = Integer.parseInt(testCase[0]);
        int K = Integer.parseInt(testCase[1]);

        int[][] arr = new int[N + 1][2];
        arr[0][0] = 0;  // 무게
        arr[0][1] = 0;  // 가치

        for (int i = 1; i < N + 1; i++) {
            String[] inputs = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(inputs[0]);
            arr[i][1] = Integer.parseInt(inputs[1]);
        }

        int[] dp = new int[K + 1];
        Arrays.fill(dp, 0);

        for (int i = 1; i < N + 1; i++) {       // 무게, 가치
            for (int j = K; j >= 0; j--) {   // 배낭
                if (j - arr[i][0] >= 0) {
                    dp[j] = Math.max(dp[j], dp[j - arr[i][0]] + arr[i][1]);
                }
            }
        }

        int max = 0;
        for (
                int i = 1;
                i < dp.length; i++) {
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
        br.close();
    }
}