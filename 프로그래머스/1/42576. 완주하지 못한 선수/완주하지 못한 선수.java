import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < completion.length; i++) {
            map.put(completion[i], map.getOrDefault(completion[i], 0) + 1);
        }

        for (String s : participant) {
            if (map.containsKey(s)) {
                if (map.get(s) == 1) {
                    map.remove(s);
                } else {
                    map.put(s, map.get(s) - 1);
                }
            } else {
                answer = s;
            }
        }
        
        return answer;
    }
}