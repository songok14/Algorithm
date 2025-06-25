import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuffer sb = new StringBuffer();

        String[] testCase = br.readLine().split(" ");
        String[] inputs = br.readLine().split(" ");

        int n = Integer.parseInt(testCase[0]);
        int m = Integer.parseInt(testCase[1]);
        int[] trees = new int[n];
        int max = 0;
        int min = 0;

        for (int i=0; i<n; i++){
            trees[i] = Integer.parseInt(inputs[i]);

            if (max < trees[i]){
                max = trees[i];
            }
        }

        while (min < max) {
            int mid = (max + min) / 2;
            long sum = 0;
            for (int t : trees) {
                if (t > mid) {
                    sum += (t - mid);
                }
            }

            if (sum < m) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        sb.append(min -1);


        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}