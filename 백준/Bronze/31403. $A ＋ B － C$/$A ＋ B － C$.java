import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String str1 = scan.nextLine();
        String str2 = scan.nextLine();
        String str3 = scan.nextLine();

        int n1 = Integer.parseInt(str1);
        int n2 = Integer.parseInt(str2);
        int n3 = Integer.parseInt(str3);
        System.out.println(n1+n2-n3);

        int sol = Integer.parseInt(str1+ str2) - Integer.parseInt(str3);
        System.out.println(sol);

    }
}
//수정 - github 연동