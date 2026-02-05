import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());
        int[][] meetings = new int[testCase][2];

        for (int i = 0; i < testCase; i++) {
            meetings[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        Arrays.sort(meetings, ((o1, o2) -> {
            if (o1[1] == o2[1]) {
                return o1[0] - o2[0];
            } else {
                return o1[1] - o2[1];
            }
        }));

        int count = 0;
        int endTime = 0;
        for (int i = 0; i < testCase; i++) {
            if (meetings[i][0] >= endTime){
                count++;
                endTime = meetings[i][1];
            }
        }

        System.out.println(count);
        br.close();
    }
}