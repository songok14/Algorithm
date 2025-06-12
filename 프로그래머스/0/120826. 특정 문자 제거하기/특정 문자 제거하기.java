class Solution {
    public String solution(String my_string, String letter) {
        String answer = "";
        for(int i=0; i<my_string.length(); i++){
            char c = my_string.charAt(i);
            char test = letter.charAt(0);
            if(c == test){
                continue;
            }
            answer += c;
        }
        return answer;
    }
}