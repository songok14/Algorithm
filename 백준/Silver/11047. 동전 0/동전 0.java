import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int k = Integer.parseInt(split[1]);
        int count = 0;

        List<Integer> coin = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            coin.add(Integer.parseInt(br.readLine()));
        }

        for (int i = coin.size() - 1; i >= 0; i--) {
            int temp = k / coin.get(i);
            count += temp;
            k = k - (temp* coin.get(i));
        }
        System.out.println(count);
        br.close();
    }
}