public class CipherTest {

    public static void main(String[] args) {

        System.out.println("===== RUNNING CIPHER TESTS =====\n");

        testValidCipher();
        testRandomCharacters();
        testNumbers();
        testInvalidFile();
        testDuplicateKey();

        System.out.println("\n===== TESTING COMPLETE =====");
    }

    // ------------------------------
    // TEST 1 - Normal Decipher
    // ------------------------------
    public static void testValidCipher() {
        try {
            Ciphers cipher = new Ciphers();
            cipher.loadCipher("ciphers/key.txt");

            String input = "uryyb jbeyq";
            String expected = "hello world";

            String result = cipher.decipher(input);

            if (result.equals(expected)) {
                System.out.println("Test 1 (Basic Decipher): PASS");
            } else {
                System.out.println("Test 1 (Basic Decipher): FAIL");
                System.out.println("Expected: " + expected);
                System.out.println("Got: " + result);
            }

        } catch (Exception e) {
            System.out.println("Test 1 FAILED with exception: " + e.getMessage());
        }
    }

    // ------------------------------
    // TEST 2 - Random Characters
    // ------------------------------
    public static void testRandomCharacters() {
        try {
            Ciphers cipher = new Ciphers();
            cipher.loadCipher("ciphers/key.txt");

            String input = "uryyb!!!";
            String expected = "hello!!!";

            String result = cipher.decipher(input);

            if (result.equals(expected)) {
                System.out.println("Test 2 (Random Characters): PASS");
            } else {
                System.out.println("Test 2 (Random Characters): FAIL");
            }

        } catch (Exception e) {
            System.out.println("Test 2 FAILED with exception: " + e.getMessage());
        }
    }

    // ------------------------------
    // TEST 3 - Numbers (if included in key.txt)
    // ------------------------------
    public static void testNumbers() {
        try {
            Ciphers cipher = new Ciphers();
            cipher.loadCipher("ciphers/key.txt");

            String input = "678";
            String result = cipher.decipher(input);

            System.out.println("Test 3 (Numbers) Output: " + result);
            System.out.println("Test 3 (Numbers): Check manually if numbers convert correctly.");

        } catch (Exception e) {
            System.out.println("Test 3 FAILED with exception: " + e.getMessage());
        }
    }

    // ------------------------------
    // TEST 4 - Invalid File
    // ------------------------------
    public static void testInvalidFile() {
        try {
            Ciphers cipher = new Ciphers();
            cipher.loadCipher("ciphers/nonexistent.txt");

            System.out.println("Test 4 (Invalid File): FAIL - No exception thrown");

        } catch (Exception e) {
            System.out.println("Test 4 (Invalid File): PASS");
        }
    }

    // ------------------------------
    // TEST 5 - Duplicate Key Test
    // ------------------------------
    public static void testDuplicateKey() {
        try {
            Ciphers cipher = new Ciphers();

            // Temporarily change this to a bad key file to test
            cipher.loadCipher("ciphers/badkey.txt");

            System.out.println("Test 5 (Duplicate Key): FAIL - No exception thrown");

        } catch (Exception e) {
            System.out.println("Test 5 (Duplicate Key): PASS");
        }
    }
}
