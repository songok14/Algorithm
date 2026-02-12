import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        int[][] tomato = new int[n][m];
        Queue<int[]> myQ = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][m];

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        int day = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                tomato[i][j] = Integer.parseInt(st.nextToken());
                if (tomato[i][j] == 1) {
                    myQ.offer(new int[]{i, j, day});
                    visited[i][j] = true;
                }
            }
        }

        while (!myQ.isEmpty()) {
            int[] temp = myQ.poll();
            int cx = temp[0];
            int cy = temp[1];
            int currentDay = temp[2];

            day = Math.max(currentDay, day);

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m && !visited[nx][ny] && tomato[nx][ny] == 0) {
                    myQ.offer(new int[]{nx, ny, currentDay + 1});
                    tomato[nx][ny] = 1;
                    visited[nx][ny] = true;
                }
            }
        }

        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                if (tomato[i][j] == 0){
                    day = -1;
                }
            }
        }

        System.out.println(day);
        br.close();
    }
}