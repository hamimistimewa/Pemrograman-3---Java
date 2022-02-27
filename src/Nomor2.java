import java.util.*;

public class Nomor2 {
    public static void main(String[] args) {
        Scanner xyz = new Scanner(System.in);
        System.out.print("Digit terakhir NPM Anda : ");
        int npm = xyz.nextInt();
        System.out.println(npm + "\t" + uap(npm));
    }

    static int uap(int b) {
        if (b == 0)
            return 2;
        else
            return 2 * uap(b - 1) + 1;
    }
}