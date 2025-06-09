import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int sum = 0;

        for (int i = 0; i < testCase; i++) {
            int number = Integer.parseInt(br.readLine());
            if(number !=0){
                stack.push(number);
            } else {
                stack.pop();
            }
        }

        while (!stack.isEmpty()){
            sum += stack.pop();
        }

        System.out.println(sum);
    }
}