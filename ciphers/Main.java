import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Ciphers ciphers = new Ciphers();

            // Load the cipher key file
            ciphers.loadCipher("ciphers/key.txt");

            Scanner input = new Scanner(System.in);
            System.out.println("Enter a ciphered message:");
            String message = input.nextLine();

            String decoded = ciphers.decipher(message);
            System.out.println("Deciphered message:");
            System.out.println(decoded);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}