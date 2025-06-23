import java.io.*;

public class Main {
    static int[][] graph;
    static boolean[][] visited;
    static int count;

    static int[] x = {0, 0, -1, 1};
    static int[] y = {-1, 1, 0, 0};
    static int nowX, nowY;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuffer sb = new StringBuffer();

        int testCase = Integer.parseInt(br.readLine());

        while (testCase > 0) {
            String[] inputs = br.readLine().split(" ");
            int m = Integer.parseInt(inputs[0]);
            int n = Integer.parseInt(inputs[1]);
            int k = Integer.parseInt(inputs[2]);

            graph = new int[m][n];
            visited = new boolean[m][n];
            count = 0;

            for (int i = 0; i < k; i++) {
                String[] location = br.readLine().split(" ");
                graph[Integer.parseInt(location[0])][Integer.parseInt(location[1])] = 1;
            }

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (graph[i][j] == 1 && visited[i][j] == false) {
                        count++;
                        dfs(i, j);
                    }
                }
            }
            sb.append(count).append("\n");
            testCase--;
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    public static void dfs(int i, int j) {
        visited[i][j] = true;

        for (int n=0; n<4; n++){
            nowX = i + x[n];
            nowY = j + y[n];

            if (range(nowX, nowY) && visited[nowX][nowY]==false && graph[nowX][nowY] == 1) {
                dfs(nowX, nowY);
            }
        }
    }

    public static boolean range(int i, int j) {
        if (i >= 0 && i < graph.length && j >= 0 && j < graph[i].length) {
            return true;
        } else {
            return false;
        }
    }
}