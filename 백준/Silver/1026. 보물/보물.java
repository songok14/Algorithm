import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> A = new PriorityQueue<>();
        PriorityQueue<Integer> B = new PriorityQueue<>(Collections.reverseOrder());

        Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).forEach(A::add);
        Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).forEach(B::add);

        int sum = 0;
        for (int i=0; i<N; i++){
            sum += A.poll() * B.poll();
        }

        System.out.println(sum);
        br.close();
    }
}