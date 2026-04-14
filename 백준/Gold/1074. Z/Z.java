import java.io.*;
import java.util.*;

public class Main {
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = inputs[0];
        int r = inputs[1];
        int c = inputs[2];

        sol(n, r, c);
        System.out.println(answer);

        br.close();
    }

    public static void sol(int n, int r, int c) {
        if (n == 0) return;

        int target = (int) (Math.pow(2, n)) / 2;

        if (r < target && c < target) {
            sol(n - 1, r, c);
        } else if (r < target && c >= target) {
            answer += (int) Math.pow(Math.pow(2, n - 1), 2);
            sol(n - 1, r, c - target);
        } else if (r >= target && c < target) {
            sol(n - 1, r - target, c);
            answer += (int) Math.pow(Math.pow(2, n - 1), 2) * 2;
        } else {
            sol(n - 1, r - target, c - target);
            answer += (int) Math.pow(Math.pow(2, n - 1), 2) * 3;
        }
    }
}