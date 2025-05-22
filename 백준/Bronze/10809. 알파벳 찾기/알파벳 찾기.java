import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String str = scan.nextLine();
        int[] al = new int[26];     // a ~ z 갯수만큼 배열로 저장
        Arrays.fill(al, -1);        // al[] -1로 초기화

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            c -= 97;                // 입력받은 문자열을 한 문자씩 반복하면서
                                    // 배열 인덱스에 맞도록 조정
            if (al[c] == -1) {      // 처음 나오는 문자의 순서만 배열에 저장
                al[c] = i;
            }
        }

        for (int i = 0; i < al.length; i++) {
            System.out.print(al[i] + " ");
        }

    }
}