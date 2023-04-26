/*
 * Decompiled with CFR 0.150.
 */
import java.nio.ByteBuffer;
import java.util.Scanner;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

class MoodyNumbers {
    MoodyNumbers() {
    }

    public static void main(String[] arrstring) {
        Scanner scanner = new Scanner(System.in);
        NumberChecker numberChecker = new NumberChecker();
        System.out.println("Greetings, human! I am the Moody Number Bot.");
        MoodyNumbers.sleep(1000);
        System.out.println("We're going to play a little game.");
        MoodyNumbers.sleep(1000);
        System.out.println("Here's how it's going to go:");
        MoodyNumbers.sleep(1000);
        System.out.println("I'm going to ask you to show me a number, and you're going to enter it in here.");
        MoodyNumbers.sleep(1000);
        System.out.println("If you don't give me the right number, I'm going to get so angry that I stop talking to you.");
        MoodyNumbers.sleep(1000);
        System.out.println("So don't give me the wrong numbers.");
        MoodyNumbers.sleep(1000);
        System.out.println("Now that we've got that out of the way, let's begin!");
        MoodyNumbers.sleep(1000);
        System.out.print("Show me a number that makes me happy: ");
        int n = scanner.nextInt();
        if (!numberChecker.isHappy(n)) {
            MoodyNumbers.wrongNumber("THAT NUMBER DOES NOT MAKE ME HAPPY!!!");
        }
        System.out.println("Ah, that number fills me with joy! Good one!");
        MoodyNumbers.sleep(1000);
        System.out.println("Okay, I have another request for you.");
        MoodyNumbers.sleep(1000);
        System.out.print("I'm in the mood to be scared. Frighten me with a number: ");
        int n2 = scanner.nextInt();
        if (!numberChecker.isScary(n2)) {
            MoodyNumbers.wrongNumber("IS THAT THE BEST YOU HAVE? THAT COULDN'T SCARE AN INFANT!!!");
        }
        System.out.println("AAAAAHHH!!! That was scary! I think I accidentally overflowed my buffer!");
        MoodyNumbers.sleep(1000);
        System.out.print("Give me a number that reminds me of my childhood: ");
        int n3 = scanner.nextInt();
        if (n3 == 0) {
            MoodyNumbers.wrongNumber("HOW DARE YOU INSULT MY CHILDHOOD!!!");
        } else if (!numberChecker.isNostalgic(n3)) {
            MoodyNumbers.wrongNumber("THIS NUMBER REMINDS ME OF THE TIME A MEAN HACKER ALMOST FRIED MY CIRCUITS, NOT MY CHILDHOOD!!!");
        }
        System.out.println("That number brings back memories of the time I received my first UDP packet!");
        MoodyNumbers.sleep(1000);
        System.out.print("Now I want a number that arouses my circuits: ");
        int n4 = scanner.nextInt();
        if (!numberChecker.isArousing(n4)) {
            MoodyNumbers.wrongNumber("THAT NUMBER IS SUCH A TURN-OFF THAT IT DISABLED MY NETWORK ADAPTER!!!");
        }
        System.out.println("Oooh, baby, that's a sexy number!");
        MoodyNumbers.sleep(1000);
        System.out.println("Okay, you win. Here's your stupid flag. Goodbye.");
        MoodyNumbers.sleep(1000);
        String string = MoodyNumbers.getFlag(n, n3, n2, n4);
        System.out.println(string);
        scanner.close();
    }

    static void sleep(int n) {
        try {
            Thread.sleep(n);
        }
        catch (InterruptedException interruptedException) {
            // empty catch block
        }
    }

    static void wrongNumber(String string) {
        System.out.println(string + " GET AWAY FROM ME!!!");
        System.exit(1);
    }

    static String getFlag(int n, int n2, int n3, int n4) {
        byte[] arrby = ByteBuffer.allocate(16).putInt(n).putInt(n2).putInt(n3).putInt(n4).array();
        SecretKeySpec secretKeySpec = new SecretKeySpec(arrby, "AES");
        try {
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(2, secretKeySpec);
            byte[] arrby2 = new byte[]{-70, 76, 66, -121, -86, -83, 121, 99, 64, 57, 38, 57, -126, 78, 41, -27, 81, 64, 106, 78, -85, 104, 2, -119, 57, 115, -48, 104, -110, 45, -12, 92, 89, -101, 49, 15, 22, 122, -71, -77, -8, 23, -102, 46, -31, 81, 60, -44};
            byte[] arrby3 = cipher.doFinal(arrby2);
            return new String(arrby3);
        }
        catch (Exception exception) {
            System.out.println("An error occurred: " + exception);
            return "ERROR";
        }
    }
}

