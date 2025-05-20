import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String str = scan.nextLine().trim();
        
        if(str.isEmpty()){
            System.out.println(0);            
        } else {
            String[] words = str.split(" ");
            System.out.println(words.length);
        }
    }
}