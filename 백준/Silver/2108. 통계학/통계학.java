import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCase = Integer.parseInt(br.readLine());
        Map<Integer, Integer> map = new TreeMap<>();
        int sum = 0;
        int mid = 0;

        List<Integer> keys = new ArrayList<>(map.keySet());
        for (int i = 0; i < testCase; i++) {
            int number = Integer.parseInt(br.readLine());
            map.put(number, map.getOrDefault(number, 0) + 1);
            keys.add(number);
            sum += number;
        }
        keys.sort(Comparator.naturalOrder());

        // 산술 평균
        System.out.println(Math.round((double) sum / testCase));

        // 중앙값
        System.out.println(keys.get(testCase / 2));

        // 최빈값
        int maxCount = Integer.MIN_VALUE;

        List<Integer> list = new ArrayList<>();
        for (int k : map.keySet()) {
            if (map.get(k) > maxCount) {
                maxCount = map.get(k);
                list.clear();
                list.add(k);
            } else if(map.get(k) == maxCount){
                list.add(k);
            }
        }
        list.sort(Comparator.naturalOrder());
        if(list.size() >= 2){
            System.out.println(list.get(1));
        } else {
            System.out.println(list.get(0));
        }

        // 범위
        System.out.println(keys.get(keys.size() - 1) - keys.get(0));

        bw.flush();
        bw.close();
        br.close();
    }
}