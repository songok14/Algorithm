import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());

        while (testCase > 0) {
            Queue<int[]> q = new LinkedList<>();
            List<Integer> list = new ArrayList<>();

            String[] strArr = br.readLine().split(" ");
            int n = Integer.parseInt(strArr[0]);
            int m = Integer.parseInt(strArr[1]);

            String[] rank = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                q.add(new int[]{Integer.parseInt(rank[i]), i});
                list.add(Integer.parseInt(rank[i]));
            }

            list.sort(Comparator.reverseOrder());

            int index = 0;
            int count = 0;
            while (!q.isEmpty()) {
                if (q.peek()[0] == list.get(index)) {
                    if(q.peek()[1] == m){
                        System.out.println(++count);
                    }
                    q.poll();
                    index++;
                    count++;
                } else {
                    q.add(q.poll());
                }
            }

            testCase--;
        }
    }
}