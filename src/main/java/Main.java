import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        try {
            Ciphers cipher = new Ciphers();
            cipher.loadCipher("ciphers/key.txt");

            Scanner input = new Scanner(System.in);
            System.out.println("Enter a ciphered message:");
            String message = input.nextLine();

            String decoded = cipher.decipher(message);
            System.out.println("Deciphered message:");
            System.out.println(decoded);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
