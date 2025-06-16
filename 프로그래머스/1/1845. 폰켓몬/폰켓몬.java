import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        int get = nums.length/2;

        Set<Integer> pon = new HashSet<>();
        for(int n : nums){
            pon.add(n);
        }

        if(pon.size() >= get){
            answer = get;
        } else {
            answer = pon.size();
        }
        return answer;
    }
}