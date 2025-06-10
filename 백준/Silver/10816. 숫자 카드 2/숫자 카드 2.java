import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arrN = new int[n];
        for(int i=0; i<n; i++){
            arrN[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        int[] arrM = new int[m];
        HashMap<Integer, Integer> map = new HashMap<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++){
            arrM[i] = Integer.parseInt(st.nextToken());
            map.put(arrM[i], 0);
        }

        for(int i = 0; i<n; i++){
            if(map.containsKey(arrN[i])){
                Integer count = map.get(arrN[i]);
                count++;
                map.put(arrN[i], count);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<m; i++){
            sb.append(map.get(arrM[i])).append(" ");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}