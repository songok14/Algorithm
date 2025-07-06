import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] testCase = br.readLine().split(" ");
        int n = Integer.parseInt(testCase[0]);
        int k = Integer.parseInt(testCase[1]);

        int[] dx = {1, -1, 2};
        Queue<int[]> myQ = new LinkedList<>();
        boolean[] visited = new boolean[100001];
        myQ.add(new int[]{n, 0});   // 현재 수빈이의 위치, 이동한 시간
        visited[n] = true;
        int time = 0;

        while (!myQ.isEmpty()) {
            int[] temp = myQ.poll();

            if (temp[0] == k) {
                time = temp[1];
            }

            for (int i = 0; i < 3; i++) {
                int nx = temp[0];
                if (dx[i] == 2) {
                    nx *= 2;
                } else {
                    nx = temp[0] + dx[i];
                }

                if (nx >= 0 && nx < visited.length && !visited[nx]) {
                    myQ.add(new int[]{nx, temp[1] + 1});
                    visited[nx] = true;
                }
            }
        }
        System.out.println(time);

        br.close();
    }
}