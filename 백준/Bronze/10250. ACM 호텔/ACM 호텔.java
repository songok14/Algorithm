import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String roomNum = "";
        int h = 0, w = 1;
        int roomCount = 0;
        int testCount = 0;
        int testData = scan.nextInt();

        int[] H = new int[testData];
        int[] W = new int[testData];
        int[] N = new int[testData];

        for (int i = 0; i < testData; i++) {
            H[i] = scan.nextInt();
            W[i] = scan.nextInt();
            N[i] = scan.nextInt();
        }

        while (testCount < testData) {
            while (roomCount != N[testCount]) {
                if (h == H[testCount]) {
                    h = 1;
                    w++;
                } else {
                    h++;
                }
                roomCount++;
            }

            if (w < 10) {
                roomNum = String.valueOf(h) + "0" + String.valueOf(w);
            } else {
                roomNum = String.valueOf(h) + String.valueOf(w);
            }

            System.out.println(roomNum);
            h = 0;
            w = 1;
            roomCount=0;
            testCount++;
        }
    }
}
// github 연동