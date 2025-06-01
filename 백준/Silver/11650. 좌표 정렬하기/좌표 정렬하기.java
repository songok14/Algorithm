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

        // Arrays.sort()와 람다식을 사용하여 정렬
        // Arrays.sort(배열, 비교자 -> 람다식)
        // 1. x좌표를 기준으로 오름차순 정렬
        // 2. x좌표가 같으면 y좌표를 기준으로 오름차순 정렬
        Arrays.sort(points, (p1, p2) -> {
            if (p1[0] == p2[0]) {
                // x좌표가 같으면 y좌표를 비교 (오름차순)
                return p1[1] - p2[1];
            } else {
                // x좌표가 다르면 x좌표를 비교 (오름차순)
                return p1[0] - p2[0];
            }
        });

        // 정렬된 결과를 StringBuilder에 담아 한 번에 출력 (효율성 증대)
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(points[i][0]).append(" ").append(points[i][1]).append("\n");
        }

        bw.write(sb.toString()); // BufferedWriter를 사용하여 출력
        bw.flush(); // 버퍼에 남아있는 내용을 모두 출력
        bw.close();
        br.close();
    }
}