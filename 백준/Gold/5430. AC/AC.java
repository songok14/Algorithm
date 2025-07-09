import javax.imageio.metadata.IIOMetadataFormatImpl;
import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine());

        loop:
        for (int i = 0; i < testCase; i++) {
            Deque<Integer> myQ = new LinkedList<>();
            boolean direction = true;

            String[] commands = br.readLine().split("");
            int n = Integer.parseInt(br.readLine());
            String number = br.readLine();
            number = number.substring(1, number.length() - 1);
            String[] numbers = number.split(",");

            for (int j = 0; j < n; j++) {
                myQ.add(Integer.parseInt(numbers[j]));
            }

            for (int j = 0; j < commands.length; j++) {
                if (myQ.isEmpty() && commands[j].equals("D")) {
                    sb.append("error").append("\n");
                    continue loop;
                }
                if (commands[j].equals("R")) {
                    direction = !direction;
                } else {
                    if (direction) {
                        myQ.poll();
                    } else {
                        myQ.pollLast();
                    }
                }
            }

            if (myQ.isEmpty()){
                sb.append("[]").append("\n");
                continue loop;
            }

            sb.append("[");
            while (!myQ.isEmpty()) {
                if (direction) {
                    sb.append(myQ.poll());
                } else {
                    sb.append(myQ.pollLast());
                }
                if (!myQ.isEmpty()){
                    sb.append(",");
                }
            }
            sb.append("]").append("\n");
        }


        br.close();
        bw.write(sb.toString().trim());
        bw.flush();
        bw.close();

    }
}