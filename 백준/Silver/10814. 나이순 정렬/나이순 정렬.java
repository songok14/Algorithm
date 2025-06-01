import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String[][] members = new String[N][3];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            members[i][0] = String.valueOf(i);   // 가입 순서
            members[i][1] = st.nextToken();      // 나이
            members[i][2] = st.nextToken();      // 이름
        }

        Arrays.sort(members, (m1, m2) -> {
            if((Integer.parseInt(m1[1]) == Integer.parseInt(m2[1]))){
                return Integer.parseInt(m1[0]) - Integer.parseInt(m2[0]);
            } else{
                return Integer.parseInt(m1[1]) - Integer.parseInt(m2[1]);
            }
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(members[i][1]).append(" ").append(members[i][2]).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}