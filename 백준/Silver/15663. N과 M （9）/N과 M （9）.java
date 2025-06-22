import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuffer sb = new StringBuffer();

        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int target = Integer.parseInt(inputs[1]);

        String[] numbers = br.readLine().split(" ");

        List<Integer> myList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            myList.add(Integer.parseInt(numbers[i]));
        }
        myList.sort(Comparator.naturalOrder());

        Set<List<Integer>> result = new LinkedHashSet<>();
        permu(myList, new ArrayList<>(), result, target, new boolean[n]);

        for (List<Integer> list : result) {
            for (int i : list) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static void permu(List<Integer> myList, List<Integer> temp, Set<List<Integer>> result, int target, boolean[] visited) {
        if (temp.size() == target) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < myList.size(); i++) {
            if (!visited[i]) {
                temp.add(myList.get(i));
                visited[i] = true;
                permu(myList, temp, result, target, visited);
                temp.remove(temp.size() - 1);
                visited[i] = false;
            }
        }

    }
}