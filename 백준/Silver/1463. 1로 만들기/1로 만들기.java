import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuffer sb = new StringBuffer();

        int x = Integer.parseInt(br.readLine());
        // 현재 상태의 값을 이전 상태의 값으로부터 어떻게 구할 수 있을지 고민
        // Map<계산할 수, count>
        // for문 1부터 가는 이유: 최소한으로 계산하기 위해
        // 최소한으로 계산하기 위한 방법....
        /*
         * 1 >  - = 1        / 0
         * 2 > /2 = 1        / 1
         * 3 > /3 = 1        / 1
         * 4 > -1 = 3        / 1 + 1 = 2
         * 5 > -1 = 4        / 1 + 2 = 3
         * 6 > -1 = 5        / 1 + 3 = 4 X
         * 6 > /3 = 2        / 1 + 1 = 2
         * 7 > -1 = 6        / 1 + 2 = 3
         * */
        int[] counts = new int[x + 1];
        counts[0] = 0;
        counts[1] = 0;

        for (int i = 2; i <= x; i++) {
            if (i % 6 == 0) {
                counts[i] = Math.min(counts[i - 1], Math.min(counts[i / 2], counts[i / 3])) + 1;
            } else if (i % 3 == 0) {
                counts[i] = Math.min(counts[i - 1], counts[i / 3]) + 1;
            } else if (i % 2 == 0) {
                counts[i] = Math.min(counts[i - 1], counts[i / 2]) + 1;
            } else {
                counts[i] = counts[i - 1] + 1;
            }
        }
        sb.append(counts[x]);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
