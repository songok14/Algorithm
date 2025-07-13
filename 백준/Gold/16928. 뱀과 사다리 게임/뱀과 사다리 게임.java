import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] testCase = br.readLine().split(" ");
        int n = Integer.parseInt(testCase[0]);
        int m = Integer.parseInt(testCase[1]);
        int[] map = new int[101];

        for (int i=0; i<map.length; i++){
            map[i] = i;
        }

        // 사다리 정보
        for (int i = 0; i < n; i++) {
            String[] inputs = br.readLine().split(" ");
            map[Integer.parseInt(inputs[0])] = Integer.parseInt(inputs[1]);
        }

        // 뱀 정보
        for (int i = 0; i < m; i++) {
            String[] inputs = br.readLine().split(" ");
            map[Integer.parseInt(inputs[0])] = Integer.parseInt(inputs[1]);
        }

        int[] dice = {1, 2, 3, 4, 5, 6};
        Queue<int[]> myQ = new LinkedList<>();
        boolean[] visited = new boolean[101];   // 총 100칸

        int count = 0;
        myQ.add(new int[]{1, count});    // {위치, 카운트}
        visited[0] = visited[1] = true;

        while (!myQ.isEmpty()) {
            int[] temp = myQ.poll();

            // 100에 도착하면 출력 후 종료
            if (temp[0] == 100) {
                System.out.println(temp[1]);
                break;
            }

            for (int i = 0; i < 6; i++) {
                int nx = temp[0] + dice[i];

                // 이미 방문한 칸을 다시세는 건 의미가 없으니 제외, 무한루프 방지
                if (nx <= 100 && !visited[nx]) {
                    nx = map[nx];

                    myQ.add(new int[]{nx, temp[1] + 1});
                    visited[nx] = true;
                }
            }
        }

        br.close();
    }
}