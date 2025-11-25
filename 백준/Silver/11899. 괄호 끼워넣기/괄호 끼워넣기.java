import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<String> parentheses = new Stack<>();
        String[] arr = br.readLine().split("");

        for (String temp : arr) {
            if (!parentheses.isEmpty() && parentheses.peek().equals("(") && temp.equals(")")){
                parentheses.pop();
            } else {
                parentheses.add(temp);
            }
        }

        System.out.println(parentheses.size());

        br.close();
    }
}
