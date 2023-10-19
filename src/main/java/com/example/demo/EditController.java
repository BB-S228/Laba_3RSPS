package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EditController {
    @FXML

    private TextField text_num, text_fio, text_shifer, text_type, text_inn, text_doc, text_sernum, text_organ;

    private Stage dialog;

    private Clients clients;

    @FXML
    void edit(ActionEvent event) {
        if (!text_num.getText().isEmpty() && !text_fio.getText().isEmpty() && !text_shifer.getText().isEmpty()
                && !text_type.getText().isEmpty() && !text_inn.getText().isEmpty() && !text_doc.getText().isEmpty()
                && !text_sernum.getText().isEmpty()&& !text_organ.getText().isEmpty()){
            clients.setId(text_num.getText());
            clients.setFio(text_fio.getText());
            clients.setShifer(text_shifer.getText());
            clients.setType(text_type.getText());
            clients.setInn(text_inn.getText());
            clients.setDocument(text_doc.getText());
            clients.setSernum(text_sernum.getText());
            clients.setOrgan(text_organ.getText());
            dialog.close();}
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(dialog);
            alert.setTitle("Пустое поле!");
            alert.setHeaderText("Одно или несколько полей пусты");
            alert.showAndWait();
        }
    }

    @FXML
    void cancel(ActionEvent event) {dialog.close();}
    public void getdialog(Stage dialogStage) {this.dialog = dialogStage;}
    public void getagreeemet(Clients clients) {
        text_num.setText(clients.getId());
        text_fio.setText(clients.getFio());
        text_shifer.setText(clients.getShifer());
        text_type.setText(clients.getType());
        text_inn.setText(clients.getInn());
        text_doc.setText(clients.getDocument());
        text_sernum.setText(clients.getSernum());
        text_organ.setText(clients.getOrgan());
        this.clients = clients;}

}
