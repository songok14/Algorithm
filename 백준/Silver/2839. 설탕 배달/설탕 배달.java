import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int count = 0;
        br.close();

        while (N >= 0) {
            if (N % 5 == 0) {   // 0 이어도 실행
                count += N / 5;
                N %= 5;
                break;
            }
            N -= 3;
            count++;
        }

        if(N == 0) {
            System.out.println(count);
        } else {
            System.out.println(-1);
        }


    }
}