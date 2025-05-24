import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt(); // 카드의 개수
        int m = scan.nextInt(); // m과 가장 가까운 숫자를 만들어야 함
        int[] numbers = new int[n];
        int min = 0;            // 결과

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = scan.nextInt();    // 이 중 3개의 숫자 선택
        }
        scan.close();

        for (int i = 0; i < numbers.length - 2; i++) {
            for (int j = i + 1; j < numbers.length - 1; j++) {
                for (int k = j + 1; k < numbers.length; k++) {
                    int sum = numbers[i] + numbers[j] + numbers[k];
                    if(sum > m) continue;
                    if((m-sum)<(m-min)){
                        min = sum;
                    }
                }
            }
        }

        System.out.println(min);
    }
}