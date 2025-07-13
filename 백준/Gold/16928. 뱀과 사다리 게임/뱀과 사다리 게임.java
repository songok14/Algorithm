import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] testCase = br.readLine().split(" ");
        int n = Integer.parseInt(testCase[0]);
        int m = Integer.parseInt(testCase[1]);
        int[][] ladder = new int[n][2];
        int[][] snake = new int[m][2];

        // 사다리 정보
        for (int i = 0; i < n; i++) {
            String[] inputs = br.readLine().split(" ");
            ladder[i][0] = Integer.parseInt(inputs[0]);
            ladder[i][1] = Integer.parseInt(inputs[1]);
        }

        // 뱀 정보
        for (int i = 0; i < m; i++) {
            String[] inputs = br.readLine().split(" ");
            snake[i][0] = Integer.parseInt(inputs[0]);
            snake[i][1] = Integer.parseInt(inputs[1]);
        }

        int[] dice = {1, 2, 3, 4, 5, 6};
        Queue<int[]> myQ = new LinkedList<>();
        boolean[] visited = new boolean[101];

        int count = 0;
        myQ.add(new int[]{1, count});    // {위치, 카운트}
        visited[0] = visited[1] = true;

        while (!myQ.isEmpty()) {
            int[] temp = myQ.poll();

            if (temp[0] == 100) {
                System.out.println(temp[1]);
                break;
            }

            for (int i = 0; i < 6; i++) {
                int nx = temp[0] + dice[i];

                if (nx <= 100 && !visited[nx]) {
                    for (int j = 0; j < ladder.length; j++) {
                        if (nx == ladder[j][0]) {
                            nx = ladder[j][1];
                        }
                    }

                    for (int j = 0; j < snake.length; j++) {
                        if (nx == snake[j][0]) {
                            nx = snake[j][1];
                        }
                    }

                    myQ.add(new int[]{nx, temp[1] + 1});
                    visited[nx] = true;
                }
            }
        }

        br.close();
    }
}