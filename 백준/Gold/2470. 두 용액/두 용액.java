import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());
        String[] inputs = br.readLine().split(" ");
        int[] arr = new int[testCase];

        for (int i = 0; i < testCase; i++) {
            arr[i] = Integer.parseInt(inputs[i]);
        }
        Arrays.sort(arr);

        int min = Integer.MAX_VALUE;
        int start = 0;
        int end = arr.length - 1;
        int[] answer = new int[2];

        while (start < end) {
            int total = Math.abs(arr[start] + arr[end]);

            if (total < min) {
                answer[0] = arr[start];
                answer[1] = arr[end];
                min = total;
            } else {
                if (Math.abs(arr[start]) > Math.abs(arr[end])) {
                    start++;
                } else {
                    end--;
                }
            }
        }

        if (answer[0] > answer[1]) {
            System.out.println(answer[1] + " " + answer[0]);
        } else {
            System.out.println(answer[0] + " " + answer[1]);
        }
        br.close();
    }
}