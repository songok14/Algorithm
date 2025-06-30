import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String[] testCase = br.readLine().split(" ");
        int n = Integer.parseInt(testCase[0]);
        int m = Integer.parseInt(testCase[1]);
        int b = Integer.parseInt(testCase[2]);
        int[][] lands = new int[n][m];
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            String[] inputs = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                lands[i][j] = Integer.parseInt(inputs[j]);

                max = Math.max(max, lands[i][j]);
                min = Math.min(min, lands[i][j]);
            }
        }

        int time = Integer.MAX_VALUE;
        int hight = 0;
        while (min <= max) {
            int temp = 0;
            int tempB = b;
            for (int i = 0; i < n; i++) {

                for (int j = 0; j < m; j++) {
                    if (min > lands[i][j]) {
                        tempB -= min - lands[i][j];
                        temp += min - lands[i][j];
                    } else {
                        tempB += lands[i][j] - min;
                        temp += (lands[i][j] - min) * 2;
                    }
                }
            }

            if (tempB >= 0) {
                if (time >= temp) {
                    time = temp;
                    hight = Math.max(hight, min);
                }
            }
            min++;
        }
        sb.append(time).append(" ").append(hight);


        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}