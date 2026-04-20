import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;

        Queue<Integer> myQ = new PriorityQueue<>();
        for (int n : scoville) {
            myQ.offer(n);
        }

        while (myQ.peek() < K) {
            if (myQ.size() < 2) return -1;
            answer++;
            myQ.offer(myQ.poll() + (myQ.poll() * 2));
        }
        
        return answer;
    }
}