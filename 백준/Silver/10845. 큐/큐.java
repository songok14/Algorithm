import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> q = new LinkedList<>();

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            if (str.contains("push")) {
                String[] push = str.split(" ");
                int num = Integer.parseInt(push[1]);
                q.add(num);
            } else if (str.contains("pop")) {
                if (q.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(q.poll());
                }
            } else if (str.contains("size")) {
                System.out.println(q.size());
            } else if (str.contains("empty")) {
                if (q.isEmpty()) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
            } else if (str.contains("front")) {
                if (q.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(q.peekFirst());
                }
            } else if (str.contains("back")) {
                if (q.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(q.peekLast());
                }
            }
        }
    }
}