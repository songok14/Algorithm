import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> s = new Stack<>();

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            if (str.contains("push")) {
                String[] push = str.split(" ");
                int num = Integer.parseInt(push[1]);
                s.push(num);
            } else if (str.contains("pop")) {
                if (s.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(s.pop());
                }
            } else if(str.contains("size")){
                System.out.println(s.size());
            } else if (str.contains("empty")){
                if(s.isEmpty()){
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
            } else {
                if(s.isEmpty()){
                    System.out.println(-1);
                } else {
                    System.out.println(s.peek());
                }
            }
        }
    }
}