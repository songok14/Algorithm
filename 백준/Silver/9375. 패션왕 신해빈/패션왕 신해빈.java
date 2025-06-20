import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuffer sb = new StringBuffer();

        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            int n = Integer.parseInt(br.readLine());
            Map<String, Integer> map = new HashMap<>();
            for(int j=0; j<n; j++) {
                String[] input = br.readLine().split(" ");
                map.put(input[1], map.getOrDefault(input[1], 0) + 1);
            }

            int total = 1;
            for (String k : map.keySet()){
                total *= map.get(k)+1;
            }
            total--;
            sb.append(total).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}