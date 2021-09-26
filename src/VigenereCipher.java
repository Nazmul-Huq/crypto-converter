public class VigenereCipher {
    static char[] englishAlphabetUppercase = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    public static void main(String[] args) {
        //Encryption
        //The plaintext(P) and key(K) are added modulo 26.
        //Ei = (Pi + Ki) mod 26

        //Decryption
        //Di = (Ei - Ki + 26) mod 26

        String vigenereCipherKey = "DAD";
        String messageToEncode   = "GOODBOY";
        String messageToDecode = "HOREBRZ";

        String[] encodeVigenereCipheredMessage = vigenereEncoder(messageToEncode, vigenereCipherKey);
        printMessage(encodeVigenereCipheredMessage);
        System.out.println();
/*        String[] decodedVigenereCipheredMessage = vigenereDecoder(messageToDecode, vigenereCipherKey);
        printMessage(decodedVigenereCipheredMessage);*/


    } //end of main
    public static String[] vigenereDecoder(String messageToDecode, String vigenereCipherKey){// decode a vigenere ciphered message
        String[] decodedVigenereCipheredMessage = new String[messageToDecode.length()];
        for (int i = 0; i < messageToDecode.length(); i++) {
            int asciiValueOfKeyChar = getCharFromVigenereKey(messageToDecode, vigenereCipherKey, i);
            int asciiValueOfMessageChar = messageToDecode.charAt(i);
            char decodedChar = getVigenereDecodedChar(asciiValueOfKeyChar, asciiValueOfMessageChar);
            decodedVigenereCipheredMessage[i] = String.valueOf(decodedChar);
        }
        return decodedVigenereCipheredMessage;
    }

    public static char getVigenereDecodedChar(int asciiValueOfKeyChar, int asciiValueOfMessageChar){
        // retrieve the original char from a specific char from encoded message
        // Example if encoded message = "HOREBRZ", this method with retrieve the actual meaning of char 'H'/'O'/'R'......
        char decodedChar = 'A';
        int decodedCharIndex = Math.abs(asciiValueOfKeyChar - asciiValueOfMessageChar);
        decodedChar = englishAlphabetUppercase[decodedCharIndex];
        return decodedChar;
    }

    public static String[]  vigenereEncoder(String messageToEncode, String vigenereCipherKey){ //encode a vinegere ciphered message
        String[] encodedVigenereCipheredMessage = new String[messageToEncode.length()];
        for (int i = 0; i < messageToEncode.length(); i++) {
            int asciiValueOfKeyChar = getCharFromVigenereKey(messageToEncode, vigenereCipherKey, i);
            int asciiValueOfMessageChar = messageToEncode.charAt(i);
            char encodedChar = getVigenereEncodedChar(asciiValueOfKeyChar, asciiValueOfMessageChar);
            encodedVigenereCipheredMessage[i] = String.valueOf(encodedChar);
        }
        return encodedVigenereCipheredMessage;
    }

    public static char getCharFromVigenereKey(String messageToEncode, String vigenereCipherKey, int indexValue){
        //get a correspondent char from "vigenereCipherKey",
        // Example if key is "BAD" you need to use either B/A/D char as a key to encode a specific char of your message
        // this method will return you the right key char  to use
        char keyChar = 'A';
        int indexValueOfKeyCharToBeUsed = indexValue % vigenereCipherKey.length();
        keyChar = vigenereCipherKey.charAt(indexValueOfKeyCharToBeUsed);
        return keyChar;
    }

    public static char getVigenereEncodedChar(int asciiValueOfKeyChar, int asciiValueOfMessageChar){
        //will return an encoded char by using right key char against a specific char of your message
        char encodedChar = 'A';
        int encodedCharIndex = (asciiValueOfKeyChar + asciiValueOfMessageChar)%26;
        encodedChar = englishAlphabetUppercase[encodedCharIndex];
        return encodedChar;
    }

    public static void printMessage(String[] message) {
        // print the encoded or decoded message
        for (String printMessage:message) {System.out.print(printMessage);}
    }
} // end of class
