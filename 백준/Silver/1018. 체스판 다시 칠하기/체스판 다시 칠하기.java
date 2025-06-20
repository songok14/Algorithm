import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuffer sb = new StringBuffer();

        String[] numbers = br.readLine().split(" ");
        int n = Integer.parseInt(numbers[0]);
        int m = Integer.parseInt(numbers[1]);

        // 배열에 체스판 저장 (char 배열로 변경)
        char[][] board = new char[n][m];
        for (int i = 0; i < n; i++) {
            String inputLine = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = inputLine.charAt(j);
            }
        }

        List<Integer> countList = new ArrayList<>();

        for (int row = 0; row <= n - 8; row++) {
            for (int col = 0; col <= m - 8; col++) {
                int countWStart = 0;
                int countBStart = 0;

                // 현재 8x8 서브 보드 내부를 탐색
                for (int i = 0; i < 8; i++) { // 보드의 행 인덱스 (0~7)
                    for (int j = 0; j < 8; j++) { // 보드의 열 인덱스 (0~7)
                        // 실제 체스판의 위치 (row + i, col + j)
                        char currentColor = board[row + i][col + j];

                        // 'W'로 시작하는 체스판의 경우, (i,j) 위치에 와야 할 색상
                        // (행 인덱스 + 열 인덱스) 합이 짝수이면 'W', 홀수이면 'B'
                        char expectedW = ((i + j) % 2 == 0) ? 'W' : 'B';
                        // 'B'로 시작하는 체스판의 경우, (i,j) 위치에 와야 할 색상
                        // (행 인덱스 + 열 인덱스) 합이 짝수이면 'B', 홀수이면 'W'
                        char expectedB = ((i + j) % 2 == 0) ? 'B' : 'W';

                        if (currentColor != expectedW) {
                            countWStart++;
                        }
                        if (currentColor != expectedB) {
                            countBStart++;
                        }
                    }
                }
                // 두 가지 경우 중 더 적은 변경 횟수를 리스트에 추가
                countList.add(Math.min(countWStart, countBStart));
            }
        }

        // 리스트에 저장된 변경 횟수 중 최솟값 찾기
        countList.sort(Comparator.naturalOrder());
        sb.append(countList.get(0));

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}