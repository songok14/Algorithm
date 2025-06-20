import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuffer sb = new StringBuffer();

        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            int n = Integer.parseInt(br.readLine());
            int[] count = new int[n + 1];
            if (n > 0) count[1] = 1;
            if (n > 1) count[2] = 2;
            if (n > 2) count[3] = 4;

            for (int j = 4; j <= n; j++) {
                count[j] = count[j - 1] + count[j - 2] + count[j - 3];
            }
            sb.append(count[n]).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}