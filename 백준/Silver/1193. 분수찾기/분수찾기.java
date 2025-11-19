import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int X = Integer.parseInt(br.readLine());
        int row = 0;
        int col = 0;

        int count = 1;
        int num = 1;
        while ((num + count) <= X) {
            count += num++;
        }

        if (num % 2 == 0) {
            row = 1;
            col = num;

            while (count != X) {
                row++;
                col--;
                count++;
            }
        } else {
            row = num;
            col = 1;

            while (count != X) {
                row--;
                col++;
                count++;
            }
        }

        System.out.println(row + "/" + col);
        br.close();
    }
}
