import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static List<int[]> house = new ArrayList<>();
    static List<int[]> chicken = new ArrayList<>();
    static int[] selected;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = inputs[0];
        m = inputs[1];

        int[][] map = new int[n][n];
        house = new ArrayList<>();
        chicken = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < n; j++) {
                map[i][j] = inputs[j];
                if (inputs[j] == 1) {
                    house.add(new int[]{i, j});
                } else if (inputs[j] == 2) {
                    chicken.add(new int[]{i, j});
                }
            }
        }

        selected = new int[m];
        combi(0, 0);

        System.out.println(answer);
    }

    public static void combi(int start, int depth) {
        if (depth == m) {
            // 치킨집까지 거리 계산
            int chickenDist = 0;

            for (int[] h : house) {
                int minDist = Integer.MAX_VALUE;

                for (int i = 0; i < m; i++) {
                    int[] c = chicken.get(selected[i]);
                    int dist = Math.abs(h[0] - c[0]) + Math.abs(h[1] - c[1]);
                    minDist = Math.min(minDist, dist);
                }

                chickenDist += minDist;
            }

            answer = Math.min(answer, chickenDist);
            return;
        }

        for (int i = start; i < chicken.size(); i++) {
            selected[depth] = i;
            combi(i + 1, depth + 1);
        }
    }
}