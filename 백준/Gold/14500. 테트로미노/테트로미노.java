import java.io.*;
import java.util.*;

public class Main {
    public static int n;
    public static int m;
    public static int[][] map;
    public static boolean[][] visited;
    public static int max = Integer.MIN_VALUE;
    public static int[] dx = {1, -1, 0, 0};
    public static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = inputs[0];
        m = inputs[1];

        map = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visited[i][j] = true;
                dfs(i, j, 1, map[i][j]);
                visited[i][j] = false;

                check(i, j);
            }
        }

        System.out.println(max);
        br.close();
    }

    // ㅗ, ㅜ, ㅏ, ㅓ 계산
    public static void check(int x, int y) {
        int sum = map[x][y];
        int min = Integer.MAX_VALUE;
        int count = 0;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
            sum += map[nx][ny];
            min = Math.min(min, map[nx][ny]);
            count++;
        }

        if (count == 4) {
            max = Math.max(max, sum - min);
        } else if (count == 3) {
            max = Math.max(max, sum);
        }
    }

    // ㅗ, ㅜ, ㅏ, ㅓ 빼고 계산
    public static void dfs(int x, int y, int depth, int sum) {
        if (depth == 4) {
            max = Math.max(max, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
            if (visited[nx][ny]) continue;

            visited[nx][ny] = true;
            dfs(nx, ny, depth + 1, sum + map[nx][ny]);
            visited[nx][ny] = false;
        }
    }
}