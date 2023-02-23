package models;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DataService {
    Database database;
    Connection con;
    
    public DataService(Database database) {
        this.database = database;
        con = this.database.connect();
    }

    public ArrayList<Cars> getCars() {
        ArrayList<Cars> carsList = null;
        try {
            carsList = tryGetCars();
        } catch (SQLException e) {
            System.err.println("Hiba! A termék lekérdezése sikertelen!");
        }
        return carsList;
    }

    public ArrayList<Cars> tryGetCars() throws SQLException {
        String sql = "select * from cars";
        Statement statement = this.con.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        ArrayList<Cars> carsList = new ArrayList<>();
        while(resultSet.next()) {
            Cars cars = new Cars();
            cars.id = resultSet.getInt("id");
            cars.name = resultSet.getString("name");
            cars.brand = resultSet.getString("brand");
            cars.platenumber = resultSet.getString("platenumber");
            cars.quantity = resultSet.getInt("quantity");
            cars.space = resultSet.getInt("space");
            cars.gearbox = resultSet.getString("gearbox");
            cars.price = resultSet.getDouble("price");
        }
        return carsList;
    }
}
