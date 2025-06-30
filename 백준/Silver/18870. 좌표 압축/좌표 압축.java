import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder resultSb = new StringBuilder(); 

         int testCase = Integer.parseInt(br.readLine());

        String inputLine = br.readLine();
        String[] stringNumbers = inputLine.split(" ");

        Set<Integer> uniqueNumbers = new TreeSet<>();
        for (String s : stringNumbers) {
            uniqueNumbers.add(Integer.parseInt(s));
        }

        Map<Integer, Integer> rankMap = new HashMap<>();
        int rank = 0;
        for (int num : uniqueNumbers) {
            rankMap.put(num, rank++);
        }

        for (int i = 0; i < stringNumbers.length; i++) {
            int originalNumber = Integer.parseInt(stringNumbers[i]);
            resultSb.append(rankMap.get(originalNumber));
            if (i < stringNumbers.length - 1) {
                resultSb.append(" ");
            }
        }

        bw.write(resultSb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}