import java.io.*;

public class Main {
    public static int[][] graph;
    public static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuffer sb = new StringBuffer();

        String[] testCase = br.readLine().split(" ");
        int n = Integer.parseInt(testCase[0]);
        int m = Integer.parseInt(testCase[1]);
        graph = new int[n + 1][n + 1];
        visited = new boolean[n + 1];
        visited[0] = true;
        int count = 0;

        for (int i = 0; i < m; i++) {
            String[] inputs = br.readLine().split(" ");
            int x = Integer.parseInt(inputs[0]);
            int y = Integer.parseInt(inputs[1]);

            graph[x][y] = graph[y][x] = 1;
        }

        for (int i = 1; i < graph.length; i++) {
            if (visited[i]) {
                continue;
            } else {
                count++;
                dfs(i);
            }
        }
        sb.append(count);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs(int n) {
        visited[n] = true;
        for (int i = 1; i < graph.length; i++) {
            if (!visited[i] && graph[i][n] == 1) {
                dfs(i);
            }
        }
    }
}