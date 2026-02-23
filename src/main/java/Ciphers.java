import java.io.*;
import java.util.*;

public class Ciphers {

    private String realAlphabet;
    private String cipherAlphabet;

    // ---------- LOAD AND VALIDATE CIPHER ----------
    public void loadCipher(String filepath) throws Exception {

        File file = new File(filepath);

        if (!file.exists()) {
            throw new Exception("Cipher file not found.");
        }

        Scanner scanner = new Scanner(file);

        if (!scanner.hasNextLine()) {
            scanner.close();
            throw new Exception("Cipher file must contain two lines.");
        }
        realAlphabet = scanner.nextLine();

        if (!scanner.hasNextLine()) {
            scanner.close();
            throw new Exception("Cipher file must contain two lines.");
        }
        cipherAlphabet = scanner.nextLine();

        scanner.close();

        // Validate same length
        if (realAlphabet.length() != cipherAlphabet.length()) {
            throw new Exception("Both lines in key.txt must have same length.");
        }

        // Validate duplicates
        if (hasDuplicates(realAlphabet)) {
            throw new Exception("Duplicate characters found in real alphabet.");
        }

        if (hasDuplicates(cipherAlphabet)) {
            throw new Exception("Duplicate characters found in cipher alphabet.");
        }
    }

    // ---------- CHECK DUPLICATES ----------
    private boolean hasDuplicates(String s) {
        Set<Character> seen = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (!seen.add(c)) {
                return true;
            }
        }
        return false;
    }

    // ---------- DECIPHER METHOD ----------
    public String decipher(String inputText) {

        StringBuilder result = new StringBuilder();

        for (char c : inputText.toCharArray()) {

            int index = cipherAlphabet.indexOf(c);

            if (index != -1) {
                result.append(realAlphabet.charAt(index));
            } else {
                // If character not in cipher, keep it unchanged
                result.append(c);
            }
        }

        return result.toString();
    }
}
