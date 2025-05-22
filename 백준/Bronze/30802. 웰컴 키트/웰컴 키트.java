import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int sizeCount = 0;              // sizeCount: 총 티셔츠 주문 수, size: 사이즈별 신청자 수
        int pCount = 0;                 // pCount: 묶음 펜 주문 수, pMod: 낱개 펜 주문 수
        int n = scan.nextInt();         // n: 총 신청자 수, t: 티셔츠 묶음 수, p: 펜 묶음 수
        int[] size = new int[6];
        for (int i = 0; i < 6; i++) {
            size[i] = scan.nextInt();
        }
        int t = scan.nextInt();
        int p = scan.nextInt();
        scan.close();

        // 티셔츠
        for (int i = 0; i < size.length; i++) {
            if (size[i] == 0) continue;   // 신청자가 없으면 건너뜀
            else if (size[i] % t == 0) {
                sizeCount += size[i] / t;
            } else {
                sizeCount += size[i] / t + 1;
            }
        }

        // 펜
        pCount = n / p;

        System.out.println(sizeCount);
        System.out.println(pCount + " " + (n % p));
    }
}