import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int k = Integer.parseInt(inputs[1]);

        int[] coins = new int[n];

        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        int[] answer = new int[k + 1];
        answer[0] = 0;
        for (int i = 1; i <= k; i++) {
            int min = 10001;
            for (int c : coins) {
                if (i - c >= 0 && answer[i - c] != -1 && min > answer[i - c]) {
                    min = answer[i - c];
                }
            }
            if (min == 10001) {
                answer[i] = -1;
            } else {
                answer[i] = min + 1;
            }
        }
        System.out.println(answer[k]);


        br.close();
    }
}