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
        boolean[][] visited = new boolean[n][m];
        
        int[] dx = {1, -1, 0, 0}; 
        int[] dy = {0, 0, 1, -1};

        int startX = 0;
        int startY = 0;

        for (int i = 0; i < n; i++) {
            String[] inputs = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(inputs[j]);
                
                if (map[i][j] == 1) {
                    result[i][j] = -1; 
                } else if (map[i][j] == 2) {
                    startX = i;
                    startY = j;
                    result[i][j] = 0;
                } else {
                    result[i][j] = 0;
                }
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        
        queue.add(new int[]{startX, startY, 0});
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int distance = current[2];

            for (int k = 0; k < 4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m && !visited[nx][ny]) {
                    if (map[nx][ny] == 0) {
                        visited[nx][ny] = true;
                        continue; 
                    } 
                    else if (map[nx][ny] == 1) {
                        visited[nx][ny] = true;
                        result[nx][ny] = distance + 1;
                        queue.add(new int[]{nx, ny, distance + 1});
                    }
                }
            }
        }

        // 결과 출력
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(result[i][j]).append(" ");
            }
            sb.append("\n");
        }

        br.close();
        bw.write(sb.toString().trim());
        bw.flush();
        bw.close();
    }
}