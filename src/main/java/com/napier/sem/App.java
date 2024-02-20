package com.napier.sem;

public class App {

    // main entry point

    public static void main(String[] args)
    {
        // Create new Application
        SqlApp a = new SqlApp();

        // Connect to database
        a.connect();

        // message to look prettier and tell of incoming query
        System.out.println("Running a query on the city class...");

        // Get City
        City cty = a.getCity(1);

        // Display city results
        a.displayCity(cty);

        // Get Country // test cuba 3 letter string //
        // GBR = UK, FRA = france, ESP = spain, USA = america
        Country cnt = a.getCountry("USA");

        // Display country
        a.displayCountry(cnt);

        // Disconnect from database
        a.disconnect();


    }
}
