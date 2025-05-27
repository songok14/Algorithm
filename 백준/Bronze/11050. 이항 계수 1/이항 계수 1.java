import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        br.close();

        // 이항계수 : n개 중에 k개 만큼 뽑는 조합의 수
        // 공식 : n! / (n-k)!k!
        if (k == 0 || (n - k) == 0) {
            System.out.println(1);
        } else {
            System.out.println(fac(n) / (fac(n - k) * fac(k)));
        }
    }

    public static int fac(int n) {
        return n <= 1 ? n : n * fac(n - 1);
    }
}