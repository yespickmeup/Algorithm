/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.json;

import java.util.List;

/**
 *
 * @author Guinness
 */
public class Country {

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

}
