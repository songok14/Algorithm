import java.io.*;
import java.util.*;

public class Main {
    static List<List<Integer>> myList = new ArrayList<>();
    static boolean[] visited;
    static int[] distance;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1];
        distance = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            myList.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            myList.get(a).add(b);
            myList.get(b).add(a);
        }

        bfs(1);

        int maxNumber = 0;
        int maxDistance = 0;
        int count = 0;

        for (int i = 1; i <= N; i++) {
            if (distance[i] > maxDistance) {
                maxDistance = distance[i];
            }
        }

        for (int i = 1; i <= N; i++) {
            if (distance[i] == maxDistance) {
                if (maxNumber == 0) {
                    maxNumber = i;
                }
                count++;
            }
        }

        System.out.println(maxNumber + " " + maxDistance + " " + count);

        br.close();
    }

    public static void bfs(int start) {
        Queue<Integer> myQ = new LinkedList<>();
        myQ.add(start);
        visited[start] = true;

        while (!myQ.isEmpty()) {
            int temp = myQ.poll();
            for (int i : myList.get(temp)) {
                if (!visited[i]) {
                    myQ.add(i);
                    visited[i] = true;
                    distance[i] = distance[temp] + 1;
                }
            }
        }
    }
}