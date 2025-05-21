import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int[] mel = new int[8];
        String out = "";

        for (int i = 0; i < 8; i++) {
            mel[i] = scan.nextInt();
        }

        for (int i = 0; i < 7; i++) {
            if (mel[i] + 1 == mel[i + 1]) {
                out = "ascending";
            } else if (mel[i] - 1 == mel[i + 1]) {
                out = "descending";
            } else{
                out = "mixed";
                break;
            }
        }

        System.out.println(out);
    }
}