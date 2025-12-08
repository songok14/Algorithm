import java.io.*;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node> {
        int x;
        int y;
        int weight;

        public Node(int x, int y, int weight) {
            this.x = x;
            this.y = y;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }

    static int[][] graph;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int count = 1;

        while (true) {
            int N = Integer.parseInt(br.readLine());
            if (N == 0) {
                break;
            }

            graph = new int[N][N];

            for (int i = 0; i < N; i++) {
                graph[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }

            int sum = dijkstra(N, graph);
            sb.append("Problem ").append(count).append(": ").append(sum).append("\n");
            count++;
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int dijkstra(int N, int[][] graph) {
        PriorityQueue<Node> myQ = new PriorityQueue<>();
        int[][] dist = new int[N][N];

        for (int i = 0; i < N; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        dist[0][0] = graph[0][0];
        myQ.add(new Node(0, 0, dist[0][0]));

        while (!myQ.isEmpty()) {
            Node current = myQ.poll();
            int curX = current.x;
            int curY = current.y;
            int curWeight = current.weight;

            if (curWeight > dist[curX][curY]) {
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int nextX = curX + dx[i];
                int nextY = curY + dy[i];

                if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= N) {
                    continue;
                }

                int newWeight = curWeight + graph[nextX][nextY];

                if (newWeight < dist[nextX][nextY]){
                    dist[nextX][nextY] = newWeight;
                    myQ.add(new Node(nextX, nextY, newWeight));
                }
            }
        }

        return dist[N-1][N-1];
    }
}