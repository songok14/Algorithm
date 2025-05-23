import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int[] testCase = new int[n];
        int count = 0;

        for (int i = 0; i < testCase.length; i++) {
            testCase[i] = scan.nextInt();
        }
        scan.close();

        for (int i = 0; i < testCase.length; i++) {
            for (int j = 2; j <= testCase[i]; j++) {
                if (testCase[i] % j == 0) {
                    if (testCase[i] != j) {
                        break;
                    }
                    count++;
                }
            }
        }

        System.out.println(count);

    }
}