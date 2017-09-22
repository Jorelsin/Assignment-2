package Economy;

import java.text.DecimalFormat;

public class Country {
    private String name;
    private int population;
    private double GDP;
    private static final String END_LINE = System.lineSeparator();

    public Country(String name, int population, double GDP) {
        this.name = name;
        this.population = population;
        this.GDP = GDP;
    }

    @Override
    public String toString() {
        return  END_LINE+name+" <"+getClassification()+"> "+END_LINE+
                "Population: "+population+END_LINE+
                "GDP: " + new DecimalFormat("#").format(GDP)+ END_LINE+
                new DecimalFormat("#").format(getGDPCapita()) + " per capita!";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassification() {

        String classification = getGDPCapita() > 1000 ?
                (getGDPCapita() >= 10000 ? "Developed country" : "Economy in transition") : "Developing country";
        return classification;
    }

    public void setPopulation(int population) {
        if (population >= 0){
            this.population = population;
        }else{
            System.out.println("No negatives! Try again!");
        }
    }

    public void setGDP(double GDP) {
        this.GDP = GDP;
    }

    public double getGDPCapita() {
        return GDP/population;
    }

    }
