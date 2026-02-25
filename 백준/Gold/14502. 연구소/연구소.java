import java.io.*;
import java.util.*;

public class Main {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int n;
    static int m;
    static int maxSafeZone;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        List<int[]> myList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int temp = Integer.parseInt(st.nextToken());
                map[i][j] = temp;

                if (temp == 0) {
                    myList.add(new int[]{i, j});
                }
            }
        }
        combi(map, myList, 0, 0);

        System.out.println(maxSafeZone);
        br.close();
    }

    public static void combi(int[][] map, List<int[]> myList, int start, int count) {
        if (count == 3) {
            maxSafeZone = Math.max(maxSafeZone, dfs(map));
            return;
        }

        for (int i = start; i < myList.size(); i++) {
            int x = myList.get(i)[0];
            int y = myList.get(i)[1];

            if (map[x][y] != 0) continue;

            map[x][y] = 1;
            combi(map, myList, i + 1, count + 1);
            map[x][y] = 0;
        }
    }

    public static int dfs(int[][] map) {
        int[][] tempMap = new int[n][m];
        Queue<int[]> myQ = new ArrayDeque<>();
        int safeZone = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                tempMap[i][j] = map[i][j];

                if (tempMap[i][j] == 2) {
                    myQ.offer(new int[]{i, j});
                }
            }
        }

        while (!myQ.isEmpty()) {
            int[] temp = myQ.poll();
            int cx = temp[0];
            int cy = temp[1];

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m && tempMap[nx][ny] == 0) {
                    myQ.offer(new int[]{nx, ny});
                    tempMap[nx][ny] = 2;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (tempMap[i][j] == 0) {
                    safeZone++;
                }
            }
        }

        return safeZone;
    }
}