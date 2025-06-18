import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuffer sb = new StringBuffer();

        String[] arr = br.readLine().split(" ");
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            int n = Integer.parseInt(arr[i]);
            result += n * n;
        }
        sb.append(result%10);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}