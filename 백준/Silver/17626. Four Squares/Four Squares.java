import java.io.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuffer sb = new StringBuffer();

        int n = Integer.parseInt(br.readLine());
        int[] result = new int[n + 1];

        result[0] = 0;
        result[1] = 1;

        for (int i = 2; i <= n; i++) {
            result[i] = result[i - 1];    // 현재 값의 최대값은 직전 값 + 1
            for (int j = 1; j * j <= i; j++) {
                result[i] = Math.min(result[i], result[i - j * j]);
            }
            result[i]++;
        }
        sb.append(result[n]);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}