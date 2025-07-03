class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int start = 0;
        int end = 0;
        int total = sequence[0];
        int length = Integer.MAX_VALUE;

        while (start <= end && end < sequence.length) {
            if (k == total) {
                if (length > end - start) {
                    answer[0] = start;
                    answer[1] = end;
                    length = end - start;
                }
                total -= sequence[start];
                start++;
            } else if (k < total) {
                total -= sequence[start];
                start++;
            } else if (k > total && ++end < sequence.length) {
                total += sequence[end];
            }
        }

        return answer;
    }
}