import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] numbers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        long k = Long.parseLong(br.readLine());

        long count = 0;
        long sum = 0;
        int start = 0;
        int end = 0;

        while (end < n) {
            sum += numbers[end];
            while (sum > k) {
                count += (n - end);
                sum -= numbers[start];
                start++;
            }
            end++;
        }

        System.out.println(count);
        br.close();
    }
}
