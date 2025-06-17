import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuffer sb = new StringBuffer();

        Queue<Integer> myQ = new LinkedList<>();
        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int k = Integer.parseInt(inputs[1]);
        // 큐에 데이터 입력
        for (int i = 1; i <= n; i++) {
            myQ.add(i);
        }

        // K 번째 제거
        sb.append("<");
        while (myQ.size() > 1) {
            for (int i = 0; i < k - 1; i++) {
                myQ.add(myQ.poll());
            }
            sb.append(myQ.poll()).append(", ");
        }
        sb.append(myQ.poll()).append(">");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
