import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCase = Integer.parseInt(br.readLine());
        Stack<String> left = new Stack<>();
        Stack<String> right = new Stack<>();

        while (testCase > 0) {
            StringBuilder sb = new StringBuilder();
            String[] input = br.readLine().split("");
            for (int i = 0; i < input.length; i++) {
                switch (input[i]) {
                    case "<": {
                        if (!left.isEmpty()) {
                            right.add(left.pop());
                        }
                        break;
                    }
                    case ">": {
                        if (!right.isEmpty()) {
                            left.add(right.pop());
                        }
                        break;
                    }
                    case "-": {
                        if (!left.isEmpty()) {
                            left.pop();
                        }
                        break;
                    }
                    default: {
                        left.add(input[i]);
                    }
                }
            }

            while (!left.isEmpty()) {
                sb.append(left.pop());
            }
            sb.reverse();
            
            while (!right.isEmpty()) {
                sb.append(right.pop());
            }

            bw.write(sb.append("\n").toString());
            testCase--;
        }

        bw.flush();
        bw.close();
        br.close();
    }
}