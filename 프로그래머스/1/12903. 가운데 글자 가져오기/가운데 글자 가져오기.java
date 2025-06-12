class Solution {
    public String solution(String s) {
        String answer = "";
        int count = (s.length()%2==0)? 2 : 1;
    
        if(count==1){
            answer += s.substring(s.length()/2, s.length()/2+count);
        } else {
            answer += s.substring(s.length()/2-1, s.length()/2+1);
        }
        return answer;
    }
}