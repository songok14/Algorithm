import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int sum = 0;

        for (int i = 1; i < n; i++) {
            String[] s = String.valueOf(i).split("");
            sum += i;
//            if(i >= 10) {
                for (int j = 0; j < s.length; j++) {
                    sum += Integer.parseInt(s[j]);
                }
//            }
            if (sum == n) {
                System.out.println(i);
                break;
            } else {
                sum = 0;
            }
        }

        if(sum == 0){
            System.out.println(0);
        }
    }
}