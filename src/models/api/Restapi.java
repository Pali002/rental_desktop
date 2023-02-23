package models.api;

import java.util.ArrayList;
import java.util.Arrays;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import models.Pro;
import models.Cars;

public class Restapi {

    public Restapi() {
    }

    public String getProductsAsString() {
        Pro pro = new Pro();
                
        String host = pro.getProperty("restapi.host");
        String endpoint = "cars";
        String urlStr = host + endpoint;
        HttpClient http = new HttpClient();
        String res = http.get(urlStr);
        return res;
    }

    public ArrayList<Cars> getCars() {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        String text = getProductsAsString();
        
        Cars[] carsArray =  gson.fromJson(text, Cars[].class);
        ArrayList<Cars> carsList = 
            new ArrayList<>(Arrays.asList(carsArray));
        return carsList;
    }
}
