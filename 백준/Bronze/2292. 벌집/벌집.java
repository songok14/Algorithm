import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int count = 1;  // 최초 이동
        int x = 1;

        // 1 / 2~7(6) / 8~19(12) / 20~37(18) / 38~62(24) ...
        // 다음 칸으로 갈때마다 6의 배수만큼 증가

        while (x < n) {
            x += count * 6;
            count++;
        }

        System.out.println(count);
    }
}