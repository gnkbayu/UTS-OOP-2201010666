/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uts_oop_2201010666;

/**
 *
 * @author Asus
 */
public class PeminjamanMotor {
    private static final int MAX_PEMINJAMAN = 10; // Maksimum 10 peminjaman yang bisa disimpan

    private Motor[] motors;
    private String[] penyewa;
    private int[] lamaPeminjaman;
    private double hargaSewaPerHari;
    private int count;

    public PeminjamanMotor(double hargaSewaPerHari) {
        motors = new Motor[MAX_PEMINJAMAN];
        penyewa = new String[MAX_PEMINJAMAN];
        lamaPeminjaman = new int[MAX_PEMINJAMAN];
        this.hargaSewaPerHari = hargaSewaPerHari;
        count = 0;
    }

    public void tambahPeminjaman(Motor motor, String namaPenyewa, int lamaPeminjaman) {
        if (count < MAX_PEMINJAMAN) {
            motors[count] = motor;
            penyewa[count] = namaPenyewa;
            this.lamaPeminjaman[count] = lamaPeminjaman;
            count++;
            System.out.println("Peminjaman motor berhasil ditambahkan.");
        } else {
            System.out.println("Kapasitas peminjaman motor penuh, tidak bisa menambahkan peminjaman baru.");
        }
    }

    public void tampilkanPeminjaman() {
        System.out.println("Daftar Peminjaman Motor:");
        for (int i = 0; i < count; i++) {
            double totalHarga = hitungTotalHarga(i);
            System.out.println((i+1) + ". Penyewa: " + penyewa[i] + ", Lama Peminjaman: " + lamaPeminjaman[i] + " hari, Motor: " + motors[i] + ", Total Harga: " + totalHarga);
        }
    }

    public double hitungTotalHarga(int index) {
        return hargaSewaPerHari * lamaPeminjaman[index];
    }

    public void ubahPeminjaman(int index, Motor motorBaru) {
        if (index >= 0 && index < count) {
            motors[index] = motorBaru;
            System.out.println("Data peminjaman motor berhasil diubah.");
        } else {
            System.out.println("Indeks peminjaman motor tidak valid.");
        }
    }

    public void hapusPeminjaman(int index) {
        if (index >= 0 && index < count) {
            for (int i = index; i < count - 1; i++) {
                motors[i] = motors[i + 1];
                penyewa[i] = penyewa[i + 1];
                lamaPeminjaman[i] = lamaPeminjaman[i + 1];
            }
            motors[count - 1] = null;
            penyewa[count - 1] = null;
            lamaPeminjaman[count - 1] = 0;
            count--;
            System.out.println("Peminjaman motor berhasil dihapus.");
        } else {
            System.out.println("Indeks peminjaman motor tidak valid.");
        }
    }
}
