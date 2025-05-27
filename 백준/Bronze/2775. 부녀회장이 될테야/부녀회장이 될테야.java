import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        while (testCase > 0) {
            int k = Integer.parseInt(br.readLine()) + 1;
            int n = Integer.parseInt(br.readLine());
            int[][] build = new int[k][n];

            for (int i = 0; i < k; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == 0) {
                        build[i][j] = j + 1;
                    } else if (j == 0) {
                        build[i][j] = 1;
                    } else {
                        build[i][j] = build[i][j - 1] + build[i - 1][j];
                    }
                }
            }
            System.out.println(build[k-1][n-1]);

            testCase--;
        }
    }
}