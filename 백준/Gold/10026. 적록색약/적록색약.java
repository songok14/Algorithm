import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] mapA = new int[n][n];
        int[][] mapB = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] inputs = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                if (inputs[j].equals("R")) {
                    mapA[i][j] = 0;
                    mapB[i][j] = 0;
                } else if (inputs[j].equals("G")) {
                    mapA[i][j] = 1;
                    mapB[i][j] = 0;
                } else {
                    mapA[i][j] = 2;
                    mapB[i][j] = 1;
                }
            }
        }

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};


        // 일반인
        Queue<int[]> myQ = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (!visited[i][j]) {
                    myQ.add(new int[]{i, j, mapA[i][j]});
                    visited[i][j] = true;
                    count++;
                } else {
                    continue;
                }

                while (!myQ.isEmpty()) {
                    int[] temp = myQ.poll();

                    for (int k = 0; k < 4; k++) {
                        int nx = temp[0] + dx[k];
                        int ny = temp[1] + dy[k];

                        if (nx>=0 && ny>=0 && nx<n && ny<n && !visited[nx][ny] && mapA[nx][ny] == temp[2]){
                            myQ.add(new int[]{nx, ny, temp[2]});
                            visited[nx][ny] = true;
                        }
                    }
                }
            }
        }
        System.out.print(count+" ");

        // 적록색약
        myQ.clear();
        visited = new boolean[n][n];
        count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (!visited[i][j]) {
                    myQ.add(new int[]{i, j, mapB[i][j]});
                    visited[i][j] = true;
                    count++;
                } else {
                    continue;
                }

                while (!myQ.isEmpty()) {
                    int[] temp = myQ.poll();

                    for (int k = 0; k < 4; k++) {
                        int nx = temp[0] + dx[k];
                        int ny = temp[1] + dy[k];

                        if (nx>=0 && ny>=0 && nx<n && ny<n && !visited[nx][ny] && mapB[nx][ny] == temp[2]){
                            myQ.add(new int[]{nx, ny, temp[2]});
                            visited[nx][ny] = true;
                        }
                    }
                }
            }
        }

        System.out.println(count);

        br.close();
    }
}