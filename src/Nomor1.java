import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class Nomor1 {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Berapa baris : ");
        int baris = scan.nextInt();
        String text = "";
        for (int i = 0; i < baris + 1; i++) {
            text += scan.nextLine() + "\n";
        }
        replacetoFile(text);

    }

    public static void replacetoFile(String str) {
        try {
            FileWriter myWrite = new FileWriter(new File("uap2122.txt"), false);
            BufferedWriter out = new BufferedWriter(myWrite);
            myWrite.write(str);
            myWrite.close();
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}

/*
 * DATA YANG DI TULIS KE FILE uap.2122.txt
 * 
 * 
 * B632 2018 0093500 Eufloria
 * F004 2018 0084000 Kata
 * T029 2015 0127800 Javascript
 * F098 2017 0057800 Hujan
 * T578 2014 0205700 Pemograman C#
 */