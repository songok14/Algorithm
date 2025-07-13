import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int testCsae = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCsae; i++) {
            int t = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> myMap = new TreeMap<>();

            for (int j = 0; j < t; j++) {
                String[] inputs = br.readLine().split(" ");
                String oper = inputs[0];
                int number = Integer.parseInt(inputs[1]);
                if (oper.equals("I")) {
                    myMap.put(number, myMap.getOrDefault(number, 0) + 1);
                } else {
                    int key = 0;
                    if (myMap.size() == 0) continue;

                    if (number == 1) {
                        key = myMap.lastKey();
                    } else {
                        key = myMap.firstKey();
                    }

                    myMap.put(key, myMap.get(key) - 1);
                    if (myMap.get(key) == 0) {
                        myMap.remove(key);
                    }
                }
            }

            if (myMap.size()==0){
                sb.append("EMPTY").append("\n");
            } else {
                sb.append(myMap.lastKey()+" "+myMap.firstKey()).append("\n");
            }
        }

        br.close();
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}