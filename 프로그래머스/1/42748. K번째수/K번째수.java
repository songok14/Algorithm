import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        Queue<Integer> myQ = new PriorityQueue<>();

        for (int i = 0; i < commands.length; i++) {
            for (int j = commands[i][0] - 1; j < commands[i][1]; j++) {
                myQ.offer(array[j]);
            }

            for (int k = 0; k < commands[i][2] - 1; k++) {
                myQ.poll();
            }

            answer[i] = myQ.peek();
            myQ.clear();
        }
        return answer;
    }
}