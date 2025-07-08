import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String[] testCase = br.readLine().split(" ");
        int n = Integer.parseInt(testCase[0]);
        int m = Integer.parseInt(testCase[1]);
        int[][] map = new int[n][m];
        int[][] result = new int[n][m];
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        int startX = 0;
        int startY = 0;
        for (int i = 0; i < n; i++) {
            String[] inputs = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(inputs[j]);
                if (map[i][j] == 2) {
                    startX = i;
                    startY = j;
                    result[i][j] = 0;
                } else if (map[i][j] == 1) {
                    result[i][j] = -1;
                } else {
                    result[i][j] = 0;
                }
            }
        }

        Queue<int[]> myQ = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];

        myQ.add(new int[]{startX, startY, 0});
        visited[startX][startY] = true;

        while (!myQ.isEmpty()) {
            int[] temp = myQ.poll();
            int x = temp[0];
            int y = temp[1];

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                if (nx >= 0 && ny >= 0 && nx < n && ny < m && !visited[nx][ny]) {
                    if (map[nx][ny] == 0) {
                        visited[nx][ny] = true;
                        continue;
                    } else if (map[nx][ny] == 1) {
                        result[nx][ny] = temp[2] + 1;
                        myQ.add(new int[]{nx, ny, temp[2] + 1});
                        visited[nx][ny] = true;
                    }
                }
            }
        }

        for (int[] arr : result) {
            for (int a : arr) {
                sb.append(a).append(" ");
            }
            sb.append("\n");
        }

        br.close();
        bw.write(sb.toString().trim());
        bw.flush();
        bw.close();

    }
}