import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = 0;
        int N = Integer.parseInt(br.readLine());
        int[][] course = new int[N][2];

        for (int i = 0; i < N; i++) {
            int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            course[i][0] = input[0];
            course[i][1] = input[1];
        }

        Arrays.sort(course, (o1, o2) ->{
            return Integer.compare(o1[0], o2[0]);
        });

        PriorityQueue<Integer> myQ = new PriorityQueue<>();
        myQ.add(course[0][1]);

        for (int i=1; i<N; i++){
            if (course[i][0] >= myQ.peek()){
                myQ.poll();
            }
            myQ.add(course[i][1]);
        }

        System.out.println(myQ.size());

        br.close();
    }
}