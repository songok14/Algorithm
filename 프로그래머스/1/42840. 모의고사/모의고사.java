import java.util.*;

class Solution {
    public List<Integer> solution(int[] answers) {
        int[] m1 = {1, 2, 3, 4, 5};
        int[] m2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] m3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int c1 = 0;
        int c2 = 0;
        int c3 = 0;

        for (int i = 0; i < answers.length; i++) {
            if (m1[i % m1.length] == answers[i]) c1++;
            if (m2[i % m2.length] == answers[i]) c2++;
            if (m3[i % m3.length] == answers[i]) c3++;
        }

        int max = Math.max(c1, Math.max(c2, c3));
        List<Integer> answer = new ArrayList<>();
        if (max == c1) answer.add(1);
        if (max == c2) answer.add(2);
        if (max == c3) answer.add(3);
        return answer;
    }
}