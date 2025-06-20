import java.io.*;

public class Main {
    static boolean[][] graph;
    static boolean[] visited;
    static int comCount, coupleCount;
    static int virusCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuffer sb = new StringBuffer();

        comCount = Integer.parseInt(br.readLine());
        coupleCount = Integer.parseInt(br.readLine());

        graph = new boolean[comCount + 1][comCount + 1];
        visited = new boolean[comCount + 1];

        for (int i = 0; i < coupleCount; i++) {
            String[] couple = br.readLine().split(" ");
            int x = Integer.parseInt(couple[0]);
            int y = Integer.parseInt(couple[1]);
            graph[x][y] = graph[y][x] = true;
        }
        br.close();

        dfs(1);
        sb.append(virusCount-1);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    public static void dfs(int n){
        virusCount++;
        visited[n] = true;

        for(int i=1; i<= comCount; i++) {
            if (!visited[i] && graph[n][i]){
                dfs(i);
            }
        }
    }
}