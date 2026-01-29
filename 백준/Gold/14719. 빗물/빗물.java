import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] range = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int H = range[0];
        int W = range[1];
        int[] rain = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] left = new int[W];
        int[] right = new int[W];
        int sum = 0;

        left[0] = rain[0];
        for (int i = 1; i < W; i++) {
            left[i] = Math.max(left[i - 1], rain[i]);
        }

        right[W - 1] = rain[W - 1];
        for (int i = W - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], rain[i]);
        }

        for (int i = 0; i < W; i++) {
            int temp = Math.min(left[i], right[i]);
            if (temp > rain[i]) sum += (temp - rain[i]);
        }

        System.out.println(sum);
        br.close();
    }
}