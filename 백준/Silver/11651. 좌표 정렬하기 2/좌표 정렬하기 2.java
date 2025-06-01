import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine()); // 점의 개수

        // N개의 점 (x, y)를 저장할 2차원 배열
        // points[i][0] = x좌표, points[i][1] = y좌표
        int[][] points = new int[N][2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            points[i][0] = Integer.parseInt(st.nextToken()); // x 좌표
            points[i][1] = Integer.parseInt(st.nextToken()); // y 좌표
        }

        Arrays.sort(points, (p1, p2) -> {
            if (p1[1] == p2[1]) {
                return p1[0] - p2[0];
            } else {
                return p1[1] - p2[1];
            }
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(points[i][0]).append(" ").append(points[i][1]).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}