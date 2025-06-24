import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuffer sb = new StringBuffer();

        int testCase = Integer.parseInt(br.readLine());

        Queue<int[]> myQ = new PriorityQueue<>((o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            } else {
                return o1[0] - o2[0];
            }
        });
        int sum = 0;

        for (int i = 0; i < testCase; i++) {
            String[] inputs = br.readLine().split(" ");
            myQ.add(new int[]{Integer.parseInt(inputs[0]), Integer.parseInt(inputs[1])});
        }

        int[] temp = myQ.poll();
        int min = temp[0];
        int max = temp[1];

        if (myQ.isEmpty()) {
            sum += max - min;
        }
        
        while (!myQ.isEmpty()) {
            temp = myQ.poll();
            if (min <= temp[0] && max >= temp[0]) {
                max = Math.max(max, temp[1]);
            } else if (min <= temp[1] && max >= temp[1]) {
                min = Math.min(min, temp[0]);
            } else {
                sum += max - min;
                min = temp[0];
                max = temp[1];
            }

            if (myQ.isEmpty()) {
                sum += max - min;
            }
        }

        sb.append(sum);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}