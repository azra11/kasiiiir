package com.example.aplikasifremilt;

public class FremiltModel {
    String namaTempat;
    String harga;
    int fotoTempat;

    public FremiltModel(String namaTempat, int fotoTempat, String harga){
        this.harga = harga;
        this.namaTempat = namaTempat;
        this.fotoTempat = fotoTempat;
    }
    public String getNamaTempat() {
        return namaTempat;
    }

    public int getFotoTempat() {
        return fotoTempat;
    }

    public String getHarga() { return harga;}
}

