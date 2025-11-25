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

        List<Integer> myList = new ArrayList<>();
        int[] numbers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int i : numbers) {
            myList.add(i);
        }
        myList.sort(Comparator.naturalOrder());

        Set<List<Integer>> result = new LinkedHashSet<>();
        back(myList, new ArrayList<>(), result, M, 0);

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

    public static void back(List<Integer> myList, List<Integer> temp, Set<List<Integer>> result, int M, int start) {
        if (temp.size() == M) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i = start; i < myList.size(); i++) {
            temp.add(myList.get(i));
            back(myList, temp, result, M, i);
            temp.remove(temp.size() - 1);
        }
    }
}
