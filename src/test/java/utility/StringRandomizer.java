package utility;

import java.util.Random;

public class StringRandomizer {
    //String randomString = "a6bbnf853";
   public static String getSaltString(int stringSize) {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < stringSize) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString().toLowerCase();
        return saltStr;

    }

    public static void main(String[] args) {
        System.out.println(StringRandomizer.getSaltString(5));
    }
}
