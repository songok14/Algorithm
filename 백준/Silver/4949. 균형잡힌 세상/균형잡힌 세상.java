import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String[] strArr = br.readLine().split("");
            Stack<String> stack = new Stack<>();

            if (strArr[0].equals(".")) {
                break;
            }

            for (int i = 0; i < strArr.length; i++) {
                if (strArr[i].equals("(") || strArr[i].equals("[")) {
                    stack.push(strArr[i]);
                } else if (strArr[i].equals(")")) {
                    if (stack.isEmpty()) {
                        stack.push(strArr[i]);
                        break;
                    } else if (stack.peek().equals("(")) {
                        stack.pop();
                    } else {
                        break;
                    }
                } else if (strArr[i].equals("]")) {
                    if (stack.isEmpty()) {
                        stack.push(strArr[i]);
                        break;
                    } else if (stack.peek().equals("[")) {
                        stack.pop();
                    } else {
                        break;
                    }
                }


            }

            if (stack.isEmpty()) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}