import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] numbers = new int[9];
        int max = 0;
        int count = 0;

        for (int i = 0; i < 9; i++) {
            numbers[i] = scan.nextInt();
        }

        for (int i = 0; i < 9; i++) {
            if (numbers[i] >= max) {
                max = numbers[i];
                count = i + 1;
            }
        }

        System.out.println(max);
        System.out.println(count);

    }
}