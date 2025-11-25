import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        long[][] coordinates = new long[n][2];

        long sum1 = 0;
        long sum2 = 0;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            coordinates[i][0] = Long.parseLong(st.nextToken());
            coordinates[i][1] = Long.parseLong(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            int next = (i + 1) % n;

            sum1 += coordinates[i][0] * coordinates[next][1];
            sum2 += coordinates[i][1] * coordinates[next][0];
        }
        double area = Math.abs((double) (sum1 - sum2) / 2.0);

        System.out.println(String.format("%.1f", area));

        br.close();
    }
}