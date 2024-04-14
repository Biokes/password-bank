package africa.semoicolon.utils;

public class Encryption{
    public static String encrypt(String word, int secretKey) {
        StringBuilder result = new StringBuilder();
        for (int index = 0; index < word.length(); index++) {
            char gotten = word.charAt(index);
            if (Character.isLetter(gotten)) {
                if (Character.isUpperCase(gotten)) {
                    gotten = (char) ('A' + (gotten - 'A' + secretKey) % 26);
                } else {
                    gotten = (char) ('a' + (gotten - 'a' + secretKey) % 26);
                }
            } else if (Character.isDigit(gotten)) {
                gotten = (char) ('0' + (gotten - '0' + secretKey) % 10);
            }
            result.append(gotten);
        }
        return result.toString();
    }

    public static String decrypt(String encryptedWord, int secretKey) {
        StringBuilder result = new StringBuilder();
        for (int index = 0; index < encryptedWord.length(); index++) {
            char gotten = encryptedWord.charAt(index);
            if (Character.isLetter(gotten)) {
                if (Character.isUpperCase(gotten)) {
                    gotten = (char) ('A' + (gotten - 'A' - secretKey + 26) % 26);
                } else {
                    gotten = (char) ('a' + (gotten - 'a' - secretKey + 26) % 26);
                }
            } else if (Character.isDigit(gotten)) {
                gotten = (char) ('0' + (gotten - '0' - secretKey + 10) % 10);
            }
            result.append(gotten);
        }
        return result.toString();
    }


    public static void main(String[] args){
        String pass = encrypt("12345biok l", 1200);
        System.out.println(pass);
        System.out.println(decrypt(pass, 1200));
    }
}


