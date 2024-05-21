/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uts_oop_2201010666;

/**
 *
 * @author I DEWA AGUNG BAYU MEGA HARTAMA 2201010666
 */
import java.util.Scanner;
public class RentalMotor {
    private static final int MAX_MOTOR = 10; // Maksimum 10 motor yang bisa disimpan

    private Motor[] motors;
    private PeminjamanMotor peminjamanMotor;
    private int count;
    private double hargaSewaPerHari;

    public RentalMotor(double hargaSewaPerHari) {
        motors = new Motor[MAX_MOTOR];
        peminjamanMotor = new PeminjamanMotor(hargaSewaPerHari); // Membuat objek PeminjamanMotor
        count = 0;
        this.hargaSewaPerHari = hargaSewaPerHari;
    }

    public void tambahMotor(String merk, String platNomor) {
        if (count < MAX_MOTOR) {
            Motor motor = new Motor(merk, platNomor, hargaSewaPerHari);
            motors[count] = motor;
            count++;
            System.out.println("Motor berhasil ditambahkan.");
        } else {
            System.out.println("Kapasitas motor penuh, tidak bisa menambahkan motor baru.");
        }
    }

    public void tampilkanMotor() {
        System.out.println("Daftar Motor:");
        for (int i = 0; i < count; i++) {
            System.out.println((i+1) + ". " + motors[i]);
        }
    }

    public void peminjamanMotor(String merk, String platNomor, String namaPenyewa, int lamaPeminjaman) {
        if (count == 0) {
            System.out.println("Tidak dapat melakukan peminjaman motor karena belum ada motor yang tersedia.");
            return;
        }
        // Membuat objek Motor untuk melakukan peminjaman
        Motor motor = new Motor(merk, platNomor, hargaSewaPerHari);
        // Memanggil metode tambahPeminjaman dari objek PeminjamanMotor
        peminjamanMotor.tambahPeminjaman(motor, namaPenyewa, lamaPeminjaman);
    }

    public void tampilkanPeminjaman() {
        // Memanggil metode tampilkanPeminjaman dari objek PeminjamanMotor
        peminjamanMotor.tampilkanPeminjaman();
    }

    public void ubahPeminjaman(int index, Motor motorBaru) {
        // Memanggil metode ubahPeminjaman dari objek PeminjamanMotor
        peminjamanMotor.ubahPeminjaman(index, motorBaru);
    }

    public void hapusPeminjaman(int index) {
        // Memanggil metode hapusPeminjaman dari objek PeminjamanMotor
        peminjamanMotor.hapusPeminjaman(index);
    }

    public static void main(String[] args) {
        double hargaSewaPerHari = 100000; // Harga sewa per hari
        RentalMotor rentalMotor = new RentalMotor(hargaSewaPerHari);
        Scanner scanner = new Scanner(System.in);
        int pilihan;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Tambah Motor");
            System.out.println("2. Tampilkan Motor");
            System.out.println("3. Tambah Peminjaman Motor");
            System.out.println("4. Tampilkan Peminjaman Motor");
            System.out.println("5. Ubah Data Peminjaman Motor");
            System.out.println("6. Hapus Peminjaman Motor");
            System.out.println("0. Keluar");
            System.out.print("Pilihan Anda: ");
            pilihan = scanner.nextInt();
            scanner.nextLine(); // Membersihkan buffer

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan merk motor: ");
                    String merk = scanner.nextLine();
                    System.out.print("Masukkan plat nomor motor: ");
                    String platNomor = scanner.nextLine();
                    rentalMotor.tambahMotor(merk, platNomor);
                    break;
                case 2:
                    rentalMotor.tampilkanMotor();
                    break;
                case 3:
                    System.out.print("Masukkan merk motor yang akan dipinjam: ");
                    String merkPeminjaman = scanner.nextLine();
                    System.out.print("Masukkan plat nomor motor yang akan dipinjam: ");
                    String platNomorPeminjaman = scanner.nextLine();
                    System.out.print("Masukkan nama penyewa: ");
                    String namaPenyewa = scanner.nextLine();
                    System.out.print("Masukkan lama peminjaman (hari): ");
                    int lamaPeminjaman = scanner.nextInt();
                    rentalMotor.peminjamanMotor(merkPeminjaman, platNomorPeminjaman, namaPenyewa, lamaPeminjaman);
                    break;
                case 4:
                    rentalMotor.tampilkanPeminjaman();
                    break;
                case 5:
                    System.out.print("Masukkan indeks peminjaman motor yang akan diubah: ");
                    int indeksUbah = scanner.nextInt();
                    scanner.nextLine(); // Membersihkan buffer
                    System.out.print("Masukkan merk motor baru: ");
                    String merkBaru = scanner.nextLine();
                    System.out.print("Masukkan plat nomor motor baru: ");
                    String platNomorBaru = scanner.nextLine();
                    Motor motorBaru = new Motor(merkBaru, platNomorBaru, hargaSewaPerHari);
                    rentalMotor.ubahPeminjaman(indeksUbah - 1, motorBaru);
                    break;
                case 6:
                    System.out.print("Masukkan indeks peminjaman motor yang akan dihapus: ");
                    int indeksHapus = scanner.nextInt();
                    rentalMotor.hapusPeminjaman(indeksHapus - 1);
                    break;
                case 0:
                    System.out.println("Terima kasih!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        } while (pilihan != 0);

        scanner.close();
    }
}
