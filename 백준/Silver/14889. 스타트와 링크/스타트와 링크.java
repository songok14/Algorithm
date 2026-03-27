import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] status;
    static boolean[] selected;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        status = new int[n][n];
        selected = new boolean[n];
        for (int i = 0; i < n; i++) {
            status[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        combi(0, 0);
        System.out.println(min);
    }

    public static void combi(int start, int depth) {
        if (depth == n / 2) {
            int startTeam = 0;
            int linkTeam = 0;

            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (selected[i] && selected[j]) {
                        startTeam += status[i][j] + status[j][i];
                    } else if (!selected[i] && !selected[j]) {
                        linkTeam += status[i][j] + status[j][i];
                    }
                }
            }

            min = Math.min(min, Math.abs(startTeam - linkTeam));
            return;
        }

        for (int i = start; i < n; i++) {
            selected[i] = true;
            combi(i + 1, depth + 1);
            selected[i] = false;
        }
    }
}