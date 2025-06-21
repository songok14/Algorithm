import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuffer sb = new StringBuffer();

        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int target = Integer.parseInt(inputs[1]);

        List<Integer> myList = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            myList.add(i);
        }
        myList.sort(Comparator.naturalOrder());

        List<List<Integer>> result = new ArrayList<>();
        combi(myList, new ArrayList<>(), result, target, 0);

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

    public static void combi(List<Integer> myList, List<Integer> temp, List<List<Integer>> result, int target, int start) {
        if (temp.size() == target) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i = start; i < myList.size(); i++) {
            temp.add(myList.get(i));
            combi(myList, temp, result, target, i+1);
            temp.remove(temp.size() - 1);
        }

    }
}