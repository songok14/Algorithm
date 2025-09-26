import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] inputNums = br.readLine().split(" ");
        int sum = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(inputNums[i]);
        }
        Arrays.sort(arr);

        int start = 0;
        int end = N - 1;
        int count = 0;

        while (start < end) {
            if (arr[start] + arr[end] == sum) {
                start++;
                count++;
            } else if (arr[start] + arr[end] < sum) {
                start++;
            } else {
                end--;
            }
        }

        System.out.println(count);
        br.close();
    }
}