import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> myMap = new HashMap<>();
        for (String s : participant) {
            myMap.put(s, myMap.getOrDefault(s, 0) + 1);
        }

        for (String s : completion){
            int count = myMap.get(s) - 1;
            if (count == 0){
                myMap.remove(s);
            } else {
                myMap.put(s, count);
            }
        }

        String answer = myMap.keySet().iterator().next();
        return answer;
    }
}