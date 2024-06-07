package source;

import javafx.scene.control.TextField;

public class Barang {
    public int Id;   
    public String nama;
    public int kuantitas;   
    public String url;
    public String tipe;
    
    public int getId() {return Id;}
    public String getNama() {return nama;}
    public int getKuantitas() {return kuantitas;}
    public String getUrl() {return url;}
    public String getTipe() {return tipe;}
    
    public void setId(int id) {Id = id;}
    public void setNama(String nama) {this.nama = nama;}
    public void setKuantitas(int kuantitas) {this.kuantitas = kuantitas;}
    public void setUrl(String url) {this.url = url;}
    public void setTipe(String tipe) {this.tipe = tipe;}
    
    public Barang(String nama, int kuantitas, String url, String tipe) {
        this.nama = nama;
        this.kuantitas = kuantitas;
        this.url = url;
        this.tipe = tipe;
    }

    public Barang(TextField nama, TextField kuantitas, TextField url, TextField tipe) {
        this.nama = nama.getText();
        this.kuantitas = Integer.parseInt(kuantitas.getText());
        this.url = url.getText();
        this.tipe = tipe.getText();
    }
}
