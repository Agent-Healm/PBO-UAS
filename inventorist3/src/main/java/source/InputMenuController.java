package source;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class InputMenuController {
    @FXML private ImageView imageViewPreview;
    @FXML private TextField textFieldNama;
    @FXML private TextField textFieldKuantitas;
    @FXML private TextField textFieldImagePath;
    @FXML private TextField textFieldTipe;
    @FXML private Label labelNama;
    @FXML private Label labelKuantitas;
    @FXML private Label labelImagePath;
    @FXML private Label labelTipe;
    @FXML private Button buttonPreviewImage ;
    @FXML private Button buttonSubmit;
    @FXML private Button buttonBack;
    
    FileInputStream fin;

    @FXML private void actionBack() throws IOException {
        App.setRoot("menu");
    }

    @FXML private void actionImagePath() throws IOException, SQLException {
        try {
            imageViewPreview.setImage(new Image(new FileInputStream(textFieldImagePath.getText())));
            imageViewPreview.setFitHeight(300);
            imageViewPreview.setPreserveRatio(true);
        }
        catch (FileNotFoundException fileError) {
            // System.out.println(fileError.getLocalizedMessage());
            // System.out.println("Where File hm? ");
            Alert noFileAlert = new Alert(AlertType.ERROR);
            noFileAlert.setTitle("File Not Found");
            noFileAlert.setHeaderText("File is not available.");
            // noFileAlert.setContentText("File is not available.");
            noFileAlert.showAndWait();
        }
    }

    @FXML private void actionSubmit() throws IOException{
        if(textFieldNama.getLength() == 0){ return; }
        if(textFieldKuantitas.getLength() == 0){ return; }
        if(textFieldImagePath.getLength() == 0){ return; }
        if(textFieldTipe.getLength() == 0){ return; }

        Barang barang = new Barang(textFieldNama, 
        textFieldKuantitas, 
        textFieldImagePath, 
        textFieldTipe);

        fin = new FileInputStream(barang.getImagePath());
        
        try {
            PreparedStatement psmt = Db.connection.prepareStatement(
                "INSERT INTO inventory (nama, kuantitas, tipe, image) VALUES (?, ?, ?, ?);"
            );
            psmt.setString(1, barang.getNama());
            psmt.setInt(2, barang.getKuantitas());
            psmt.setString(3, barang.getTipe());
            psmt.setBlob(4, fin);
            
            psmt.executeUpdate();
            App.setRoot("menu");
        }
        catch (SQLException sql){
            System.out.println(sql.getLocalizedMessage());
            Alert sqlPrimaryAlert = new Alert(AlertType.ERROR);
            sqlPrimaryAlert.setTitle("Name error");
            sqlPrimaryAlert.setContentText("Name already exists!");
            sqlPrimaryAlert.showAndWait();
        }

    }

}