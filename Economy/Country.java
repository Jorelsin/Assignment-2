package Economy;

import java.text.DecimalFormat;

public class Country {
    private String name;
    private String classification;
    private int population;
    private double GDP;
    private double GDPCapita;

    public Country(String name, int population, double GDP) {

        this.name = name;
        this.population = population;
        this.GDP = GDP;
        updateValues();
    }

    @Override
    public String toString() {


        final String END_LINE = System.lineSeparator();
        String countryTag = END_LINE+this.name + " <"+this.classification+"> "+END_LINE;
        countryTag += "Population: " + this.population+END_LINE;
        countryTag += "GDP: " + new DecimalFormat("#").format(GDP)+ END_LINE;
        countryTag += new DecimalFormat("#").format(this.GDPCapita) + " per capita!";

        return countryTag;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassification() {
        return classification;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {

        if (population >= 0){
            this.population = population;
            updateValues();
        }else{
            System.out.println("No negatives! Try again!");
        }

    }

    public double getGDP() {
        return GDP;
    }

    public void setGDP(double GDP) {
        this.GDP = GDP;
        updateValues();
    }

    public double getGDPCapita() {
        return GDPCapita;
    }

    public void updateValues(){

        this.GDPCapita = GDP/population;
        this.classification = this.GDPCapita > 1000 ?
                (this.GDPCapita >= 10000 ? "Developed country" : "Economy in transition") : "Developing country";
    }

    }
