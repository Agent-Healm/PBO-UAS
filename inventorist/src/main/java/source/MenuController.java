package source;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class MenuController {
    @FXML private Button buttonCreate;
    @FXML private TableView<Barang> tableViewBarang;

    private ObservableList<TableColumn<Barang, ?>> cols = FXCollections.observableArrayList();

    @SuppressWarnings("unchecked")
    public void initialize(){
        // TableColumn<Barang, Integer> colId = new TableColumn<Barang, Integer>("ID");
        TableColumn<Barang, String> colNama = new TableColumn<Barang, String>("Nama");
        TableColumn<Barang, Integer> colKuantitas = new TableColumn<Barang, Integer>("Qty");
        TableColumn<Barang, String> colUrl = new TableColumn<Barang, String>("URL");
        TableColumn<Barang, String> colTipe = new TableColumn<Barang, String>("Tipe");

        // colId.setCellValueFactory(new PropertyValueFactory<Barang, Integer>("id"));
        colNama.setCellValueFactory(new PropertyValueFactory<Barang, String>("nama"));
        colKuantitas.setCellValueFactory(new PropertyValueFactory<Barang, Integer>("kuantitas"));
        colUrl.setCellValueFactory(new PropertyValueFactory<Barang, String>("url"));
        colTipe.setCellValueFactory(new PropertyValueFactory<Barang, String>("tipe"));

        cols.addAll(
            colNama,
            colKuantitas,
            colUrl,
            colTipe
        );  

        tableViewBarang.getColumns().addAll(cols);
        // loadData();
        tableViewBarang.getItems().addAll(loadData());
        tableViewBarang.getItems().addAll(App.barangList);
    }

    private static ObservableList<Barang> loadData(){
        Barang b1 = new Barang("A", 1, "www", "alp");
        Barang b2 = new Barang("B", 1, "www", "alp");
        Barang b3 = new Barang("C", 2, "www", "alp");
        Barang b4 = new Barang("D", 1, "www", "alp");

        ObservableList<Barang> daftarBarang = FXCollections.observableArrayList();
        daftarBarang.addAll(
            b1,
            b2,
            b3,
            b4
        );

        return daftarBarang;
    }

    @FXML private void actionCreate() throws IOException {
        App.setRoot("inputmenu");
    }   

}
