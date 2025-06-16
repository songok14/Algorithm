import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] arr = br.readLine().split(" ");
        int m = Integer.parseInt(arr[0]);
        int n = Integer.parseInt(arr[1]);

        StringBuffer sb = new StringBuffer();
        loop1:
        for (int i = m; i <= n; i++) {
            if(i==1) continue;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    continue loop1;
                }
            }
            sb.append(i).append("\n");
        }
        
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
