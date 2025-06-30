import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        Queue<Integer> myQ = new PriorityQueue<>((o1, o2) -> o2 - o1);

        for (int i=0; i<works.length; i++){
            myQ.add(works[i]);
        }

        while (n>0){
            myQ.add(myQ.poll()-1);
            n--;
        }

        while (!myQ.isEmpty()){
            int temp = myQ.poll();
            if (temp>0) {
                answer += temp * temp;
            }
        }
        
        return answer;
    }
}