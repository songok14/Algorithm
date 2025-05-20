import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int count = scan.nextInt();
        int[] numbers = new int[count];

        for (int i = 0; i < count; i++) {
            numbers[i] = scan.nextInt();
        }

        Arrays.sort(numbers);
        System.out.println(numbers[0] + " " + numbers[count - 1]);
    }
}