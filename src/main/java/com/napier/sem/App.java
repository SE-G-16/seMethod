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

        //------//

        // message to look prettier and tell of incoming query
        System.out.println("Running a query on the country class (ESP)...");

        // Get Country // test cuba 3 letter string //
        // GBR = UK, FRA = france, ESP = spain, USA = america
        Country cnt = a.getCountry("DEU");

        // Display country
        a.displayCountry(cnt);


        //-----//


        // message to look prettier and tell of incoming query
        System.out.println("Running a query on the city class (madrid=653)...");

        // Get City // capital of america
        City cty = a.getCity(3068);

        // Display city results
        a.displayCity(cty);


        //-----//


        // message to look prettier and tell of incoming query
        System.out.println("Running a query on the country language...");

        // Get language // america
        CountryLanguage cLang = a.getCountryOfficialLanguage("DEU");

        // display country languages
        a.displayCountryLanguage(cLang);


        //------//

        // message to look prettier and tell of incoming query
        System.out.println("Running a query on all countries...");

        // get all countries by size
        ArrayList<Country> countries = a.GetAllCountriesByPopulation();

        // show all countries by size
        a.displayAllCountiresBySize(countries);

        //-----//


        // Disconnect from database
        a.disconnect();


    }
}
