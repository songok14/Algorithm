import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] testCase = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = testCase[0];
        int M = testCase[1];
        int K = testCase[2];

        int[][] map = new int[N][M];
        boolean[][] visited = new boolean[N][M];
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        for (int i = 0; i < K; i++) {
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            map[input[0] - 1][input[1] - 1] = 1;
        }

        int max = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    int size = 0;
                    Queue<int[]> myQ = new LinkedList<>();
                    myQ.offer(new int[]{i, j});
                    visited[i][j] = true;

                    while (!myQ.isEmpty()) {
                        int[] temp = myQ.poll();
                        size++;

                        for (int d = 0; d < 4; d++) {
                            int nx = temp[0] + dx[d];
                            int ny = temp[1] + dy[d];

                            if (nx >= 0 && ny >= 0 && nx < N && ny < M && map[nx][ny] == 1 && !visited[nx][ny]) {
                                myQ.offer(new int[]{nx, ny});
                                visited[nx][ny] = true;
                            }
                        }
                        max = Math.max(max, size);
                    }
                }
            }
        }

        System.out.println(max);
        br.close();
    }
}