import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int h = scan.nextInt();
        int min = scan.nextInt();

        if (min < 45) {
            min += 15;
            if (h > 0) {
                h--;
            } else {
                h = 23;
            }
        } else {
            min -= 45;
        }

        System.out.println(h + " " + min);
    }
}
// github 연동