import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuffer sb = new StringBuffer();

        while (true) {
            String[] inputs = br.readLine().split(" ");
            int testCase = Integer.parseInt(inputs[0]);
            if (testCase == 0 && inputs.length==1) {
                break;
            }

            List<Integer> myList = new ArrayList<>();
            List<List<Integer>> result = new ArrayList<>();
            for (int i = 1; i <= testCase; i++) {
                myList.add(Integer.parseInt(inputs[i]));
            }
            myList.sort(Comparator.naturalOrder());

            combi(myList, new ArrayList<>(), result, 6, 0);

            for (List<Integer> list : result) {
                for (int n : list) {
                    sb.append(n).append(" ");
                }
                sb.append("\n");
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    public static void combi(List<Integer> myList, List<Integer> temp, List<List<Integer>> result, int target, int start) {
        if (temp.size() == target) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i = start; i < myList.size(); i++) {
            temp.add(myList.get(i));
            combi(myList, temp, result, 6, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}