import org.sqlite.*;
import java.sql.*;
import java.util.Scanner;

public class Nomor4 {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        connectDB();
        System.out.println("~UBAH DATA NILAI MAHASISWA~");
        System.out.print("Input NPM : ");
        String nim = scan.nextLine();
        selectingDB(nim);
        otwInsert(nim);
        end(nim);
    }

    public static void connectDB() {
        Connection c = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:nurhamim.db");
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }

    public static void otwInsert(String npm) {
        Scanner scan = new Scanner(System.in);
        System.out.println("~Input perubahan data~");
        System.out.print("Input Nama\t\t: ");
        String nama = scan.nextLine();
        System.out.print("Input Kelas\t\t: ");
        String kelas = scan.nextLine();
        System.out.print("Input Nilai Teori\t: ");
        int teori = scan.nextInt();
        System.out.print("Input Nilai Praktik\t: ");
        int praktikum = scan.nextInt();
        insertDB(npm, nama, kelas, teori, praktikum);
    }

    public static void insertDB(String npm, String nama, String kelas, int nTeori, int nPraktik) {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:nurhamim.db");
            c.setAutoCommit(false);
            stmt = c.createStatement();
            String sql = "UPDATE mahasiswa SET Nama='" + nama + "' ,Kelas='" + kelas + "' ,Teori=" + nTeori
                    + " ,Praktikum=" + nPraktik + " where NPM=" + npm + ";";
            stmt.executeUpdate(sql);
            stmt.close();
            c.commit();
            c.close();
        } catch (Exception e) {
            // TODO: handle exception
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    public static void end(String nim) {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:nurhamim.db");
            c.setAutoCommit(false);
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM mahasiswa where npm=" + nim + ";");
            System.out.println("~Hasil pencarian data~");
            while (rs.next()) {
                String npm = rs.getString("NPM");
                String nama = rs.getString("Nama");
                String kelas = rs.getString("Kelas");
                double teori = rs.getInt("Teori");
                double praktikum = rs.getInt("Praktikum");
                System.out.println(
                        "====================================================================================");
                System.out.println("\t\t\t DATA NILAI MAHASISWA");
                System.out.println(
                        "====================================================================================");
                System.out.println("NPM\t\tNama Mahasiswa\tKelas\tTeori\tPraktikum\tNilai Akhir\tKeterangan");
                String ket = "";
                double hasil = (teori * 30 / 100) + (praktikum * 70 / 100);
                if (hasil >= 70) {
                    ket = "LULUS";
                } else {
                    ket = "TIDAK LULUS";
                }
                System.out.println(
                        "-------------------------------------------------------------------------------------------");
                System.out.println(npm + "\t" + nama + "\t" + kelas + "\t" + teori + "\t" + praktikum + "\t\t" + hasil
                        + "\t\t" + ket);
            }
            rs.close();
            stmt.close();
            c.close();
        } catch (Exception e) {
            // TODO: handle exception
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    public static void selectingDB(String nim) {
        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:nurhamim.db");
            c.setAutoCommit(false);
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM mahasiswa where npm=" + nim + ";");
            System.out.println("~Hasil pencarian data~");
            while (rs.next()) {
                int npm = rs.getInt("NPM");
                String nama = rs.getString("Nama");
                String kelas = rs.getString("Kelas");
                int teori = rs.getInt("Teori");
                int praktikum = rs.getInt("Praktikum");
                System.out.println("\tNama\t\t: " + nama);
                System.out.println("\tKelas\t\t: " + kelas);
                System.out.println("\tNilai Teori\t: " + teori);
                System.out.println("\tNilai Praktik\t: " + praktikum);
            }
            System.out.println(
                    "-------------------------------------------------------------------------------------------");
            rs.close();
            stmt.close();
            c.close();
        } catch (Exception e) {
            // TODO: handle exception
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }
}
