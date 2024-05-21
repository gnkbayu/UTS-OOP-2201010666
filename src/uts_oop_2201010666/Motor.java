/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package uts_oop_2201010666;

/**
 *
 * @author I DEWA AGUNG BAYU MEGA HARTAMA 2201010666
 */
public class Motor {
    private String merk;
    private String platNomor;
    private double hargaSewaPerHari;

    public Motor(String merk, String platNomor, double hargaSewaPerHari) {
        this.merk = merk;
        this.platNomor = platNomor;
        this.hargaSewaPerHari = hargaSewaPerHari;
    }

    public String getMerk() {
        return merk;
    }

    public String getPlatNomor() {
        return platNomor;
    }

    public double getHargaSewaPerHari() {
        return hargaSewaPerHari;
    }

    @Override
    public String toString() {
        return "Merk: " + merk + ", Plat Nomor: " + platNomor + ", Harga Sewa per Hari: " + hargaSewaPerHari;
    }
}
