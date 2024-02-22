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


        // get all countries in world by size
        ArrayList<Object> allCountries = a.GetQTypeByPopSize(QType.Country, Area.World, "", 10);
        // get all countries in a specific continent by size
        ArrayList<Object> allCountriesInContinent = a.GetQTypeByPopSize(QType.Country, Area.Continent, "Europe", 20);
        // get all countries in a specific continent by size
        ArrayList<Object> allCountriesInRegion = a.GetQTypeByPopSize(QType.Country, Area.Region, "Western Europe", 10);
        // get all cities in a specific continent by size
        ArrayList<Object> allCities = a.GetQTypeByPopSize(QType.City, Area.World, "", 15);
        // get all capitals in a specific continent by size
        ArrayList<Object> allCapitals = a.GetQTypeByPopSize(QType.CapitalCities, Area.World, "", 15);
        // get all capitals in a specific continent by size and by a specific continent
        ArrayList<Object> euroCapitals = a.GetQTypeByPopSize(QType.CapitalCities, Area.Continent, "Europe", 15);
        // get all capitals in a specific continent by size and by a specific region
        ArrayList<Object> westEuroCapitals = a.GetQTypeByPopSize(QType.CapitalCities, Area.Region, "Western Europe", 15);

        System.out.println("\nCountries by Pop desc\n");
        a.displayObjects(allCountries);

        System.out.println("\nCountries by Pop in a specific desc\n");
        a.displayObjects(allCountriesInContinent);

        System.out.println("\nCountries by Pop in a specific desc\n");
        a.displayObjects(allCountriesInRegion);

        System.out.println("\nCities by Pop desc\n");
        a.displayObjects(allCities);

        System.out.println("\nCapitals by Pop desc\n");
        a.displayObjects(allCapitals);

        System.out.println("\nCapitals by Pop desc in europe\n");
        a.displayObjects(euroCapitals);

        System.out.println("\nCapitals by Pop desc in western europe region\n");
        a.displayObjects(westEuroCapitals);


        // Disconnect from database
        a.disconnect();


    }
}
