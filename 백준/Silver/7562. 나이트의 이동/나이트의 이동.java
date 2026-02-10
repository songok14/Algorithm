import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine());
        int[] dx = {1, 2, 2, 1, -1, -2, -2, -1};
        int[] dy = {2, 1, -1, -2, -2, -1, 1, 2};

        while (testCase > 0) {
            int size = Integer.parseInt(br.readLine());
            int[] start = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] end = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            boolean[][] visited = new boolean[size][size];
            int count = 0;

            Queue<int[]> myQ = new LinkedList<>();
            myQ.offer(new int[]{start[0], start[1], count});
            visited[start[0]][start[1]] = true;

            while (!myQ.isEmpty()) {
                int[] temp = myQ.poll();
                int cx = temp[0];
                int cy = temp[1];
                count = temp[2];

                if (cx == end[0] && cy == end[1]) {
                    sb.append(count).append("\n");
                    break;
                }

                for (int i = 0; i < 8; i++) {
                    int nx = cx + dx[i];
                    int ny = cy + dy[i];

                    if (nx >= 0 && ny >= 0 && nx < size && ny < size && !visited[nx][ny]) {
                        myQ.offer(new int[]{nx, ny, count + 1});
                        visited[nx][ny] = true;
                    }
                }
            }

            testCase--;
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}