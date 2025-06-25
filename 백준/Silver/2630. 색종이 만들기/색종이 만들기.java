import java.io.*;

public class Main {
    public static int[][] graph;
    public static int[] count = new int[2];
    /// 흰색: 0, 파란색: 1
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuffer sb = new StringBuffer();

        int total = Integer.parseInt(br.readLine());
        graph = new int[total][total];

        for (int i = 0; i < total; i++) {
            String[] inputs = br.readLine().split(" ");
            for (int j = 0; j < total; j++) {
                graph[i][j] = Integer.parseInt(inputs[j]);
            }
        }
        quarter(total, 0, 0);
        sb.append(count[0]).append("\n").append(count[1]);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static void quarter(int size, int row, int col) {
        boolean check = checkColor(size, row, col);

        // 같은 색이면 count++, 다른 색이면 4등분
        if (check) {
            count[graph[row][col]]++;
        } else {
            size /= 2;
            quarter(size, row, col);
            quarter(size, row, col + size);
            quarter(size, row + size, col);
            quarter(size, row + size, col + size);
        }
    }

    // 주어진 범위가 모두 같은 색인지 체크, true: 같은 색, false: 다른 색
    public static boolean checkColor(int size, int row, int col) {
        int color = graph[row][col];

        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (color != graph[i][j]) {
                    return false;   // 한 번이라도 다른색이 나오면 false
                }
            }
        }
        return true;        // 모두 같은 색이면 true
    }
}