import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int[][] map;
    static List<int[]> virus = new ArrayList<>();
    static boolean[] select;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = inputs[0];
        m = inputs[1];

        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < n; j++) {
                map[i][j] = inputs[j];

                if (inputs[j] == 2) {
                    virus.add(new int[]{i, j});
                }
            }
        }
        select = new boolean[virus.size()];

        combi(0, 0);
        System.out.println(min == Integer.MAX_VALUE? -1 : min);
    }

    public static void combi(int start, int depth) {
        if (depth == m) {
            dfs();
            return;
        }

        for (int i = start; i < virus.size(); i++) {
            select[i] = true;
            combi(i + 1, depth + 1);
            select[i] = false;
        }
    }

    public static void dfs() {
        int[][] sample = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(sample[i], -1);
        }

        Queue<int[]> myQ = new ArrayDeque<>();
        for (int i = 0; i < select.length; i++) {
            if (select[i]) {
                int[] v = virus.get(i);
                myQ.offer(v);
                sample[v[0]][v[1]] = 0;
            }
        }

        while (!myQ.isEmpty()) {
            int[] current = myQ.poll();
            int cx = current[0];
            int cy = current[1];

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                if (map[nx][ny] == 1 || sample[nx][ny] != -1) continue;

                myQ.offer(new int[]{nx, ny});
                sample[nx][ny] = sample[cx][cy] + 1;
            }
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 0) {
                    if (sample[i][j] == -1) {
                        return;
                    }

                    max = Math.max(max, sample[i][j]);
                }
            }
        }

        min = Math.min(min, max);
    }
}