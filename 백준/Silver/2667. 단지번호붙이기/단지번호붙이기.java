import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        int x = -1;
        int y = -1;

        for (int i = 0; i < map.length; i++) {
            String[] inputs = br.readLine().split("");
            for (int j = 0; j < map.length; j++) {
                map[i][j] = Integer.parseInt(inputs[j]);
            }
        }

        Queue<int[]> myQ = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];
        List<Integer> myList = new ArrayList<>();
        int index = -1;

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    index++;
                    myQ.add(new int[]{i, j});
                    visited[i][j] = true;

                    while (!myQ.isEmpty()) {
                        int[] temp = myQ.poll();
                        if (myList.size() >= index + 1) {
                            myList.set(index, myList.get(index) + 1);
                        } else {
                            myList.add(1);
                        }

                        for (int k = 0; k < 4; k++) {
                            int nx = temp[0] + dx[k];
                            int ny = temp[1] + dy[k];

                            if (nx >= 0 && ny >= 0 && nx < map.length && ny < map.length && !visited[nx][ny] && map[nx][ny] != 0) {
                                myQ.add(new int[]{nx, ny});
                                visited[nx][ny] = true;
                            }
                        }
                    }

                }
            }
        }
        sb.append(myList.size()).append("\n");

        myList.sort((o1, o2) -> o1 - o2);
        for (int n : myList){
            sb.append(n).append("\n");
        }

        br.close();
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}