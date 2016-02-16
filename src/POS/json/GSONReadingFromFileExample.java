/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.json;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author Guinness
 */
public class GSONReadingFromFileExample {

    public static void main(String[] args) {

        Gson gson = new Gson();
        try {
            System.out.println("Reading JSON from a file");
            System.out.println("----------------------------");
            String file = "{\"name\":\"India\",\"population\":1000000,\"listOfStates\":[\"Madhya Pradesh\",\"Maharastra\",\"Rajasthan\"]}";
            BufferedReader br = new BufferedReader(new FileReader("D:\\CountryGSON.json"));
            //convert the json string back to object  
            Country countryObj = gson.fromJson(file, Country.class);
            System.out.println("Name Of Country: " + countryObj.getName());
            System.out.println("Population: " + countryObj.getPopulation());
            System.out.println("States are :");
            List<String> listOfStates = countryObj.getListOfStates();
            for (int i = 0; i < listOfStates.size(); i++) {
                System.out.println(listOfStates.get(i));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
