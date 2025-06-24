import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuffer sb = new StringBuffer();

        Queue<Integer> myQ = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (Math.abs(o1) == Math.abs(o2)) {
                    return o1 - o2;
                } else {
                    return Math.abs(o1) - Math.abs(o2);
                }
            }
        });

        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            int n = Integer.parseInt(br.readLine());
            if (n != 0) {
                myQ.add(n);
            } else {
                if (myQ.isEmpty()) {
                    sb.append(0).append("\n");
                } else {
                    sb.append(myQ.poll()).append("\n");
                }
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}