package com.napier.sem;

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
        System.out.println("Running a query on the country class (USA)...");

        // Get Country // test cuba 3 letter string //
        // GBR = UK, FRA = france, ESP = spain, USA = america
        Country cnt = a.getCountry("USA");

        // Display country
        a.displayCountry(cnt);


        //-----//


        // message to look prettier and tell of incoming query
        System.out.println("Running a query on the city class (washington=3813)...");

        // Get City // capital of america
        City cty = a.getCity(3813);

        // Display city results
        a.displayCity(cty);


        //-----//


        // message to look prettier and tell of incoming query
        System.out.println("Running a query on the country language...");

        // Get language // america
        CountryLanguage cLang = a.getCountryOfficialLanguage("USA");

        // display country languages
        a.displayCountryLanguage(cLang);


        //------//


        // Disconnect from database
        a.disconnect();


    }
}
