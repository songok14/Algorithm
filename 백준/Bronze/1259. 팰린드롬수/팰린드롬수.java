import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            String[] arr = br.readLine().split("");
            boolean flag = true;

            if(arr[0].equals("0")){
                break;
            }

            for (int i = 0; i < arr.length; i++) {
                if (!arr[i].equals(arr[arr.length - i - 1])) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
        
        br.close();
    }
}