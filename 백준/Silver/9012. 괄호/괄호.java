import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            String[] strArr = br.readLine().split("");
            Stack<String> stack = new Stack<>();
            for (int j = 0; j < strArr.length; j++) {
                if (strArr[j].equals("(")) {
                    stack.push(strArr[j]);
                } else if (strArr[j].equals(")")) {
                    if (stack.isEmpty()) {
                        stack.push(strArr[j]);
                        break;
                    } else if (stack.peek().equals("(")) {
                        stack.pop();
                    } else {
                        break;
                    }
                }
            }

            if (stack.isEmpty()) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}