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




        //ArrayList<Object> allCities = a.GetQTypeByPopSize(QType.City, Area.World, "", 0);
        //ArrayList<Object> allCapitals = a.GetQTypeByPopSize(QType.CapitalCities, Area.World, "", 0);

        System.out.println("\nCountries by Pop desc\n");
        a.displayObjects(allCountries);

        System.out.println("\nCountries by Pop in a specific desc\n");
        a.displayObjects(allCountriesInContinent);

        System.out.println("\nCountries by Pop in a specific desc\n");
        a.displayObjects(allCountriesInRegion);



        System.out.println("\nCities by Pop desc\n");
        //a.displayObjects(allCities);

        System.out.println("\n\nCapitals by Pop desc\n\n");
        //a.displayObjects(allCapitals);


        // Disconnect from database
        a.disconnect();


    }
}
