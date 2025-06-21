import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuffer sb = new StringBuffer();

        /* 1 - 1        *  2 - 2        *  3 - 3
         *  4 - 5        *  5 - 8        *  6 - 13
         *  7 - 21       *  8 - 34       *  9 - 55
         *  n = (n-1) + (n-2) */
        int n = Integer.parseInt(br.readLine());
        int[] counts = new int[n + 1];
        counts[0] = 1;
        counts[1] = 2;

        for (int i = 2; i < n; i++) {
            counts[i] = (counts[i - 1] + counts[i - 2]) % 10007;
        }
        sb.append(counts[n-1]);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}