import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] testCase = br.readLine().split(" ");
        int n = Integer.parseInt(testCase[0]);
        int m = Integer.parseInt(testCase[1]);
        int answer = Integer.MAX_VALUE;
        int person = 0;

        List<List<Integer>> myList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            myList.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            String[] inputs = br.readLine().split(" ");
            myList.get(Integer.parseInt(inputs[0]) - 1).add(Integer.parseInt(inputs[1]) - 1);
            myList.get(Integer.parseInt(inputs[1]) - 1).add(Integer.parseInt(inputs[0]) - 1);
        }

        for (int i = 0; i < n; i++) {
            Queue<Integer> myQ = new LinkedList<>();
            int[] visited = new int[n];
            Arrays.fill(visited, -1);

            myQ.add(i);
            visited[i] = 0;

            // 해당 번호와 연결된 모든 대상 탐색
            while (!myQ.isEmpty()) {
                int temp = myQ.poll();

                for (int j : myList.get(temp)) {
                    if (visited[j] == -1) {
                        myQ.add(j);
                        visited[j] = visited[temp] + 1;
                    }
                }
            }

            int kevin = 0;
            for (int count : visited) {
                kevin += count;
            }

            if (kevin < answer) {
                answer = kevin;
                person = i + 1;
            }
        }
        System.out.println(person);

        br.close();
    }
}