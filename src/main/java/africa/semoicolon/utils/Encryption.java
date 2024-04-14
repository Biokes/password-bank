package africa.semoicolon.utils;

public class Encryption{
    public static String encrypt(String word, int secretKey){
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            char gotten = word.charAt(i);
            if (Character.isLetter(gotten)) {
                if (Character.isUpperCase(gotten)) {
                    gotten = (char) ('A' + (gotten - 'A' + secretKey) % 26);
                } else {
                    gotten = (char) ('a' + (gotten - 'a' + secretKey) % 26);
                }
            }
            result.append(gotten);
        }
        return result.toString();
    }
    public static String decrypt(String text, int secretKey){
        return encrypt(text, 26 - (secretKey % 26));
    }
//    public static void main(String[] args){
//        String pass = encrypt("name 912", 1);
//        System.out.println(pass);
//        System.out.println(decrypt(pass, 1));
//    }
}


