import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] number = br.readLine().split(" ");
        int n = Integer.parseInt(number[0]);
        int m = Integer.parseInt(number[1]);

        Set<String> nSet = new TreeSet<>();
        Set<String> mSet = new TreeSet<>();

        for(int i=0; i<n; i++){
            nSet.add(br.readLine());
        }

        for(int i=0; i<m; i++){
            mSet.add(br.readLine());
        }

        nSet.retainAll(mSet);
        StringBuffer sb = new StringBuffer();
        sb.append(nSet.size()).append("\n");
        for(String s : nSet){
            sb.append(s).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}