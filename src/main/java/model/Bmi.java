package model;

public class Bmi {

    private final String nama;
    private final double beratKg;
    private final double tinggiCm;

    public Bmi(String nama, double beratKg, double tinggiCm) {
        if (nama == null || nama.isBlank()) {
            throw new IllegalArgumentException("Nama wajib diisi.");
        }
        if (beratKg <= 0) {
            throw new IllegalArgumentException("Berat badan harus lebih dari nol.");
        }
        if (tinggiCm <= 0) {
            throw new IllegalArgumentException("Tinggi badan harus lebih dari nol.");
        }
        this.nama = nama.trim();
        this.beratKg = beratKg;
        this.tinggiCm = tinggiCm;
    }

    public String getNama() {
        return nama;
    }

    // Rumus: berat (kg) dibagi tinggi (meter) kuadrat
    public double hitungBmi() {
        double tinggiM = tinggiCm / 100;
        return beratKg / (tinggiM * tinggiM);
    }

    // Kategori menurut standar WHO
    public String getKategori() {
        double bmi = hitungBmi();
        if (bmi < 18.5) {
            return "Kurus";
        } else if (bmi < 25) {
            return "Normal";
        } else if (bmi < 30) {
            return "Kelebihan berat badan";
        } else {
            return "Obesitas";
        }
    }
}
