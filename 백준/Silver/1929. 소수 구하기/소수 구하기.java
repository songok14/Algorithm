import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");
        int m = Integer.parseInt(arr[0]);
        int n = Integer.parseInt(arr[1]);

        loop1:
        for (int i = m; i <= n; i++) {
            if(i==1) continue;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    continue loop1;
                }
            }
            System.out.println(i);
        }
    }
}