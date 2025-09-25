import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Map<Long, Integer> myMap = new TreeMap<>();

        for (int i = 0; i < N; i++) {
            long l = Long.parseLong(br.readLine());
            myMap.put(l, myMap.getOrDefault(l, 0) + 1);
        }

        List<Long> longList = new ArrayList<>(myMap.keySet());
        longList.sort(((o1, o2) -> {
            if (myMap.get(o1) == myMap.get(o2)) {
                return 0;
            } else {
                return myMap.get(o2) - myMap.get(o1);
            }
        }));

        System.out.println(longList.get(0));
        br.close();
    }
}