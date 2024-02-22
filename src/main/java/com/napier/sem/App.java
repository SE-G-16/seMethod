package com.napier.sem;

import java.util.ArrayList;

public class App {


    // Method to print an object without using toString()
    static void printObject(Object obj) {
        System.out.println("MyClass{name='" + obj + "'}");
    }

    // main entry point

    public static void main(String[] args)
    {
        // Create new Application
        SqlApp a = new SqlApp();

        // Connect to database
        a.connect();

        //------//

        // message to look prettier and tell of incoming query
        //System.out.println("Running a query on the country class (ESP)...");

        // Get Country // test cuba 3 letter string //
        // GBR = UK, FRA = france, ESP = spain, USA = america
        //Country cnt = a.getCountry("DEU");




        //-----//


        // message to look prettier and tell of incoming query
        //System.out.println("Running a query on the city class (madrid=653)...");

        // Get City // capital of america
        //City cty = a.getCity(3068);




        //-----//


        // message to look prettier and tell of incoming query
        //System.out.println("Running a query on the country language...");

        // Get language // america
        //CountryLanguage cLang = a.getCountryOfficialLanguage("DEU");

        // display country languages
        //a.displayCountryLanguage(cLang);


        //------//

        // message to look prettier and tell of incoming query
        System.out.println("Running a query on all countries...");

        // get all countries by size
        //ArrayList<Country> countries = a.GetAllCountriesByPopulation();



        //-----//

        // get all countries by size abd continent
        //ArrayList<Country> conCountries = a.GetAllCountriesByPopulationByContinent("Asia");

        // get all countries by size abd continent
        //ArrayList<Country> regCountries = a.GetAllCountriesByPopulationByRegion("British Islands");

        // get all countries by size
        ArrayList<Object> countries = a.GetAllByPopulation("country");
        printObject(countries);

        //ArrayList<Object> cities = a.GetAllByPopulation("city");

        // show all countries by size
        a.displayObjects(countries);
        //a.displayObjects(cities);

        // Display city results
        //a.displayCity(cty);
        // show all countries by size and continent
        //a.displayCountries(conCountries);
        // Display country
        //a.displayCountry(cnt);
        // show all countries by size and continent
        //a.displayCountry(regCountries);

        // Disconnect from database
        a.disconnect();


    }
}
