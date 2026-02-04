/*
Name  : Penke Akash
Class : CSE A (3rd Year)
RegNo : 24K65A0512
*/

public class SimpleDES {

    static int[] xor(int[] a, int[] b) {
        int[] r = new int[a.length];
        for (int i = 0; i < a.length; i++)
            r[i] = a[i] ^ b[i];
        return r;
    }

    static int[] feistel(int[] R, int[] key) {
        int[] out = new int[32];
        for (int i = 0; i < 32; i++)
            out[i] = (R[i] & key[i]) ^ ((i % 2 == 0) ? 1 : 0);
        return out;
    }

    public static void main(String[] args) {

        int[] plaintext = new int[64];
        for (int i = 0; i < 64; i++)
            plaintext[i] = i % 2;

        int[] L = new int[32];
        int[] R = new int[32];
        System.arraycopy(plaintext, 0, L, 0, 32);
        System.arraycopy(plaintext, 32, R, 0, 32);

        int[] key = new int[32];
        for (int i = 0; i < 32; i++)
            key[i] = (i % 3 == 0) ? 1 : 0;

        for (int round = 0; round < 16; round++) {
            int[] temp = R;
            R = xor(L, feistel(R, key));
            L = temp;
        }

        int[] cipher = new int[64];
        System.arraycopy(R, 0, cipher, 0, 32);
        System.arraycopy(L, 0, cipher, 32, 32);

        System.out.println("Encrypted Text:");
        for (int bit : cipher)
            System.out.print(bit);
    }
}
