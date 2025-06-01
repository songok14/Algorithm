import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int count = 0;

        for (int i = N; i > 0; i--) {
            int number = i;
            while(true) {
                if (number % 5 == 0) {
                    count++;
                    number /= 5;
                } else break;
            }
        }

        System.out.println(count);
        br.close();
    }
}