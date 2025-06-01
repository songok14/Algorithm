import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(br.readLine());
        String N = "666";
        String movie ="";
        while (count > 0) {
            for (int i = 0; i < N.length() - 2; i++) {
                if (N.charAt(i)-'0' == 6 && N.charAt(i + 1)-'0' == 6 && N.charAt(i + 2)-'0' == 6) {
                    movie = N;
                    count--;
                    break;
                }
            }
            N = String.valueOf(Integer.parseInt(N)+1);
        }

        System.out.println(movie);
        br.close();
    }
}