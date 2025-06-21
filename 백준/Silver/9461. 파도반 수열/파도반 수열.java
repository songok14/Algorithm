import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuffer sb = new StringBuffer();

        /* 0 - 1        *  1 - 1        *  2 - 1
         *  3 - 2        *  4 - 2        *  5 - 3
         *  6 - 4        *  7 - 5        *  8 - 7        *  9 - 9
         *  9 -> 8 + 4?        *  8 -> 7 + 3        *  7 -> 6 + 2 */
        int testCase = Integer.parseInt(br.readLine());
        while (testCase > 0) {
            int n = Integer.parseInt(br.readLine());
            List<Long> list = new ArrayList<>();
            list.add(1L);
            list.add(1L);
            list.add(1L);
            list.add(2L);
            list.add(2L);

            for (int i = 5; i < n; i++) {
                list.add(list.get(i - 1) + list.get(i - 5));
            }
            sb.append(list.get(n - 1)).append("\n");

            testCase--;
        }


        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}