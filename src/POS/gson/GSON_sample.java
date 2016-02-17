/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.gson;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Guinness
 */
public class GSON_sample {

    String name;
    int population;
    private List<String> listOfStates;

    //getter and setter methods  
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public List<String> getListOfStates() {
        return listOfStates;
    }

    public void setListOfStates(List<String> listOfStates) {
        this.listOfStates = listOfStates;
    }

    public static void main(String[] args) {
        write();
        read();
    }

    private static void write() {
        GSON_sample countryObj = new GSON_sample();
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

    private static void read() {
        Gson gson = new Gson();
        try {
            System.out.println("Reading JSON from a file");
            System.out.println("----------------------------");
            String file = "{\"name\":\"India\",\"population\":1000000,\"listOfStates\":[\"Madhya Pradesh\",\"Maharastra\",\"Rajasthan\"]}";
            BufferedReader br = new BufferedReader(new FileReader("D:\\CountryGSON.json"));
            //convert the json string back to object  
            GSON_sample countryObj = gson.fromJson(file, GSON_sample.class);
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
