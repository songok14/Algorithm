import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = inputs[0];
        int m = inputs[1];

        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            for (int j = 0; j < m; j++) {
                map[i][j] = inputs[j];
            }
        }

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        int year = 0;

        while (true) {
            int[][] tempMap = new int[n][m];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    int zero = 0;

                    if (map[i][j] == 0) {
                        tempMap[i][j] = 0;
                    } else {
                        for (int d = 0; d < 4; d++) {
                            int nx = i + dx[d];
                            int ny = j + dy[d];

                            if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                            if (map[nx][ny] != 0) continue;
                            zero++;
                        }

                        tempMap[i][j] = (map[i][j] - zero > 0) ? (map[i][j] - zero) : 0;
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                map[i] = tempMap[i].clone();
            }

            int count = 0;
            Queue<int[]> myQ = new ArrayDeque<>();
            boolean[][] visited = new boolean[n][m];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (map[i][j] > 0 && !visited[i][j]) {
                        count++;
                    } else continue;

                    myQ.offer(new int[]{i, j});
                    visited[i][j] = true;

                    while (!myQ.isEmpty()) {
                        int[] current = myQ.poll();
                        int cx = current[0];
                        int cy = current[1];

                        for (int d = 0; d < 4; d++) {
                            int nx = cx + dx[d];
                            int ny = cy + dy[d];

                            if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                            if (map[nx][ny] == 0 || visited[nx][ny]) continue;

                            myQ.offer(new int[]{nx, ny});
                            visited[nx][ny] = true;
                        }
                    }
                }
            }

            year++;
            if (count >= 2) {
                break;
            } else if (count == 0) {
                year = 0;
                break;
            }
        }

        System.out.println(year);
        br.close();
    }
}