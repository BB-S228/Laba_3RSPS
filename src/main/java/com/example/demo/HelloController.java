package com.example.demo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @FXML
    private TableView<Clients> table_view;

    @FXML
    private TableColumn<Clients, String> column_num, column_fio, column_shifer, column_type, column_inn,
            column_doc, column_sernum, column_organ;

    @FXML
    private Label l_id, l_fio, l_shifer, l_type, l_inn, l_doc, l_sernum, l_organ;

    ObservableList<Clients> clients = FXCollections.observableArrayList(
            new Clients("1", "Щербенский Михаил Александрович", "Щебень", "Физ.Лицо",
                    "64748348439", "Паспорт", "6438 123832", "Паспортный стол"),
            new Clients("2", "Волчанская Наталья МИхайловна", "Волчок", "Юр.Лицо",
                    "64234452334", "Паспорт", "5232 234523", "Паспортный стол"));

    @FXML
    void add(ActionEvent event) throws IOException {
        Stage dialog = new Stage();
        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("AddFile.fxml"));
        dialog.setScene(new Scene(loader.load(),600, 400));
        AddController controller = loader.getController();
        controller.getdialog(dialog);
        controller.getagreements(clients);
        dialog.showAndWait();
        table_view.setItems(FXCollections.observableList(clients));
    }

    @FXML
    void delete(ActionEvent event) {
        if (table_view.getSelectionModel().getSelectedItem()!=null) {
            clients.remove(table_view.getSelectionModel().getSelectedItem());
            table_view.setItems(FXCollections.observableList(clients));
            l_id.setText("Клиент №");
            l_fio.setText("ФИО: ");
            l_shifer.setText("Шифр: ");
            l_type.setText("Тип: ");
            l_inn.setText("ИНН: ");
            l_doc.setText("Документ: ");
            l_sernum.setText("Серия и номер: ");
            l_organ.setText("Орган: ");
        }
    }

    @FXML
    void edit(ActionEvent event) throws IOException {
        if (table_view.getSelectionModel().getSelectedItem()!=null) {
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("EditFile.fxml"));
            stage.setScene(new Scene(loader.load(),600, 400));
            EditController controller = loader.getController();
            controller.getdialog(stage);
            int id = clients.indexOf(table_view.getSelectionModel().getSelectedItem());
            controller.getagreeemet(clients.get(id));
            stage.showAndWait();
            table_view.setItems(clients);
            table_view.getSelectionModel().clearSelection();
            table_view.getSelectionModel().select(id);
            table_view.refresh();
        }
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        column_num.setCellValueFactory(new PropertyValueFactory<Clients, String>("id"));
        column_fio.setCellValueFactory(new PropertyValueFactory<Clients, String>("fio"));
        column_shifer.setCellValueFactory(new PropertyValueFactory<Clients,String>("shifer"));
        column_type.setCellValueFactory(new PropertyValueFactory<Clients,String>("type"));
        column_inn.setCellValueFactory(new PropertyValueFactory<Clients,String>("inn"));
        column_doc.setCellValueFactory(new PropertyValueFactory<Clients,String>("document"));
        column_sernum.setCellValueFactory(new PropertyValueFactory<Clients,String>("sernum"));
        column_organ.setCellValueFactory(new PropertyValueFactory<Clients,String>("organ"));

        table_view.setItems(clients);
        table_view.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                Clients clients = table_view.getSelectionModel().getSelectedItem();
                l_id.setText("Преподаватель №"+clients.getId());
                l_fio.setText("Факультет: "+clients.getFio());
                l_shifer.setText("Кафедра: "+clients.getShifer());
                l_type.setText("ФИО: "+clients.getType());
                l_inn.setText("Должность: "+clients.getInn());
                l_doc.setText("Должность: "+clients.getDocument());
                l_sernum.setText("Должность: "+clients.getSernum());
                l_organ.setText("Должность: "+clients.getOrgan());
            }
        });
    }
}
