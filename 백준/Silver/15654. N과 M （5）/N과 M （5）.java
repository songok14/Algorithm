import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int[] testCase = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = testCase[0];
        int M = testCase[1];

        String[] numbers = br.readLine().split(" ");

        List<Integer> myList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            myList.add(Integer.parseInt(numbers[i]));
        }
        myList.sort(Comparator.naturalOrder());

        List<List<Integer>> result = new ArrayList<>();
        permu(myList, new ArrayList<>(), result, M, new boolean[N]);

        for (List<Integer> list : result){
            for (int i : list){
                sb.append(i).append(" ");
            }
            sb.append("\n");
        }

        br.close();
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    public static void permu(List<Integer> myList, List<Integer> temp, List<List<Integer>> result, int M, boolean[] visited) {
        if (temp.size() == M) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < myList.size(); i++) {
            if (!visited[i]) {
                temp.add(myList.get(i));
                visited[i] = true;
                permu(myList, temp, result, M, visited);
                temp.remove(temp.size() - 1);
                visited[i] = false;
            }
        }
    }
}
