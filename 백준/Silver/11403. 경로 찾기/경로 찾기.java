import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        List<List<Integer>> myList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            myList.add(new ArrayList<>());
            String[] inputs = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                if (inputs[j].equals("1")) {
                    myList.get(i).add(j);
                }
            }
        }

        int[][] result = new int[n][n];
        for (int i = 0; i < n; i++) {
            Queue<Integer> myQ = new LinkedList<>();
            boolean[] visited = new boolean[n];
            for (int j : myList.get(i)){
                myQ.add(j);
                visited[j] = true;
                result[i][j] = 1;
            }

            while (!myQ.isEmpty()) {
                int temp = myQ.poll();
                result[i][temp] = 1;

                for (int j : myList.get(temp)) {
                    if (!visited[j]) {
                        myQ.add(j);
                        visited[j] = true;
                    }
                }
            }
        }

        for (int[] arr : result) {
            for (int a : arr) {
                sb.append(a).append(" ");
            }
            sb.append("\n");
        }

        br.close();
        bw.write(sb.toString().trim());
        bw.flush();
        bw.close();
    }
}