import java.io.*;
import java.util.*;

public class Ciphers {

    private String realAlphabet;
    private String cipherAlphabet;

    // ---------- LOAD AND VALIDATE CIPHER ----------
    public void loadCipher(String filepath) throws Exception {
        File file = new File(filepath);
        Scanner scanner = new Scanner(file);

        if (!scanner.hasNextLine()) {
            scanner.close();
            throw new Exception("Cipher file is empty.");
        }
        realAlphabet = scanner.nextLine();

        if (!scanner.hasNextLine()) {
            scanner.close();
            throw new Exception("Cipher file must have two lines.");
        }
        cipherAlphabet = scanner.nextLine();
        scanner.close();

        // Validate same length
        if (realAlphabet.length() != cipherAlphabet.length()) {
            throw new Exception("Cipher lines must be the same length.");
        }

        // Validate no duplicate characters
        if (hasDuplicates(realAlphabet) || hasDuplicates(cipherAlphabet)) {
            throw new Exception("Cipher contains duplicate characters.");
        }
    }

    private boolean hasDuplicates(String s) {
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (set.contains(c)) {
                return true;
            }
            set.add(c);
        }
        return false;
    }

    // ----------  DECIPHER METHOD  ----------
    public String decipher(String cipheredText) {
        StringBuilder result = new StringBuilder();

        for (char c : cipheredText.toCharArray()) {
            int index = cipherAlphabet.indexOf(c);

            if (index != -1) {
                // Replace with real letter
                result.append(realAlphabet.charAt(index));
            } else {

                result.append(c);
            }
        }
        return result.toString();
    }
}