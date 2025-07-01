import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        String[] testCase = br.readLine().split(" ");
        int n = Integer.parseInt(testCase[0]);
        int m = Integer.parseInt(testCase[1]);

        String[][] map = new String[n][m];
        boolean[][] visitied = new boolean[n][m];

        int startX = -1;
        int startY = -1;

        for (int i = 0; i < n; i++) {
            String[] inputs = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                map[i][j] = inputs[j];
                if (inputs[j].equals("I")) {
                    startX = i;
                    startY = j;
                }
            }
        }
        int count = 0;

        Queue<int[]> myQ = new LinkedList<>();
        myQ.add(new int[]{startX, startY});
        visitied[startX][startY] = true;

        while (!myQ.isEmpty()) {
            int[] temp = myQ.poll();
            int x = temp[0];
            int y = temp[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < n && ny < m && !visitied[nx][ny] && !map[nx][ny].equals("X")) {
                    if (map[nx][ny].equals("P")) {
                        count++;
                    }
                    myQ.add(new int[]{nx, ny});
                    visitied[nx][ny] = true;
                }
            }
        }


        if (count == 0) {
            System.out.println("TT");
        } else {
            System.out.println(count);
        }

        br.close();
    }
}