import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] dx = {0, 0, 1, -1, 0, 0};
        int[] dy = {0, 0, 0, 0, 1, -1};
        int[] dz = {1, -1, 0, 0, 0, 0};

        int[] mnh = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int m = mnh[0];
        int n = mnh[1];
        int h = mnh[2];

        int[][][] tomatoes = new int[m][n][h];
        Queue<int[]> myQ = new ArrayDeque<>();
        boolean[][][] visited = new boolean[m][n][h];

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                for (int k = 0; k < m; k++) {
                    tomatoes[k][j][i] = inputs[k];
                    if (inputs[k] == 1) {
                        myQ.offer(new int[]{k, j, i, 0});
                        visited[k][j][i] = true;
                    }
                }
            }
        }

        int days = 0;
        while (!myQ.isEmpty()) {
            int[] temp = myQ.poll();
            int cx = temp[0];
            int cy = temp[1];
            int cz = temp[2];
            days = temp[3];

            for (int i = 0; i < 6; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                int nz = cz + dz[i];

                if (nx < 0 || ny < 0 || nz < 0 || nx >= m || ny >= n || nz >= h) continue;
                if (tomatoes[nx][ny][nz] == -1 || visited[nx][ny][nz]) continue;

                tomatoes[nx][ny][nz] = 1;
                myQ.offer(new int[]{nx, ny, nz, days + 1});
                visited[nx][ny][nz] = true;
            }
        }

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (tomatoes[k][j][i] == 0) {
                        days = -1;
                        break;
                    }
                }
            }
        }

        System.out.println(days);
    }
}