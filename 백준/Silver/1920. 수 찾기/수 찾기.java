import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] nNums = br.readLine().split(" ");
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(nNums[i]);
        }
        Arrays.sort(arr);

        int m = Integer.parseInt(br.readLine());
        String[] mNums = br.readLine().split(" ");
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < mNums.length; i++) {
            int index = Arrays.binarySearch(arr, Integer.parseInt(mNums[i]));
            if (index >= 0) {
                sb.append(1).append("\n");
            } else {
                sb.append(0).append("\n");
            }
        }
        
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}