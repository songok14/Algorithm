class Solution {
    public int solution(int n) {
        int answer = 0;

        int start = 0;
        int end = 0;

        while (end <= n) {
            int total = 0;
            for (int i = start; i <= end; i++) {
                total += i;
            }

            if (total == n) {
                answer++;
                end++;
            } else if (total < n) {
                end++;
            } else if (total > n) {
                start++;
            }
        }

        return answer;
    }
}