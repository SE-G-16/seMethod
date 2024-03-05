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


        // get all countries in world by size  Query 1.
        ArrayList<Object> allCountries = a.GetQTypeByPopSize(QType.Country, Area.World, "", 300);

        // get all countries in a specific continent by size Query 2.
        ArrayList<Object> allCountriesInContinent = a.GetQTypeByPopSize(QType.Country, Area.Continent, "Europe", 20);

        // get all countries in a specific continent by size Query 3.
        ArrayList<Object> allCountriesInRegion = a.GetQTypeByPopSize(QType.Country, Area.Region, "Western Europe", 10);

        // Get all countries in the world where n is provided by user Query 4.
        ArrayList<Object> Query4 = a.GetQTypeByPopSize(QType.Country, Area.World, "", 10);

        //The top N populated countries in a continent where N is provided by the user Query 5.
        ArrayList<Object> Query5 = a.GetQTypeByPopSize(QType.Country, Area.Continent,"Europe",25);

        //The top N populated countries in a region where N is provided by the user Query 6.
        ArrayList<Object> Query6 = a.GetQTypeByPopSize(QType.Country, Area.Region,"Western Europe",5);

        //All the cities in the world organised by largest population to smallest Query 7.
        ArrayList<Object> Query7 = a.GetQTypeByPopSize(QType.City, Area.World, "", 15);

        // get all cities in a specific continent by size Query 8
        ArrayList<Object> allCities = a.GetQTypeByPopSize(QType.City, Area.Continent, "Europe", 15);

        // get all capitals in a specific continent by size Query 10
        ArrayList<Object> allCapitals = a.GetQTypeByPopSize(QType.CapitalCities, Area.World, "", 15);
        // get all capitals in a specific continent by size and by a specific continent Query 20
        ArrayList<Object> euroCapitals = a.GetQTypeByPopSize(QType.CapitalCities, Area.Continent, "Europe", 15);
        // get all capitals in a specific continent by size and by a specific region Query 22
        ArrayList<Object> westEuroCapitals = a.GetQTypeByPopSize(QType.CapitalCities, Area.Region, "Western Europe", 15);



        System.out.println("\n(Query 1)Countries by Pop desc\n");
        a.displayObjects(allCountries);

        System.out.println("\n(Query2)Countries by Pop in a specific desc\n");
        a.displayObjects(allCountriesInContinent);

        System.out.println("\n(Query3)Countries by Pop in a specific desc\n");
        a.displayObjects(allCountriesInRegion);

        System.out.println("\n(Query 4)Countries in the world by N\n");
        a.displayObjects(Query4);

        System.out.println("\n(Query 5)Countries in continent by N\n");
        a.displayObjects(Query5);

        System.out.println("\n(Query 6)Countries in region by N\n");
        a.displayObjects(Query6);

        System.out.println("\n(Query 7)cities in the world organised by largest population to smallest\n");
        a.displayObjects(Query7);

        System.out.println("\n(Query8)Cities by Pop desc\n");
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
