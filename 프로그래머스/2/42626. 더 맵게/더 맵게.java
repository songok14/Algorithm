import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;

        Queue<Integer> myQ = new PriorityQueue<>();
        for (int i = 0; i < scoville.length; i++) {
            myQ.add(scoville[i]);
        }

        while (!(myQ.peek() >= K)) {
            if (myQ.size() < 2) {
                answer = -1;
                break;
            }
            answer++;
            myQ.add(myQ.poll() + (myQ.poll() * 2));
        }
        
        return answer;
    }
}