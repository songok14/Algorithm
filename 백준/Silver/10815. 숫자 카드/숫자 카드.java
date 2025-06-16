import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Map<Integer, Integer> map = new HashMap<>();
        String[] sang = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            map.put(Integer.parseInt(sang[i]), 1);
        }

        int m = Integer.parseInt(br.readLine());
        String[] numbers = br.readLine().split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            if (map.containsKey(Integer.parseInt(numbers[i]))) {
                sb.append(1 + " ");
            } else {
                sb.append(0 + " ");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
