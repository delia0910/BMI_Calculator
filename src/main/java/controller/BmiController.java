package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.Bmi;

public class BmiController {

    
    @FXML private TextField namaField;
    @FXML private TextField beratField;
    @FXML private TextField tinggiField;
    @FXML private Label hasilLabel;

    
    @FXML
    private void hitung() {
        try {
            
            double berat = Double.parseDouble(beratField.getText().trim().replace(',', '.'));
            double tinggi = Double.parseDouble(tinggiField.getText().trim().replace(',', '.'));

            Bmi bmi = new Bmi(namaField.getText(), berat, tinggi);

            hasilLabel.setStyle("-fx-text-fill: #166534;");
            hasilLabel.setText("Nama: " + bmi.getNama()
                    + "\nBMI: " + String.format("%.1f", bmi.hitungBmi())
                    + "\nKategori: " + bmi.getKategori());
        } catch (NumberFormatException e) {
            tampilkanError("Berat dan tinggi harus berupa angka, misalnya 60 dan 165.");
        } catch (IllegalArgumentException e) {
            tampilkanError(e.getMessage());
        }
    }

    
    @FXML
    private void reset() {
        namaField.clear();
        beratField.clear();
        tinggiField.clear();
        hasilLabel.setStyle("");
        hasilLabel.setText("Hasil perhitungan akan tampil di sini.");
    }

    private void tampilkanError(String pesan) {
        hasilLabel.setStyle("-fx-text-fill: #b91c1c;");
        hasilLabel.setText(pesan);
    }
}
