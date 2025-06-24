import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuffer sb = new StringBuffer();

        String[] inputs = br.readLine().split("");
        String temp = "";
        boolean check = true;
        int count = 0;
        int sum = 0;

        for (String s : inputs) {
            if (s.equals("-")) {
                check = false;
            }

            if (s.equals("+") || s.equals("-")) {
                if (check) {
                    sum += Integer.parseInt(temp);
                } else {
                    if (count == 0){
                        sum += Integer.parseInt(temp);
                        count++;
                    } else {
                        sum -= Integer.parseInt(temp);
                    }
                }
                temp = "";
            } else {
                temp += s;
            }
        }

        if (temp.length()>0){
            if (check){
                sum += Integer.parseInt(temp);
            } else {
                if (count == 0){
                    sum += Integer.parseInt(temp);
                } else {
                    sum -= Integer.parseInt(temp);
                }
            }
        }
        sb.append(sum);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}