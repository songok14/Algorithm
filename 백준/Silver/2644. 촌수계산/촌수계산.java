import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] xy = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        List<List<Integer>> myList = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            myList.add(new ArrayList<>());
        }

        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            int[] testCase = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            myList.get(testCase[0]).add(testCase[1]);
            myList.get(testCase[1]).add(testCase[0]);
        }

        for (int i = 0; i <= n; i++) {
            myList.get(i).sort(null);
        }

        Queue<Integer> myQ = new LinkedList<>();
        myQ.add(xy[0]);

        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);
        dist[xy[0]] = 0;

        boolean flag = true;

        while (!myQ.isEmpty()) {
            int temp = myQ.poll();
            if (temp == xy[1]) {
                break;
            }

            for (int i : myList.get(temp)) {
                if (dist[i] == -1) {
                    myQ.add(i);
                    dist[i] = dist[temp] + 1;
                }
            }
        }

        System.out.println(dist[xy[1]]);

        br.close();
    }
}