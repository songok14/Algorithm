import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] testCase = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = testCase[0];
        int C = testCase[1];

        int[] house = new int[N];
        for (int i = 0; i < N; i++) {
            house[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(house);

        int start = 1;
        int end = house[N - 1];

        while (start <= end) {
            int count = 1;
            int target = 0;
            int mid = (start + end) / 2;

            for (int i = 1; i < N; i++) {
                if (house[i] - house[target] >= mid) {
                    target = i;
                    count++;
                }
            }

            if (count >= C) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        System.out.println(start-1);

        br.close();
    }
}