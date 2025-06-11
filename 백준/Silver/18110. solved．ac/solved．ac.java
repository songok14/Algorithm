import com.sun.source.tree.Tree;

import java.io.*;
import java.math.BigDecimal;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        LinkedList<Integer> list = new LinkedList<>();
        double remove = Math.round(n * 0.15);

        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(list);
        for (int i = 0; i < remove; i++) {
            list.pollFirst();
            list.pollLast();
        }

        int sum = 0;
        int size = list.size();

        for (int i : list) {
            sum += i;
        }
        if (size == 0) {
            System.out.println(0);
        } else {
            System.out.println(Math.round((double)sum / size));
        }


        br.close();
    }
}