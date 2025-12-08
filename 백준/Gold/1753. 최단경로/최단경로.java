import java.io.*;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node> {
        int vertex;
        int weight;

        public Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }

    static List<List<Node>> adj = new ArrayList<>();
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String[] testCase = br.readLine().split(" ");
        int V = Integer.parseInt(testCase[0]);
        int E = Integer.parseInt(testCase[1]);
        int start = Integer.parseInt(br.readLine());

        dist = new int[V + 1];

        for (int i = 0; i < V + 1; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            String[] input = br.readLine().split(" ");
            int u = Integer.parseInt(input[0]);
            int v = Integer.parseInt(input[1]);
            int w = Integer.parseInt(input[2]);

            adj.get(u).add(new Node(v, w));
        }

        dijkstra(start, V);

        for (int i = 1; i <= V; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                sb.append("INF").append("\n");
            } else {
                sb.append(dist[i]).append("\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static void dijkstra(int start, int V) {
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Node> myQ = new PriorityQueue<>();
        dist[start] = 0;
        myQ.add(new Node(start, 0));

        while (!myQ.isEmpty()) {
            Node current = myQ.poll();
            int curVertex = current.vertex;
            int curWeight = current.weight;

            if (curWeight > dist[curVertex]) {
                continue;
            }

            for (Node next : adj.get(curVertex)) {
                int newWeight = curWeight + next.weight;

                if (newWeight < dist[next.vertex]) {
                    dist[next.vertex] = newWeight;
                    myQ.add(new Node(next.vertex, newWeight));
                }
            }

        }
    }
}