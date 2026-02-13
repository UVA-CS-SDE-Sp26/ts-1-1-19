public String decipher(String cipheredText) {
    StringBuilder result = new StringBuilder();

    for (char c : cipheredText.toCharArray()) {

        // Handle uppercase letters
        if (Character.isUpperCase(c)) {
            int index = cipherAlphabet.indexOf(Character.toLowerCase(c));
            if (index != -1) {
                char decodedChar = Character.toUpperCase(realAlphabet.charAt(index));
                result.append(decodedChar);
            } else {
                result.append(c); // leave random character unchanged
            }
        }

        // Handle lowercase letters
        else if (Character.isLowerCase(c)) {
            int index = cipherAlphabet.indexOf(c);
            if (index != -1) {
                result.append(realAlphabet.charAt(index));
            } else {
                result.append(c); // leave random character unchanged
            }
        }

        // Handle numbers, spaces, symbols
        else {
            result.append(c); // keep as-is
        }
    }

    return result.toString();
}
