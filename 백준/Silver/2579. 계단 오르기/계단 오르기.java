import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuffer sb = new StringBuffer();

        int n = Integer.parseInt(br.readLine()); // 계단의 개수

        int[] scores = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            scores[i] = Integer.parseInt(br.readLine());
        }

        if (n == 0) { // 계단이 0개인 경우
            sb.append(0);
        } else if (n == 1) { // 계단이 1개인 경우
            sb.append(scores[1]);
        } else {
            // dp[i][0]: i번째 계단을 밟고, 그 전 계단(i-1)에서 1칸 이동하여 i에 도착한 경우의 최대 점수
            // dp[i][1]: i번째 계단을 밟고, 그 전전 계단(i-2)에서 2칸 이동하여 i에 도착한 경우의 최대 점수
            int[][] dp = new int[n + 1][2];

            // 초기값 설정
            dp[1][0] = scores[1]; // 1번째 계단은 1칸 이동으로 도착 (시작점 -> 1)
            dp[1][1] = 0; // 사실상 dp[1][1]은 2칸 이동으로 1번째 도착은 없으므로 scores[1]이 아닌 0으로 초기화해도 되지만,
            // 아래 점화식에서 dp[i-2]를 참조하므로, 첫 번째 계단 점수가 더해진 값으로 처리하는 것이 편합니다.
            // (단, dp[1][1] 값 자체는 사용되지 않습니다. 개념적으로 2칸 점프해서 1칸에 올 수 없기 때문)
            // 더 정확히는 dp[1][1] = 0으로 두고, dp[2][1]에서 scores[2]만 더해야 함.
            // 여기서는 편의상 dp[1][1]에 scores[1]을 넣어두고 dp[2]부터 점화식을 적용하겠습니다.

            // dp[1][1]은 의미상 0으로 두는 것이 맞지만, 아래 dp[2]의 계산에서 문제가 없도록
            // dp[1]에 대한 값들이 올바르게 설정되어야 합니다.
            // 아래처럼 초기화하는 것이 더 정확합니다.
            // dp[1][0] = scores[1];
            // dp[1][1] = 0; (2칸 점프해서 1번 계단에 도달할 수 없음)

            dp[2][0] = scores[1] + scores[2]; // 2번째 계단까지 1칸씩 (1 -> 2)
            dp[2][1] = scores[2];           // 2번째 계단까지 2칸 점프 (0 -> 2)

            for (int i = 3; i <= n; i++) {
                // i번째 계단에 1칸 점프로 도착 (i-1 -> i)
                // i-1번째 계단은 반드시 2칸 점프로 도착했어야 함 (i-3 -> i-1 또는 i-4 -> i-2 -> i-1)
                // 즉, dp[i-1][1]을 사용해야 연속 3칸 점프를 방지할 수 있습니다.
                dp[i][0] = dp[i-1][1] + scores[i];

                // i번째 계단에 2칸 점프로 도착 (i-2 -> i)
                // i-2번째 계단에 도착한 방법은 1칸 점프든 2칸 점프든 상관없음
                dp[i][1] = Math.max(dp[i-2][0], dp[i-2][1]) + scores[i];
            }

            sb.append(Math.max(dp[n][0], dp[n][1]));
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}