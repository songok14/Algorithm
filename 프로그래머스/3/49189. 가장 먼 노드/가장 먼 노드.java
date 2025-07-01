import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        List<List<Integer>> myList = new ArrayList<>();
        Queue<Integer> myQ = new LinkedList<>();
        boolean[] visitied = new boolean[n + 1];
        int[] ditance = new int[n + 1];
        int max = 0;

        for (int i = 0; i < n + 1; i++) {
            myList.add(new ArrayList<>());
        }

        for (int i = 0; i < edge.length; i++) {
            int x = edge[i][0];
            int y = edge[i][1];
            myList.get(x).add(y);
            myList.get(y).add(x);
        }

        myQ.add(1);
        visitied[1] = true;

        while (!myQ.isEmpty()) {
            int temp = myQ.poll();

            for (int a : myList.get(temp)) {
                if (!visitied[a]) {
                    myQ.add(a);
                    visitied[a] = true;
                    ditance[a] = ditance[temp] + 1;
                    max = Math.max(max, ditance[a]);
                }
            }
        }
        for (int d : ditance) {
            if (max == d){
                answer++;
            }
        }

        return answer;
    }
}