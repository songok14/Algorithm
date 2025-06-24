import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuffer sb = new StringBuffer();

        int testCase = Integer.parseInt(br.readLine());
        String[] strArr = new String[testCase];

        for (int i = 0; i < strArr.length; i++) {
            strArr[i] = br.readLine();
        }

        Arrays.sort(strArr, (o1, o2) -> {
            if (o1.length() == o2.length()) {
                return o1.compareTo(o2);
            } else {
                return o1.length() - o2.length();
            }
        });

        sb.append(strArr[0]).append("\n");
        for (int i = 1; i < strArr.length; i++) {
            if (!strArr[i].equals(strArr[i - 1])) {
                sb.append(strArr[i]).append("\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}