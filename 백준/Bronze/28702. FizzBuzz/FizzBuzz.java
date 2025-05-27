import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strArr = new String[3];
        strArr[0] = br.readLine();
        strArr[1] = br.readLine();
        strArr[2] = br.readLine();
        int n = 0;

        for (int i = 0; i < 3; i++) {
            if (strArr[i].contains("z")) {
                continue;
            } else {
                n = Integer.parseInt(strArr[i]) + 3 - i;
                if (n % 3 == 0) {
                    if (n % 5 == 0) {
                        System.out.println("FizzBuzz");
                        break;
                    } else {
                        System.out.println("Fizz");
                        break;
                    }
                } else if (n % 5 == 0) {
                    System.out.println("Buzz");
                    break;
                }
                System.out.println(n);
                break;
            }
        }
    }
}