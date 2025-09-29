import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] testCase = br.readLine().split(" ");
        int N = Integer.parseInt(testCase[0]);
        int M = Integer.parseInt(testCase[1]);

        String[] input = br.readLine().split(" ");
        int[] arr = new int[N];
        for (int i = 0; i < M; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }

        List<Integer> myList = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            myList.add(i + 1);
        }

        int count = 0;
        int index = 0;
        int site = 0;

        while (index < M) {
            int temp = 0;
            for (int i = 0; i < myList.size(); i++) {
                if (arr[index] == myList.get(site)) {
                    break;
                } else {
                    site++;
                    temp++;
                    if (site >= myList.size()) {
                        site = 0;
                    }
                }
            }
            if (temp < myList.size() - temp) {
                count += temp;
            } else {
                count += myList.size() - temp;
            }
            myList.remove(site);
            if (site == myList.size()) {
                site = 0;
            }
            index++;
        }
        System.out.println(count);

        br.close();
    }
}