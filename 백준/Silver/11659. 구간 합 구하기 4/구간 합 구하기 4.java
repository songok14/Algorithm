import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuffer sb = new StringBuffer();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 누적 합 구하여 배열에 저장
        // 0번 인덱스는 0, 1번 인덱스는 0번+현재값, 2번 인덱스는 1번+현재값 ...
        int[] numbers = new int[n+1];
        numbers[0] = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            numbers[i] = numbers[i - 1] + Integer.parseInt(st.nextToken());
        }

        // 저장한 누적합에서 뺄셈으로 n ~ m까지의 합 구하기
        // ex) 2 ~ 5의 합: 5번 - 1번 / 1 ~ 3의 합: 3번 - 0번 이기 때문에 0번에 0 저장 중요!
        // sum = end - (start - 1)
        while (m > 0) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            sb.append(numbers[end] - numbers[start - 1]).append("\n");

            m--;
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}