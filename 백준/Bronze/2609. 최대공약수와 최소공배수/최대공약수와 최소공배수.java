import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int gcd = GCD(x, y);
        System.out.println(gcd);
        System.out.println(x * y / gcd);

        br.close();
    }

    public static int GCD(int x, int y) {
        return y == 0 ? x : GCD(y, x % y);
    }
}