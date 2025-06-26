import java.io.*;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuffer sb = new StringBuffer();

        int testCase = Integer.parseInt(br.readLine());
        Queue<Integer> myQ = new PriorityQueue<>((o1, o2) -> o2 - o1);
        while (testCase>0){
            int n = Integer.parseInt(br.readLine());
            if (n == 0){
                if (myQ.isEmpty()){
                    sb.append(0).append("\n");
                } else {
                    sb.append(myQ.poll()).append("\n");
                }
            } else {
                myQ.add(n);
            }

            testCase--;
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}