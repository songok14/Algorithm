import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuffer sb = new StringBuffer();

        int n = Integer.parseInt(br.readLine());
        int[] counts = new int[n];
        if (n > 0) counts[0] = 1;
        if (n > 1) counts[1] = 3;

        if (n > 2) {
            for (int i = 2; i < n; i++) {
                counts[i] = (counts[i - 1] + (counts[i - 2] * 2)) % 10007;
            }
        }
        sb.append(counts[n - 1]);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}