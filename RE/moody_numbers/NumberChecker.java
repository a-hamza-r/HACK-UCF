/*
 * Decompiled with CFR 0.150.
 */
import java.math.BigInteger;
import java.security.MessageDigest;

public class NumberChecker {
    public boolean isHappy(int n) {
        if (n % 270719 != 0) {
            return false;
        }
        return (n /= 270719) == 6317;
    }

    public boolean isScary(int n) {
        if ((n & 0xFF) != 0) {
            return false;
        }
        if (n >> 12 != 0) {
            return false;
        }
        return (n >> 8 ^ 0xF) == 4;
    }

    public boolean isNostalgic(int n) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            byte[] arrby = Integer.toString(n).getBytes("UTF-8");
            byte[] arrby2 = messageDigest.digest(arrby);
            BigInteger bigInteger = new BigInteger(1, arrby2);
            String string = String.format("%032x", bigInteger);
            return string.equals("08ef85248841b7fbf4b1ef8d1090a0d4");
        }
        catch (Exception exception) {
            System.out.println("An error occurred: " + exception);
            return false;
        }
    }

    public boolean isArousing(int n) {
        int n2 = n % 10;
        int n3 = (n /= 10) % 10;
        n /= 10;
        if (n3 % 2 != 0) {
            return false;
        }
        if (n2 != n3 / 2 * 3) {
            return false;
        }
        for (int i = 0; i < 3; ++i) {
            if (n % 10 != n2) {
                return false;
            }
            if ((n /= 10) % 10 != n3) {
                return false;
            }
            n /= 10;
        }
        if (n != 0) {
            return false;
        }
        if (n2 % 2 == 0) {
            return false;
        }
        return (n2 ^ n3) == 15;
    }
}

