import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuffer sb = new StringBuffer();

        int n = Integer.parseInt(br.readLine());
        String[] strArr = br.readLine().split(" ");
        int[] numbers = new int[n];
        for(int i=0; i<n; i++){
            numbers[i] = Integer.parseInt(strArr[i]);
        }
        int total = 0;
        Arrays.sort(numbers);

        List<Integer> time = new ArrayList<>();
        time.add(numbers[0]);
        for (int i = 1; i < n; i++) {
            int temp = time.get(i - 1);
            time.add(numbers[i] + temp);
        }

        for(int i=0; i<time.size(); i++){
            total += time.get(i);
        }
        sb.append(total);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}