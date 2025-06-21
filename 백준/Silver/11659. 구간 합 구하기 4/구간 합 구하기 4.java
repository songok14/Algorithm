import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuffer sb = new StringBuffer();

        String[] testCase = br.readLine().split(" ");
        int n = Integer.parseInt(testCase[0]);
        int m = Integer.parseInt(testCase[1]);

        // 누적 합 구하여 배열에 저장
        // 0번 인덱스는 0, 1번 인덱스는 0번+현재값, 2번 인덱스는 1번+현재값 ...
        int[] numbers = new int[n+1];
        numbers[0] = 0;
//        List<Integer> numbers = new ArrayList<>();
//        numbers.add(0);

        String[] inputs = br.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            numbers[i] = numbers[i - 1] + Integer.parseInt(inputs[i-1]);
//            numbers.add(numbers.get(i-1)+Integer.parseInt(inputs[i-1]));
        }

        // 저장한 누적합에서 뺄셈으로 n ~ m까지의 합 구하기
        // ex) 2 ~ 5의 합: 5번 - 1번 / 1 ~ 3의 합: 3번 - 0번 이기 때문에 0번에 0 저장 중요!
        // sum = end - (start - 1)
        while (m > 0) {
            String[] range = br.readLine().split(" ");
            int start = Integer.parseInt(range[0]);
            int end = Integer.parseInt(range[1]);

            sb.append(numbers[end] - numbers[start - 1]).append("\n");
//            sb.append(numbers.get(end) - numbers.get(start-1)).append("\n");

            m--;
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}