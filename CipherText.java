/*
Name  : Penke Akash
Class : CSE A (3rd Year)
RegNo : 24K65A0512
*/

import java.util.*;

class CipherText {
    public static void main(String args[]) {

        String text, ctext = "", dtext = "";
        int shift, i;
        Scanner ak = new Scanner(System.in);

        System.out.println("Enter a text:");
        text = ak.nextLine();

        System.out.println("Enter Shift Value:");
        shift = ak.nextInt();

        // Encryption
        for (i = 0; i < text.length(); i++) {
            char t = text.charAt(i);

            if (t >= 'A' && t <= 'Z')
                ctext += (char) ((t - 'A' + shift) % 26 + 'A');
            else if (t >= 'a' && t <= 'z')
                ctext += (char) ((t - 'a' + shift) % 26 + 'a');
            else
                ctext += t;
        }

        System.out.println("THE CIPHER TEXT IS: " + ctext);

        // Decryption
        for (i = 0; i < ctext.length(); i++) {
            char t = ctext.charAt(i);

            if (t >= 'A' && t <= 'Z')
                dtext += (char) ((t - 'A' + 26 - shift) % 26 + 'A');
            else if (t >= 'a' && t <= 'z')
                dtext += (char) ((t - 'a' + 26 - shift) % 26 + 'a');
            else
                dtext += t;
        }

        System.out.println("THE PLAIN TEXT IS: " + dtext);
    }
}
