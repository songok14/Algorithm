import java.util.*;

public class Solution {
    public int[] solution(int[] arr) {
        Deque<Integer> myS = new ArrayDeque<>();
        myS.push(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            if (myS.peek() != arr[i]) {
                myS.push(arr[i]);
            }
        }

        int[] answer = new int[myS.size()];
        for (int i = myS.size()-1; i>=0; i--){
            answer[i] = myS.pop();
        }

        return answer;
    }
}