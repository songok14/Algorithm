import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int A = scan.nextInt();
        int B = scan.nextInt();
        int C = scan.nextInt();
        int mul = A * B * C;
        int[] count = new int[10];

        while (mul > 0) {
            int n = mul % 10;
            mul /= 10;
            count[n]++;
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(count[i]);
        }
    }
}