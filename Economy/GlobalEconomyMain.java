package Economy;

import java.util.Scanner;
//you may need to change the package to match your project's package.

public class GlobalEconomyMain {

    private static final int REGISTER_COUNTRY = 1;
    private static final int PRINT_COUNTRIES = 2;
    private static final int PRINT_COUNTRY = 3;
    private static final int INJECT_MONEY = 4;
    private static final int PAY_DEBT = 5;
    private static final int QUIT = 6;
    private static final int CHANGE_COUNTRY = 7;

    private Country[] countries;
    private int registeredCountries;
    private Scanner input;

    /*
     * Constructor to initialize your data set of countries.
     * It begins empty. The default size is 5 countries.
     */
    public GlobalEconomyMain() {
        final int MAX_COUNTRIES = 5;
        this.countries = new Country[MAX_COUNTRIES];
        this.registeredCountries = 0;
        input = new Scanner(System.in);
    }

    /*
     * This method will retrieve a country from the array based on a specified name.
     * If the country was not created and added to the array, it will return NULL,
     * meaning that the country does not exist in the system.
     *
     */
    public Country retrieveCountry(String countryName) {

        for (int i = 0; i < this.countries.length; i++) {
            //ask yourself, why do I check null first?
            if(countries[i] != null && countries[i].getName().equals(countryName)) {
                //I found the country, return it then.
                return countries[i];
            }
        }

        //example of a null... if no country
        //   with the give name exists, the
        //   object does not exist (i.e. "nothing").
        return null;
    }

    public Country createCountry() {

        Country newCountry;
        System.out.println("What is the name of the country?");
        String countryName = input.nextLine();

        System.out.println("How big is the population?");
        int countryPop = input.nextInt();
        input.nextLine();

        System.out.println("And how big is the GDP?");
        double countryGDP = input.nextDouble();
        input.nextLine();

        newCountry = new Country(countryName,countryPop,countryGDP);

        System.out.println("");
        System.out.println("Thank you!");
        return newCountry;
    }

    public void run() {

        int option;
        do {
            printMenuOptions();
            System.out.print(" Type the option number: ");

            option = input.nextInt();
            input.nextLine(); //this skips the enter
            //that the user types after
            //typing the integer option.

            switch (option) {
                case REGISTER_COUNTRY:

                    Country newCountry = createCountry();
                    this.countries[registeredCountries] = newCountry;
                    this.registeredCountries = this.registeredCountries + 1;

                    break;

                case PRINT_COUNTRIES:
                    printAllCountries();
                    break;

                case PRINT_COUNTRY:
                    printOneCountry();
                    break;

                case INJECT_MONEY:
                    injectMoney();
                    break;

                case PAY_DEBT:
                    payDebt();
                    break;

                case QUIT:
                    System.out.println("Thank you for using Global Economy Solutions. See you soon!");
                    System.out.println();
                    break;

                case CHANGE_COUNTRY:
                    editCountry();
                    break;

                default:
                    System.out.println("Option "+option+" is not valid.");
                    System.out.println();
                    break;
            }
        } while (option != QUIT);
    }

    //This method is private because it should be used only by
    // this class since the menu is specific to this main.
    private void printMenuOptions() {
        System.out.println(" === Welcome to Global Economy === ");
        System.out.println(" Choose an option below: ");
        System.out.println(" ");
        System.out.println(" 1. Register a country. ");
        System.out.println(" 2. Print all countries. ");
        System.out.println(" 3. Print a country's information. ");
        System.out.println(" 4. Inject money to a country. ");
        System.out.println(" 5. Pay a country's debt. ");
        System.out.println(" 6. Quit this program. ");
        System.out.println(" 7. Edit country information. ");
        System.out.println();
    }

    public void editCountry(){

        String countryName = readCountryName();
        Country foundCountry = retrieveCountry(countryName);

        if (foundCountry == null){
            System.out.println(" Error! "+countryName+" is not registered");
            return;
        }
        System.out.println(" ");
        System.out.println(" Choose an option below: ");
        System.out.println(" 1. Change the name of the country. ");
        System.out.println(" 2. Change the population of the country. ");
        System.out.println(" 3. Return to the previous menu. ");
        System.out.println(" ");

        int option = input.nextInt();
        input.nextLine();

        switch (option){

            case 1:
                System.out.println(" What´s the new name? ");
                String newName = input.nextLine();
                foundCountry.setName(newName);
                editCountry();
                break;
            case 2:
                System.out.println(" What´s the new population? ");
                int newPopulation = input.nextInt();
                foundCountry.setPopulation(newPopulation);
                editCountry();
                break;
            case 3:
                System.out.println("uuugh.... fine....");
                System.out.println("");
                printMenuOptions();
                break;
            default:
                System.out.println("Wrong input!");
                System.out.println("Try again!");
                editCountry();
                break;

            }

    }

    public void printAllCountries() {

        for (int i = 0; i < 5; i++) {
            if (countries[i] != null) {
                System.out.println("");
                System.out.println(countries[i]);

            } else {
                System.out.println("");
            }

        }
    }

    public void printOneCountry() {
        String countryName = readCountryName();

        Country foundCountry = retrieveCountry(countryName);

        if (foundCountry != null) {
            System.out.println(foundCountry);
            System.out.println("");
        }else{
            System.out.println(" ");
            System.out.println("Error: "+countryName+" is not registered.");
            System.out.println(" ");
        }

    }

    /*
     * This method only reads a String that here, will be the name
     * of a country that you want to use
     * (for printing, injecting money, paying debt, etc.)
     */
    public String readCountryName() {
        System.out.print("Type the name of the country that you want to use: ");
        String countryName = input.nextLine();
        return countryName;
    }

    public void injectMoney() {
        String countryName = readCountryName();
        Country foundCountry = retrieveCountry(countryName);

        //TODO: write code for the following logic:
        // 1. Read a double value for the amount to be injected.
        // 2. IF the country was really found, inject the money into it.
        // 3. Print the message: "<country_name> new GDP is <country_gdp>"
        // 4. Remember to not allow changing the GDP to negative values.
    }

    public void payDebt() {
        String countryName = readCountryName();
        Country foundCountry = retrieveCountry(countryName);

        //TODO: write code for the following logic:
        // 1. Read a double value for the amount to be paid.
        // 2. IF the country was really found, use the reference to pay the countrys' debt.
        // 3. Print the message: "<country_name> new GDP is <country_gdp>"
        // 4. Remember to not allow changing the GDP to negative values.
    }

    public static void main(String[] args)
    {
        GlobalEconomyMain program = new GlobalEconomyMain();
        program.run();
    }
}

