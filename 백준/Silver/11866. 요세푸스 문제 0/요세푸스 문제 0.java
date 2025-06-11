import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Queue<Integer> q = new LinkedList<>();

        String[] input = br.readLine().split(" ");
        int testCase = Integer.parseInt(input[0]);
        int reNum = Integer.parseInt(input[1]);

        for (int i = 1; i <= testCase; i++) {
            q.add(i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");
        while(q.size()>1){
            for(int i=0; i<reNum-1; i++){
                q.add(q.poll());
            }
            sb.append(q.poll()).append(", ");
        }
        sb.append(q.poll()).append(">");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}