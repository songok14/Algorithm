import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int[] testCase = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        List<List<Integer>> myList = new ArrayList<>();
        for (int i = 0; i <= testCase[0]; i++) {
            myList.add(new ArrayList<>());
        }

        for (int i = 0; i < testCase[1]; i++) {
            int[] line = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            myList.get(line[0]).add(line[1]);
            myList.get(line[1]).add(line[0]);
        }

        for (int i = 0; i <= testCase[0]; i++) {
            myList.get(i).sort(null);
        }

        Queue<Integer> myQ = new LinkedList<>();
        myQ.add(testCase[2]);

        boolean[] visited = new boolean[testCase[0] + 1];
        visited[testCase[2]] = true;

        int count = 1;
        int[] order = new int[testCase[0] + 1];
        order[testCase[2]] = count++;

        while (!myQ.isEmpty()) {
            int temp = myQ.poll();

            for (int i : myList.get(temp)) {
                if (!visited[i]) {
                    myQ.add(i);
                    order[i] = count++;
                    visited[i] = true;
                }
            }
        }

        for (int i = 1; i <= testCase[0]; i++) {
            sb.append(order[i]).append("\n");
        }

        br.close();
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
