package com.example.demo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
public class AddController{
    @FXML
    private TextField text_num, text_fio, text_shifer, text_type, text_inn, text_doc, text_sernum, text_organ;
    private Stage dialog;
    private ObservableList<Clients> clients = FXCollections.observableArrayList();
    @FXML
    void add(ActionEvent event) {
        if(!text_num.getText().isEmpty() && !text_fio.getText().isEmpty() && !text_shifer.getText().isEmpty()
                && !text_type.getText().isEmpty() && !text_inn.getText().isEmpty() && !text_doc.getText().isEmpty()
                && !text_sernum.getText().isEmpty()&& !text_organ.getText().isEmpty()){
            clients.add(new Clients(text_num.getText(),text_fio.getText(),text_shifer.getText(),text_type.getText(),
                    text_inn.getText(), text_doc.getText(), text_sernum.getText(), text_organ.getText()));
            dialog.close();}
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(dialog);
            alert.setTitle("Пустое поле!");
            alert.setHeaderText("Одно или несколько полей пусты!");
            alert.showAndWait();
        }
    }
    @FXML
    void cancel(ActionEvent event) {dialog.close();}
    public void getdialog(Stage dialog)
    {this.dialog = dialog;}
    public void getagreements(ObservableList<Clients> clients) {this.clients = clients;}
}



