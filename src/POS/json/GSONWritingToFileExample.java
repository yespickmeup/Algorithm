/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.json;

import com.google.gson.Gson;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Guinness
 */
public class GSONWritingToFileExample {

    public static void main(String[] args) {

        Country countryObj = new Country();
        countryObj.setName("India");
        countryObj.setPopulation(1000000);
        List<String> listOfStates = new ArrayList<String>();
        listOfStates.add("Madhya Pradesh");
        listOfStates.add("Maharastra");
        listOfStates.add("Rajasthan");
        countryObj.setListOfStates(listOfStates);
        Gson gson = new Gson();
        // convert java object to JSON format,  
        // and returned as JSON formatted string  
        String json = gson.toJson(countryObj);
        try {
            //write converted json data to a file named "CountryGSON.json"  
            FileWriter writer = new FileWriter("D:\\CountryGSON.json");
            writer.write(json);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        System.out.println(json);

    }

}
