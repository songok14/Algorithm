import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int testCase = scan.nextInt();

        for (int i = 0; i < testCase; i++) {
            int re = scan.nextInt();
            String[] strArr = scan.next().split("");
            String result = "";

            for (int j = 0; j < strArr.length; j++) {
                for (int k = 0; k < re; k++) {
                    result += strArr[j];
                }
            }

            System.out.println(result);
        }
    }
}