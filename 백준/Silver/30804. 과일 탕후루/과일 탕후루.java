import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // n은 사용되지만, inputs 배열의 길이를 직접 사용해도 무방합니다.
        String[] inputs = br.readLine().split(" ");

        Map<Integer, Integer> myMap = new HashMap<>();
        int length = 0;
        int start = 0;

        for (int end = 0; end < inputs.length; end++) {
            int currentNum = Integer.parseInt(inputs[end]);
            myMap.put(currentNum, myMap.getOrDefault(currentNum, 0) + 1);

            while (myMap.size() > 2) {
                int startNum = Integer.parseInt(inputs[start]);
                myMap.put(startNum, myMap.get(startNum) - 1); 

                if (myMap.get(startNum) == 0) { 
                    myMap.remove(startNum);
                }
                start++;
            }

            length = Math.max(length, end - start + 1);
        }

        System.out.println(length);

        br.close();
    }
}