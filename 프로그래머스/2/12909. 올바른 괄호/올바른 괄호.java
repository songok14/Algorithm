import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;

        Stack<String> stack = new Stack<>();

        for(int i=0; i<s.length(); i++){
            if(stack.isEmpty() || s.charAt(i) == '('){
                stack.add(String.valueOf(s.charAt(i)));
            } else{
                if(stack.peek().equals("(")){
                    stack.pop();
                } else {
                    answer = false;
                    break;
                }
            }
        }

        if(stack.size()>0){
            answer = false;
        }

        return answer;
    }
}