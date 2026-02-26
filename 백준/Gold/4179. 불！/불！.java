import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int r = input[0];
        int c = input[1];

        String[][] map = new String[r][c];
        int[][] fireMap = new int[r][c];
        Queue<int[]> jihun = new ArrayDeque<>();
        Queue<int[]> fire = new ArrayDeque<>();
        boolean[][] jihunVisited = new boolean[r][c];
        boolean[][] fireVisited = new boolean[r][c];
        int time = 0;

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        for (int i = 0; i < r; i++) {
            String[] maze = br.readLine().split("");
            for (int j = 0; j < c; j++) {
                map[i][j] = maze[j];

                if (maze[j].equals("J")) {
                    jihun.offer(new int[]{i, j, 1});
                    jihunVisited[i][j] = true;
                }

                if (maze[j].equals("F")) {
                    fire.offer(new int[]{i, j, 1});
                    fireVisited[i][j] = true;
                    fireMap[i][j] = 1;
                }
            }
        }

        while (!fire.isEmpty()) {
            int[] temp = fire.poll();
            int cx = temp[0];
            int cy = temp[1];
            int dist = temp[2];

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx < 0 || ny < 0 || nx >= r || ny >= c || fireVisited[nx][ny]) continue;
                if (map[nx][ny].equals("#")) continue;

                fire.offer(new int[]{nx, ny, dist + 1});
                fireVisited[nx][ny] = true;
                fireMap[nx][ny] = dist + 1;
            }
        }

        while (!jihun.isEmpty()) {
            int[] temp = jihun.poll();
            int cx = temp[0];
            int cy = temp[1];
            int dist = temp[2];

            if (cx == 0 || cx == r - 1 || cy == 0 || cy == c - 1) {
                time = dist;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx < 0 || ny < 0 || nx >= r || ny >= c || jihunVisited[nx][ny] || map[nx][ny].equals("#")) continue;
                if (fireMap[nx][ny] != 0 && dist + 1 >= fireMap[nx][ny]) continue;

                jihun.offer(new int[]{nx, ny, dist + 1});
                jihunVisited[nx][ny] = true;
            }
        }

        if (time > 0) {
            System.out.println(time);
        } else {
            System.out.println("IMPOSSIBLE");
        }
        br.close();
    }
}