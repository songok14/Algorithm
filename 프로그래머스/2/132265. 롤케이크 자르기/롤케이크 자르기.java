import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;

        Set<Integer> mySet = new HashSet<>();
        Map<Integer, Integer> myMap = new HashMap<>();

        for (int i = 0; i < topping.length; i++) {
            myMap.put(topping[i], myMap.getOrDefault(topping[i], 0) + 1);
        }

        for (int i = 0; i < topping.length; i++) {
            mySet.add(topping[i]);
            myMap.put(topping[i], myMap.get(topping[i]) - 1);
            if (myMap.get(topping[i]) == 0) {
                myMap.remove(topping[i]);
            }

            if (mySet.size() == myMap.size()) {
                answer++;
            }
        }

        return answer;
    }
}
