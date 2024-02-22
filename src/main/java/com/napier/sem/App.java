package com.napier.sem;

import java.util.ArrayList;

public class App {



    // main entry point

    public static void main(String[] args)
    {
        // Create new Application
        SqlApp a = new SqlApp();

        // Connect to database
        a.connect();



        // message to look prettier and tell of incoming query
        //System.out.println("Running a query on the country class (ESP)...");

        // Get Country // test cuba 3 letter string //
        // GBR = UK, FRA = france, ESP = spain, USA = america
        //Country cnt = a.getCountry("DEU");


        // Get City // capital of america
        //City cty = a.getCity(3068);


        // Get language // america
        //CountryLanguage cLang = a.getCountryOfficialLanguage("DEU");




        // get all countries by size
        //ArrayList<Country> countries = a.GetAllCountriesByPopulation();

        // get all countries by size abd continent
        //ArrayList<Country> conCountries = a.GetAllCountriesByPopulationByContinent("Asia");

        // get all countries by size abd continent
        //ArrayList<Country> regCountries = a.GetAllCountriesByPopulationByRegion("British Islands");

        // get all countries by size
        ArrayList<Object> countries = a.GetQTypeByPopSize(QType.Country);
        ArrayList<Object> cities = a.GetQTypeByPopSize(QType.City);
        ArrayList<Object> capitals = a.GetQTypeByPopSize(QType.CapitalCities);

        System.out.println("\nCountries by Pop desc");
        a.displayObjects(countries);
        System.out.println("\nCities by Pop desc");
        a.displayObjects(cities);
        System.out.println("\nCapitals by Pop desc");
        a.displayObjects(capitals);


        //ArrayList<Object> cities = a.GetAllByPopulation("city");

        // show all countries by size



        // display country languages
        //a.displayCountryLanguage(cLang);

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
