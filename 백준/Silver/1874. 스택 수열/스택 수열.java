import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        int number = 0;
        int testCase = Integer.parseInt(br.readLine());
        for (int i = 1; i <= testCase; i++) {
            int target = Integer.parseInt(br.readLine());

            while (true) {
                if (!stack.isEmpty() && stack.peek() == target) {
                    stack.pop();
                    sb.append("-").append("\n");
                    break;
                } else if (number >= target) {
                    break;
                } else {
                    number++;
                    stack.push(number);
                    sb.append("+").append("\n");
                }
            }
        }

        if (stack.isEmpty()) {
            bw.write(sb.toString());
        } else {
            bw.write("NO");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}