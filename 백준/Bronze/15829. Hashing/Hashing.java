import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main { 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine());
        String al = br.readLine();
        long r = 31;
        long m = 1234567891;
        long result = 0;
        long power_r = 1; // 이 변수는 r^i % m 값을 저장합니다.

        for (int i = 0; i < al.length(); i++) {
            long char_val = al.charAt(i) - 96; // 'a'는 97이므로, 'a' - 96 = 1 입니다.

            // 현재 항 계산: (char_val * (r^i % m)) % m
            long term = (char_val * power_r) % m;

            // 결과에 더하기: result = (result + term) % m
            result = (result + term) % m;

            // 다음 반복을 위해 power_r 업데이트: power_r = (power_r * r) % m
            // 다음 루프에서는 r^(i+1) % m 값이 됩니다.
            power_r = (power_r * r) % m;
        }

        System.out.println(result);
        br.close();
    }
}