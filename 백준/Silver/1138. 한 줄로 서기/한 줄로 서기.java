import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] testCase = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] answer = new int[N];

        for (int i = 1; i <= N; i++) { // i는 사람의 키 (1부터 N까지)
            int leftCount = testCase[i - 1]; // 왼쪽에 있어야 할 키 큰 사람의 수
            int emptyCount = 0;

            for (int j = 0; j < N; j++) { // j는 줄의 위치 (0부터 N-1까지)
                // 현재 위치 j가 비어있고, 그 왼쪽에 필요한 만큼의 빈 공간이 확보된 경우
                if (answer[j] == 0 && emptyCount == leftCount) {
                    answer[j] = i; // 현재 키의 사람을 배치
                    break; // 다음 사람을 배치하러 감
                }
                
                // 현재 위치 j가 비어있으면 빈 공간 카운트 증가
                if (answer[j] == 0) {
                    emptyCount++;
                }
            }
        }

        for (int i : answer) {
            sb.append(i).append(" ");
        }

        br.close();
        bw.write(sb.toString().trim());
        bw.flush();
        bw.close();
    }
}