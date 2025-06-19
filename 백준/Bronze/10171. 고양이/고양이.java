import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuffer sb = new StringBuffer();

        String str = "\\    /\\\n" +
                " )  ( ')\n" +
                "(  /  )\n" +
                " \\(__)|";
        sb.append(str);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}