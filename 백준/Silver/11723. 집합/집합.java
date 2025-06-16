import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Set<Integer> set = new HashSet<>();
        int m = Integer.parseInt(br.readLine());
        int[] all = new int[20];

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < m; i++) {
            String[] strArr = br.readLine().split(" ");
            int number = 0;
            if (strArr.length > 1) {
                number = Integer.parseInt(strArr[1]);
            }
            switch (strArr[0]) {
                case "add": {
                    set.add(number);
                    break;
                }
                case "remove": {
                    if (set.contains(number)) {
                        set.remove(number);
                    }
                    break;
                }
                case "check": {
                    if (set.contains(number)) {
                        sb.append("1\n");
                    } else {
                        sb.append("0\n");
                    }
                    break;
                }
                case "toggle": {
                    if (set.contains(number)) {
                        set.remove(number);
                    } else {
                        set.add(number);
                    }
                    break;
                }
                case "all": {
                    set.clear();
                    for (int j = 1; j <= 20; j++) {
                        set.add(j);
                    }
                    break;
                }
                case "empty": {
                    set.clear();
                    break;
                }
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}