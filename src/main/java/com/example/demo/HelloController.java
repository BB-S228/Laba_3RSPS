package com.example.demo;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    List<Clients> CliList = Arrays.asList(
            new Clients("1", "Щербенский Михаил Александрович", "Щебень", "Физ.Лицо",
                    "64748348439", "Паспорт", "6438 123832", "Паспортный стол"),
            new Clients("2", "Волчанская Наталья МИхайловна", "Волчок", "Юр.Лицо",
                    "64234452334", "Паспорт", "5232 234523", "Паспортный стол"));

    ArrayList<Clients> CliArray = new ArrayList<>(CliList);

    @FXML
    private TableView<Clients> tabclients;

    @FXML
    private TableColumn<Clients, String> tabdoc;

    @FXML
    private TableColumn<Clients, String> tabfio;

    @FXML
    private TableColumn<Clients, String> tabid;

    @FXML
    private TableColumn<Clients, String> tabinn;

    @FXML
    private TableColumn<Clients, String> taborgan;

    @FXML
    private TableColumn<Clients, String> tabsernum;

    @FXML
    private TableColumn<Clients, String> tabshifer;

    @FXML
    private TableColumn<Clients, String> tabtype;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tabdoc.setCellValueFactory(new PropertyValueFactory<Clients, String>("document"));
        tabfio.setCellValueFactory(new PropertyValueFactory<Clients, String>("fio"));
        tabid.setCellValueFactory(new PropertyValueFactory<Clients, String>("id"));
        tabinn.setCellValueFactory(new PropertyValueFactory<Clients, String>("inn"));
        taborgan.setCellValueFactory(new PropertyValueFactory<Clients, String>("organ"));
        tabsernum.setCellValueFactory(new PropertyValueFactory<Clients, String>("sernum"));
        tabshifer.setCellValueFactory(new PropertyValueFactory<Clients, String>("shifer"));
        tabtype.setCellValueFactory(new PropertyValueFactory<Clients, String>("type"));

        tabclients.setItems(FXCollections.observableList(CliArray));
    }
}
