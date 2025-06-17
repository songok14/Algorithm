import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuffer sb = new StringBuffer();

        int testCase = Integer.parseInt(br.readLine());
        // 현재 상태의 값을 이전 상태의 값으로부터 어떻게 구할 수 있을지 고민
        // f(0), f(1)만 구하면 다 구할 수 있음
        for (int i = 0; i < testCase; i++) {
            int n = Integer.parseInt(br.readLine());
            int[][] fibo = new int[n+1][2];
            fibo[0][0] = 1;
            fibo[0][1] = 0;

            if(n >= 1) {
                fibo[1][0] = 0;
                fibo[1][1] = 1;
            }

            for (int j = 2; j <= n; j++) {
                fibo[j][0] = fibo[j-1][0] + fibo[j-2][0];
                fibo[j][1] = fibo[j-1][1] + fibo[j-2][1];
            }

            sb.append(fibo[n][0]).append(" ").append(fibo[n][1]).append("\n");
        }


        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}