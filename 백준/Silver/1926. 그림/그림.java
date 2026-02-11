import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] nm = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = nm[0];
        int m = nm[1];

        int[][] painting = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        int count = 0;
        int max = 0;

        for (int i = 0; i < n; i++) {
            painting[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        Queue<int[]> myQ = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (painting[i][j] == 1 && !visited[i][j]) {
                    int size = 1;
                    count++;
                    myQ.offer(new int[]{i, j});
                    visited[i][j] = true;

                    while (!myQ.isEmpty()) {
                        int[] temp = myQ.poll();
                        int cx = temp[0];
                        int cy = temp[1];

                        max = Math.max(max, size);

                        for (int k = 0; k < 4; k++) {
                            int nx = cx + dx[k];
                            int ny = cy + dy[k];

                            if (nx >= 0 && ny >= 0 && nx < n && ny < m && !visited[nx][ny] && painting[nx][ny] == 1) {
                                myQ.offer(new int[]{nx, ny});
                                visited[nx][ny] = true;
                                size++;
                            }
                        }
                    }

                }
            }
        }

        System.out.println(count);
        System.out.println(max);
        br.close();
    }
}