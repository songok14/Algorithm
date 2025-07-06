import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] testCase = br.readLine().split(" ");
        int n = Integer.parseInt(testCase[0]);
        int m = Integer.parseInt(testCase[1]);
        int[][] map = new int[n][m];

        for (int i = 0; i < n; i++) {
            String[] inputs = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(inputs[j]);
            }
        }

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        Queue<int[]> myQ = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];

        int distance = 0;
        myQ.add(new int[]{0, 0, 0});
        visited[0][0] = true;

        while (!myQ.isEmpty()) {
            int[] temp = myQ.poll();

            if (temp[0] == n - 1 && temp[1] == m - 1) {
                distance = temp[2];
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nx = temp[0] + dx[i];
                int ny = temp[1] + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m && !visited[nx][ny] && map[nx][ny] == 1) {
                    myQ.add(new int[]{nx, ny, temp[2] + 1});
                    visited[nx][ny] = true;
                }
            }
        }
        System.out.println(distance + 1);

        br.close();
    }
}