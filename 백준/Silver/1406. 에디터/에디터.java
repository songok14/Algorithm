import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        Stack<String> left = new Stack<>();
        Stack<String> right = new Stack<>();

        String[] existing = br.readLine().split("");
        left.addAll(Arrays.asList(existing));

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            String[] testCase = br.readLine().split(" ");
            switch (testCase[0]) {
                case "L": {
                    if (!left.isEmpty()) {
                        right.add(left.pop());
                    }
                    break;
                }
                case "D": {
                    if (!right.isEmpty()) {
                        left.add(right.pop());
                    }
                    break;
                }
                case "B": {
                    if (!left.isEmpty()) {
                        left.pop();
                    }
                    break;
                }
                case "P": {
                    left.add(testCase[1]);
                    break;
                }
            }
        }

        while (!left.isEmpty()) {
            sb.append(left.pop());
        }
        sb.reverse();
        bw.write(sb.toString());
        sb.delete(0, sb.length());

        while (!right.isEmpty()) {
            sb.append(right.pop());
        }
        bw.write(sb.toString());

        bw.flush();
        bw.close();
        br.close();
    }
}