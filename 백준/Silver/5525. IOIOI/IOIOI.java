import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        String s = br.readLine();

        String str = "I";

        for (int i = 0; i < n; i++) {
            str += "OI";
        }

        int count = 0;
        for (int i = 0; i < s.length() - str.length() + 1; i++) {
            String temp = s.substring(i, i+str.length());
            if (str.equals(temp)){
                count++;
            }
        }

        System.out.println(count);
        br.close();
    }
}