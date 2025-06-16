import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int m = Integer.parseInt(inputs[1]);

        Map<String, Integer> name = new HashMap<>();
        Map<Integer, String> number = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            String str = br.readLine();
            name.put(str, i);
            number.put(i, str);
        }

        StringBuffer sb = new StringBuffer();
        for(int i=0; i<m; i++){
            String str = br.readLine();
            if(name.containsKey(str)){
                sb.append(name.get(str)+"\n");
            } else {
                sb.append(number.get(Integer.parseInt(str))+"\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}