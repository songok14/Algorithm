import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int[][] graph;
    static boolean[] visited;
    static StringBuffer sb = new StringBuffer();
    static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int m = Integer.parseInt(inputs[1]);
        int v = Integer.parseInt(inputs[2]);

        graph = new int[n + 1][n + 1];
        visited = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            String[] numbers = br.readLine().split(" ");
            int x = Integer.parseInt(numbers[0]);
            int y = Integer.parseInt(numbers[1]);
            graph[x][y] = graph[y][x] = 1;
        }

        dfs(v);
        sb.append("\n");

        visited = new boolean[n + 1];
        bfs(v);


        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    public static void dfs(int n) {
        sb.append(n).append(" ");
        visited[n] = true;
        for (int i = 1; i < graph.length; i++) {
            if (!visited[i] && graph[n][i] == 1) {
                dfs(i);
            }
        }
    }

    public static void bfs(int n) {
        q.add(n);
        visited[n] = true;

        while (!q.isEmpty()) {
            n = q.poll();
            sb.append(n).append(" ");

            for (int i = 1; i < graph.length; i++) {
                if (!visited[i] && graph[n][i] == 1) {
                    q.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}