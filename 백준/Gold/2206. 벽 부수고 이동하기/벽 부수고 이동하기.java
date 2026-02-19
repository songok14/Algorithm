import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        boolean[][][] visited = new boolean[n][m][2];
        for (int i = 0; i < n; i++) {
            map[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }

        Queue<int[]> myQ = new ArrayDeque<>();
        myQ.offer(new int[]{0, 0, 1, 1});   // x, y, 벽 부순 여부, 거리
        visited[0][0][0] = true;
        visited[0][0][1] = true;

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        int dist = -1;

        while (!myQ.isEmpty()) {
            int[] temp = myQ.poll();
            int cx = temp[0];
            int cy = temp[1];
            int broken = temp[2];
            int currentDist = temp[3];

            if (cx == n - 1 && cy == m - 1) {
                dist = currentDist;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                    if (map[nx][ny] == 1 && !visited[nx][ny][1] && broken == 1) {
                        myQ.offer(new int[]{nx, ny, 0, currentDist + 1});
                        visited[nx][ny][1] = true;
                        continue;
                    }

                    if (map[nx][ny] == 0 && !visited[nx][ny][broken]) {
                        myQ.offer(new int[]{nx, ny, broken, currentDist + 1});
                        visited[nx][ny][broken] = true;
                    }
                }
            }
        }

        System.out.println(dist);
        br.close();
    }
}