import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < edge.length; i++) {
            int x = edge[i][0];
            int y = edge[i][1];

            adj.get(x).add(y);
            adj.get(y).add(x);
        }

        Queue<Integer> myQ = new ArrayDeque<>();
        int[] visited = new int[n + 1];
        myQ.offer(1);
        Arrays.fill(visited, -1);
        visited[1] = 0;

        while (!myQ.isEmpty()) {
            int current = myQ.poll();

            for (int next : adj.get(current)) {
                if (visited[next] == -1) {
                    myQ.offer(next);
                    visited[next] = visited[current] + 1;
                }
            }
        }

        int answer = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < n + 1; i++) {
            if (visited[i] == max) {
                answer++;
            } else if (visited[i] > max) {
                max = visited[i];
                answer = 1;
            }
        }

        return answer;
    }
}