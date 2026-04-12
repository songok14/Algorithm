import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String[][] map = new String[n][n];
        for (int i = 0; i < n; i++) {
            String[] inputs = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                map[i][j] = inputs[j];
            }
        }

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        Queue<int[]> myQ = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j]) continue;
                myQ.offer(new int[]{i, j});
                visited[i][j] = true;
                String currentText = map[i][j];
                count++;

                while (!myQ.isEmpty()) {
                    int[] current = myQ.poll();
                    int cx = current[0];
                    int cy = current[1];

                    for (int d = 0; d < 4; d++) {
                        int nx = cx + dx[d];
                        int ny = cy + dy[d];

                        if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                        if (visited[nx][ny] || !map[nx][ny].equals(currentText)) continue;
                        myQ.offer(new int[]{nx, ny});
                        visited[nx][ny] = true;
                    }
                }
            }
        }
        System.out.print(count + " ");

        myQ.clear();
        visited = new boolean[n][n];
        count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j]) continue;
                myQ.offer(new int[]{i, j});
                visited[i][j] = true;
                String currentText = map[i][j];
                count++;

                while (!myQ.isEmpty()) {
                    int[] current = myQ.poll();
                    int cx = current[0];
                    int cy = current[1];

                    for (int d = 0; d < 4; d++) {
                        int nx = cx + dx[d];
                        int ny = cy + dy[d];

                        if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                        if (visited[nx][ny]) continue;
                        if (currentText.equals("R") || currentText.equals("G")) {
                            if (map[nx][ny].equals("B")) continue;
                            myQ.offer(new int[]{nx, ny});
                            visited[nx][ny] = true;
                        } else {
                            if (!map[nx][ny].equals(currentText)) continue;
                            myQ.offer(new int[]{nx, ny});
                            visited[nx][ny] = true;
                        }
                    }
                }
            }
        }

        System.out.println(count);

    }
}