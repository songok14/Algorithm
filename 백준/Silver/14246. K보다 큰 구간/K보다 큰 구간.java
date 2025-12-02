import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        // 수열 원소 파싱
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] numbers = new int[n];
        for(int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        // K 값 (최대 10^9)
        long k = Long.parseLong(br.readLine());

        long count = 0;
        long currentSum = 0;
        int start = 0;
        int end = 0; // 끝 포인터는 현재 포함할 인덱스를 가리킴

        while (end < n) {
            // 1. end를 오른쪽으로 이동하며 합에 numbers[end]를 추가
            currentSum += numbers[end];

            // 2. 합이 K보다 커지면, start를 이동시켜 합을 줄임
            while (currentSum > k) {
                // 현재 start를 시작으로, end를 끝으로 하는 부분 수열의 합이 K보다 크다면,
                // 끝이 end, end+1, ..., n-1인 모든 부분 수열의 합도 K보다 큽니다.
                // (수열 원소가 모두 양수이므로)
                // 개수는 (전체 n개 중 end를 포함한 끝 부분의 개수) = n - end
                count += (n - end);

                // start를 한 칸 이동시켜 합에서 A[start]를 뺌
                currentSum -= numbers[start];
                start++;
            }
            // 다음 end로 이동
            end++;
        }

        System.out.println(count);
        br.close();
    }
}