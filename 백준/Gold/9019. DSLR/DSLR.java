import java.io.*;
import java.util.*;

public class Main {
    public static class Node {
        int num;
        String command;

        public Node(int num, String command) {
            this.num = num;
            this.command = command;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine());

        while (testCase > 0) {
            int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int origin = inputs[0];
            int target = inputs[1];

            Queue<Node> myQ = new ArrayDeque<>();
            boolean[] visited = new boolean[10000];
            myQ.offer(new Node(origin, ""));
            visited[origin] = true;

            while (!myQ.isEmpty()) {
                Node current = myQ.poll();
                int n = current.num;

                if (current.num == target) {
                    sb.append(current.command).append("\n");
                    break;
                }

                int D = (n * 2) % 10000;
                int S = n == 0 ? 9999 : n - 1;
                int L = (n % 1000) * 10 + (n / 1000);
                int R = (n % 10) * 1000 + (n / 10);

                if (!visited[D]) {
                    myQ.offer(new Node(D, current.command + "D"));
                    visited[D] = true;
                }
                if (!visited[S]) {
                    myQ.offer(new Node(S, current.command + "S"));
                    visited[S] = true;
                }
                if (!visited[L]) {
                    myQ.offer(new Node(L, current.command + "L"));
                    visited[L] = true;
                }
                if (!visited[R]) {
                    myQ.offer(new Node(R, current.command + "R"));
                    visited[R] = true;
                }
            }
            testCase--;
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}