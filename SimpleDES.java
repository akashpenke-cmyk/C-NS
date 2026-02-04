public class SimpleDES {

    // XOR function
    static int[] xor(int[] a, int[] b) {
        int[] r = new int[a.length];
        for (int i = 0; i < a.length; i++)
            r[i] = a[i] ^ b[i];
        return r;
    }

    // Simple round function (non-linear-ish)
    static int[] feistel(int[] R, int[] key) {
        int[] out = new int[32];
        for (int i = 0; i < 32; i++) {
            out[i] = (R[i] & key[i]) ^ ((i % 2 == 0) ? 1 : 0);
        }
        return out;
    }

    public static void main(String[] args) {

        // 64-bit plaintext
        int[] plaintext = new int[64];
        for (int i = 0; i < 64; i++)
            plaintext[i] = i % 2;

        // Split into L and R
        int[] L = new int[32];
        int[] R = new int[32];
        System.arraycopy(plaintext, 0, L, 0, 32);
        System.arraycopy(plaintext, 32, R, 0, 32);

        // 32-bit key
        int[] key = new int[32];
        for (int i = 0; i < 32; i++)
            key[i] = (i % 3 == 0) ? 1 : 0;

        // 16 rounds
        for (int round = 0; round < 16; round++) {
            int[] temp = R;
            R = xor(L, feistel(R, key));
            L = temp;
        }

        // Combine (final swap)
        int[] cipher = new int[64];
        System.arraycopy(R, 0, cipher, 0, 32);
        System.arraycopy(L, 0, cipher, 32, 32);

        // Output
        System.out.println("Encrypted Text:");
        for (int bit : cipher)
            System.out.print(bit);
    }
}
