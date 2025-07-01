import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int answer = -1;
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        Queue<int[]> myQ = new LinkedList<>();
        boolean[][] visitied = new boolean[maps.length][maps[0].length];

        int distance = 0;
        myQ.add(new int[]{0, 0, distance});
        visitied[0][0] = true;

        while (!myQ.isEmpty()) {
            int[] temp = myQ.poll();

            if (temp[0] == maps.length-1 && temp[1] == maps[0].length-1) {
                answer = temp[2] + 1;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nx = temp[0] + dx[i];
                int ny = temp[1] + dy[i];

                if (nx >= 0 && nx < maps.length && ny >= 0 && ny < maps[0].length && !visitied[nx][ny]) {
                    if (maps[nx][ny] == 0) {
                        continue;
                    }
                    distance = temp[2] + 1;
                    myQ.add(new int[]{nx, ny, distance});
                    visitied[nx][ny] = true;
                }
            }
        }

        return answer;
    }
}