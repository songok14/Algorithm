import java.io.*;
import java.util.Arrays;

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

        if (n == 0) {
            sb.append(0);
        } else if (n == 1) {
            sb.append(scores[1]);
        } else if (n == 2) { // n=2일 때 초기값 처리
            sb.append(scores[1] + scores[2]);
        } else {
            int[] dp = new int[n + 1];

            // 초기값 설정
            dp[1] = scores[1];
            dp[2] = scores[1] + scores[2]; // 10 + 10 = 20

            // 점화식
            for (int i = 3; i <= n; i++) {
                // i번째 계단을 밟는 두 가지 방법 중 최댓값 선택
                // 1. (i-3 -> i-1) + (i-1 -> i) : scores[i] + scores[i-1] + dp[i-3]
                //    (이전 계단 i-1을 밟고 온 경우. 이때 i-1은 i-3에서 2칸 점프로 왔어야 함)
                // 2. (i-2 -> i) : scores[i] + dp[i-2]
                //    (두 칸 전 계단 i-2를 밟고 온 경우)
                dp[i] = Math.max(dp[i-2], dp[i-3] + scores[i-1]) + scores[i];
            }
            sb.append(dp[n]);
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}