import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new TreeMap<>();

        for (int i = 0; i < testCase; i++) {
            String[] str = br.readLine().split("\\.");
            map.put(str[1], map.getOrDefault(str[1], 0) + 1);
        }

        for (String s : map.keySet()) {
            System.out.println(s + " " + map.get(s));
        }

    }
}
