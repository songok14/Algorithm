import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuffer sb = new StringBuffer();

        String[] testCase = br.readLine().split(" ");
        int k = Integer.parseInt(testCase[0]);
        int n = Integer.parseInt(testCase[1]);
        int[] lans = new int[k];
        long max = 0;
        long min = 1;

        for (int i = 0; i < k; i++) {
            lans[i] = Integer.parseInt(br.readLine());

            if (max < lans[i]) {
                max = lans[i];
            }
        }

        while (min <= max) {
            long count = 0;
            long mid = (max + min) / 2;
            for (int i = 0; i < k; i++) {
                count += lans[i] / mid;
            }

            if (n > count) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        sb.append(max);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}