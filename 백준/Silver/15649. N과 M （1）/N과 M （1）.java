import java.io.*;
import java.util.ArrayList;
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
        List<List<Integer>> resultList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            myList.add(i + 1);
        }

        permu(myList, new ArrayList<>(), resultList, target, new boolean[myList.size()]);

        for (List<Integer> list : resultList){
            for (int i : list){
                sb.append(i).append(" ");
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }


    public static void permu(List<Integer> myList, List<Integer> temp, List<List<Integer>> resultList, int target, boolean[] visited) {
        if (temp.size() == target){
            resultList.add(new ArrayList<>(temp));
            return;
        }

        for (int i=0; i<myList.size(); i++){
            if (!visited[i]){
                visited[i] = true;
                temp.add(myList.get(i));
                permu(myList, temp, resultList, target, visited);
                temp.remove(temp.size()-1);
                visited[i] = false;
            }
        }

    }
}