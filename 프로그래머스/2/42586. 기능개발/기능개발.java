import java.util.*;

class Solution {
    public List<Integer> solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        int[] days = new int[progresses.length];

        for (int i = 0; i < speeds.length; i++) {
            int left = 100 - progresses[i];
            days[i] = (left + speeds[i] - 1) / speeds[i];
        }

        int count = 1;
        int max = days[0];

        for (int i = 1; i < days.length; i++) {
            if (max >= days[i]) {
                count++;
            } else {
                max = days[i];
                answer.add(count);
                count = 1;
            }
        }
        answer.add(count);

        return answer;
    }
}