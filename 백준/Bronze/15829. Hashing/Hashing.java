import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main { // 문제 : 알파벳 찾기
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        String al = br.readLine();
        int r = 31;
        int m = 1234567891;
        int result = 0;

        for (int i = 0; i < al.length(); i++) {
            result += (al.charAt(i)-96) * (int)Math.pow(r, i);
        }
        result %= m;
        System.out.println(result);
        br.close();
    }
}