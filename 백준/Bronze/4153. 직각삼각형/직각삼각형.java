import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        while (true) {
            int x = scan.nextInt();
            int y = scan.nextInt();
            int z = scan.nextInt();
            if (x == 0 && y == 0 && z == 0) {
                break;
            }
            int[] result = new int[3];
            result[0] = x * x;
            result[1] = y * y;
            result[2] = z * z;
            Arrays.sort(result);

            if (result[2] == (result[0] + result[1])) {
                System.out.println("right");
            } else {
                System.out.println("wrong");
            }
        }

        scan.close();
    }
}