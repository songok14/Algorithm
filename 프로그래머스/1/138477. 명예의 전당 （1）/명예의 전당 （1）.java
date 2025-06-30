import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        Queue<Integer> myQ = new PriorityQueue<>((o1, o2) -> o2 - o1);

        for (int i = 0; i < score.length; i++) {
            for (int j = 0; j <= i; j++) {
                myQ.add(score[j]);
            }

            for (int j = 0; j < k - 1; j++) {
                if (myQ.size() > 1) {
                    myQ.poll();
                }
            }
            answer[i] = myQ.poll();
            myQ.clear();
        }
        
        return answer;
    }
}