import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int testCase = scan.nextInt();
        scan.nextLine();

        int score = 0;
        int sum = 0;

        while (testCase != 0) {
            String[] str = scan.nextLine().split("");
            for (int i = 0; i < str.length; i++) {
                if (str[i].equals("O")) {
                    score++;
                } else {
                    score = 0;
                }
                sum += score;
            }
            System.out.println(sum);
            testCase--;
            score = 0;
            sum = 0;
        }

        scan.close();

    }
}