import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] testCase = br.readLine().split(" ");
        int C = Integer.parseInt(testCase[0]);
        int N = Integer.parseInt(testCase[1]);

        int[] dp = new int[C + 101];    // 최댓값 100
        Arrays.fill(dp, 1000000);
        dp[0] = 0;

        for (int i = 0; i < N; i++) {
            String[] inputs = br.readLine().split(" ");
            int cost = Integer.parseInt(inputs[0]);
            int peoples = Integer.parseInt(inputs[1]);

            // 현재값과 현재 도시에서 고객만큼의 비용 중 작은 값 저장
            for (int j = peoples; j < dp.length; j++) {
                dp[j] = Math.min(dp[j], dp[j - peoples] + cost);
            }
        }

        int minCost = Integer.MAX_VALUE;
        for (int i=C; i<dp.length; i++){
            minCost = Math.min(minCost, dp[i]);
        }

        System.out.println(minCost);

        br.close();
    }
}