/*
Name  : Penke Akash
Class : CSE A (3rd Year)
RegNo : 24K65A0512
*/

import java.util.*;

class SubstitutionTest {
    public static void main(String args[]) {

        Scanner ak = new Scanner(System.in);
        String text, ctext = "", dtext = "";
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String key = "QWERTYUIOPASDFGHJKLZXCVBNM";

        System.out.println("Enter a text:");
        text = ak.nextLine().toUpperCase();

        for (int i = 0; i < text.length(); i++) {
            char a = text.charAt(i);

            for (int j = 0; j < 26; j++) {
                if (a == alphabet.charAt(j))
                    ctext += key.charAt(j);
                else if (a == ' ')
                    ctext += " ";
            }
        }

        System.out.println("The Encrypted text is: " + ctext);

        for (int i = 0; i < ctext.length(); i++) {
            char a = ctext.charAt(i);

            for (int j = 0; j < 26; j++) {
                if (a == key.charAt(j))
                    dtext += alphabet.charAt(j);
                else if (a == ' ')
                    dtext += " ";
            }
        }

        System.out.println("The Decrypted text is: " + dtext);
    }
}
