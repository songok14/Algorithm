import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    static String[][] map;
    static Set<String> mySet = new HashSet<>();
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        map = new String[5][5];

        for (int i = 0; i < 5; i++) {
            String[] inputs = br.readLine().split(" ");
            for (int j = 0; j < 5; j++) {
                map[i][j] = inputs[j];
            }
        }

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                bfs(i, j, 0, "");
            }
        }
        System.out.println(mySet.size());

        br.close();
    }

    static void bfs(int x, int y, int count, String temp) {
        if (x > 4 || x < 0 || y > 4 || y < 0) {
            return;
        }
        temp += map[x][y];

        if (temp.length() == 6) {
            mySet.add(temp);
            return;
        }


        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            count++;
            bfs(nx, ny, count, temp);
        }
    }
}