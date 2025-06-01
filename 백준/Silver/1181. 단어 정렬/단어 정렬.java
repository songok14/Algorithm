import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine());
        String[][] words = new String[testCase][2];

        for (int i = 0; i < testCase; i++) {
            words[i][0] = br.readLine();
            words[i][1] = String.valueOf(words[i][0].length());
        }

        Arrays.sort(words, (w1, w2) -> {
            if (Integer.parseInt(w1[1]) == Integer.parseInt(w2[1])) {
                return w1[0].compareTo(w2[0]);
            } else {
                return Integer.parseInt(w1[1]) - Integer.parseInt(w2[1]);
            }
        });

        for(int i=0; i<testCase; i++){
            if(i>0 && words[i][0].equals(words[i-1][0])){
                continue;
            }
            sb.append(words[i][0]).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
}