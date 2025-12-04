import java.io.*;
import java.util.*;

public class Main {
    static int[] arr = new int[2000001];
    static int[] numbers;
    static boolean[] visit;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        numbers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int answer = 0;
        visit = new boolean[N];

        dfs(0, 0);

        for (int i=1; i<arr.length; i++){
            if (arr[i] == 0){
                answer = i;
                break;
            }
        }

        System.out.println(answer);
        br.close();
    }

    public static void dfs(int sum, int start) {
        if (start == N) {
            if (sum > 0 && sum < arr.length) {
                arr[sum] = 1;
            }
            return;
        }
        dfs(sum + numbers[start], start + 1);
        dfs(sum, start + 1);
    }
}