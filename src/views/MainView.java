package views;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import models.Cars;
import models.DataService;
import models.api.Restapi;

public class MainView extends VBox{

    Label carsLabel;
    DataService datasService;
    Restapi restapi;
    TableView<Cars> tableView;

    public MainView() {
        carsLabel = new Label("Autók");

        this.initData();
        this.initTable();
        this.getChildren().add(carsLabel);
        this.getChildren().add(tableView);
    }

    private void initTable() {
        tableView = new TableView<>();

        TableColumn<Cars, Integer> idCol = new TableColumn<>("Id");
        idCol.setMinWidth(50);
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<Cars, String> nameCol = new TableColumn<>("Név");
        nameCol.setMinWidth(50);
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Cars, String> brandCol = new TableColumn<>("Márka");
        brandCol.setMinWidth(50);
        brandCol.setCellValueFactory(new PropertyValueFactory<>("brand"));

        TableColumn<Cars, String> platenumberCol = new TableColumn<>("Rendszám");
        platenumberCol.setMinWidth(50);
        platenumberCol.setCellValueFactory(new PropertyValueFactory<>("platenumber"));

        TableColumn<Cars, Integer> quantityCol = new TableColumn<>("Mennyiség");
        quantityCol.setMinWidth(50);
        quantityCol.setCellValueFactory(new PropertyValueFactory<>("quantity"));

        TableColumn<Cars, Integer> spaceCol = new TableColumn<>("Férőhely");
        spaceCol.setMinWidth(50);
        spaceCol.setCellValueFactory(new PropertyValueFactory<>("space"));

        TableColumn<Cars, String> gearboxCol = new TableColumn<>("Váltó");
        gearboxCol.setMinWidth(50);
        gearboxCol.setCellValueFactory(new PropertyValueFactory<>("gearbox"));

        TableColumn<Cars, Double> priceCol = new TableColumn<>("Ár");
        priceCol.setMinWidth(50);
        priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
        
        tableView.setItems(this.getCars());

        tableView.getColumns().add(idCol);
        tableView.getColumns().add(nameCol);
        tableView.getColumns().add(brandCol);
        tableView.getColumns().add(platenumberCol);
        tableView.getColumns().add(quantityCol);
        tableView.getColumns().add(spaceCol);
        tableView.getColumns().add(gearboxCol);
        tableView.getColumns().add(priceCol);
    }

    private ObservableList<Cars> getCars() {
        ObservableList<Cars> carsList = FXCollections.observableArrayList(restapi.getCars());
        return carsList; 
    }

    private void initData() {
        this.restapi = new Restapi();
    }
}
