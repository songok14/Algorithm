import java.io.*;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String[] testCase = br.readLine().split(" ");
        int n = Integer.parseInt(testCase[0]);
        int m = Integer.parseInt(testCase[1]);

        List<Integer> myList = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            myList.add(i);
        }

        Set<List<Integer>> result = new LinkedHashSet<>();
        combi(myList, new ArrayList<>(), result, m, 0);

        for (List<Integer> list : result) {
            for (int i : list) {
                sb.append(i);
                if (i != list.get(list.size() - 1)){
                    sb.append(" ");
                }
            }
            sb.append("\n");
        }

        br.close();
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    public static void combi(List<Integer> myList, List<Integer> temp, Set<List<Integer>> result, int m, int start) {
        if (temp.size() == m) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i = start; i < myList.size(); i++) {
            temp.add(myList.get(i));
            combi(myList, temp, result, m, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}
