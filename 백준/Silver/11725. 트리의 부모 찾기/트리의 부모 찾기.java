import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static List<List<Integer>> myList;
    static boolean[] visited;
    static int[] parents;

    public static void main(String[] args) throws IOException {
        // 백준: 트리의 부모찾기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        myList = new ArrayList<>();
        visited = new boolean[n + 1];
        parents = new int[n + 1];

        for (int i = 0; i < n + 1; i++) {
            myList.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            String[] inputs = br.readLine().split(" ");
            myList.get(Integer.parseInt(inputs[0])).add(Integer.parseInt(inputs[1]));
            myList.get(Integer.parseInt(inputs[1])).add(Integer.parseInt(inputs[0]));
        }

        dfs(1);

        for (int i =2; i<parents.length; i++) {
            sb.append(parents[i]).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();

    }

    static void dfs(int n) {
        visited[n] = true;

        for (int x : myList.get(n)) {
            if (!visited[x]) {
                parents[x] = n;
                dfs(x);
            }
        }
    }
}