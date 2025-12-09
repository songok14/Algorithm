import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        long number;
        long count;

        public Node(long number, long count) {
            this.number = number;
            this.count = count;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] testCase = br.readLine().split(" ");
        long A = Integer.parseInt(testCase[0]);
        long B = Integer.parseInt(testCase[1]);

        long answer = -1;
        Queue<Node> myQ = new LinkedList<>();
        myQ.add(new Node(A, 0));

        while (!myQ.isEmpty()) {
            Node current = myQ.poll();
            long curNumber = current.number;
            long curCount = current.count;

            if (curNumber == B) {
                answer = curCount + 1;
                break;
            } else if (curNumber > B) {
                break;
            }

            long nextA = curNumber * 2;
            long nextB = curNumber * 10 + 1;

            if (nextA <= B) {
                myQ.add(new Node(nextA, curCount + 1));
            }
            if (nextB <= B) {
                myQ.add(new Node(nextB, curCount + 1));
            }
        }

        System.out.println(answer);
        br.close();
    }
}