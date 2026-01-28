import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] align = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(align);

        int sum = 0;
        int total = 0;
        for (int i = 0; i < N; i++) {
            sum = sum + align[i];
            total += sum;
        }

        System.out.println(total);

        br.close();
    }
}