package com.napier.sem;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.Arrays;

import static java.net.InetAddress.getLocalHost;

/**
 * Main Entry point for Entry Point
 */
public class App {

    public static App a;

    public static Connection con = null;
    public static SqlApp s = new SqlApp();

    public static String LocationDBStr = "db:3306";
    public static String LocationLocalhostStr = "localhost:3306";


    // a custom print method with a string return for testing System.out.print
    // this was to improve code coverage
    public static StringBuilder print(String _args)
    {
        StringBuilder _string = new StringBuilder();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        PrintStream old = System.out;

        System.setOut(ps);

        if(_args != null)
        {
            _string = new StringBuilder(String.valueOf(_args));

            System.out.print(_string);
            System.out.flush();
            System.setOut(old);

            System.out.println(baos.toString());
            return new StringBuilder(baos.toString());
        }

        return _string;
    }


    public static void connect(String location, int delay) throws UnknownHostException {

        System.out.println("HOSTNAME: " + getLocalHost(). getHostName());

        try {
            // Load Database driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Could not load SQL driver");
            System.exit(-1);
        }

        int retries = 10;
        for (int i = 0; i < retries; ++i) {
            System.out.println("Connecting to database..." + location);
            try {
                // Wait a bit for db to start
                Thread.sleep(delay);
                // Connect to database

                con = DriverManager.getConnection("jdbc:mysql://" + location
                                + "/world?allowPublicKeyRetrieval=true&useSSL=false",
                        "root", "example");

                System.out.println("Successfully connected to " + location);
                break;
            } catch (SQLException sqle) {
                System.out.println("Connection is: " + con);
                System.out.println("Failed to connect to database attempt " + Integer.toString(i));
                System.out.println(sqle.getMessage());
            } catch (InterruptedException ie) {
                System.out.println("Thread interrupted? Should not happen.");
            }
        }
    }

    /**
     * This method disconnect the database connection
     */
    public static void disconnect()
    {
        // attempting to disconnect
        System.out.println("Attempting to disconnect from database...");

        if (con != null)
        {
            try
            {
                // Close connection
                con.close();

            }
            catch (Exception e)
            {
                System.out.println("Error closing connection to database");
            }
        }
    }

    // main entry point

    public static void main(String[] args) throws UnknownHostException {
        // Create new Application and connect to database
        //a = new App();

        print(String.valueOf("Args length: " + args.length + " /args/ " + Arrays.toString(args)));
        //System.out.println("Args length: " + args.length + " /args/ " + Arrays.toString(args));
        /*if(args.length < 1){
            // localhost:3306
            a.connect(LocationLocalhostStr, 0);

        }else{
            // db:3306
            a.connect(LocationDBStr, 3000);
        }*/

        connect(LocationDBStr, 3000);

        // get all countries in world by size  Query 1. 239 so 250 covers all for limit
        ArrayList<Object> allCountries;
        allCountries = s.GetQTypeByPopSize(QType.Country, Area.World, "", 250);

        // get all countries in a specific continent by size Query 2.
        ArrayList<Object> allCountriesInContinent;
        allCountriesInContinent = s.GetQTypeByPopSize(QType.Country, Area.Continent, "Europe", 20);

        // get all countries in a specific continent by size Query 3.
        ArrayList<Object> allCountriesInRegion;
        allCountriesInRegion = s.GetQTypeByPopSize(QType.Country, Area.Region, "Western Europe", 10);

        // Get all countries in the world where n is provided by user Query 4.
        ArrayList<Object> Query4;
        Query4 = s.GetQTypeByPopSize(QType.Country, Area.World, "", 15);

        //The top N populated countries in a continent where N is provided by the user Query 5.
        ArrayList<Object> Query5;
        Query5 = s.GetQTypeByPopSize(QType.Country, Area.Continent,"Asia",25);

        //The top N populated countries in a region where N is provided by the user Query 6.
        ArrayList<Object> Query6;
        Query6 = s.GetQTypeByPopSize(QType.Country, Area.Region,"Western Europe",5);

        //All the cities in the world organised by largest population to smallest Query 7.
        ArrayList<Object> Query7;
        Query7 = s.GetQTypeByPopSize(QType.City, Area.World, "", 100);

        // get all cities in a specific continent by size Query 8
        ArrayList<Object> Query8;
        Query8 = s.GetQTypeByPopSize(QType.City, Area.Continent, "Europe", 25);

        // get all cities in a specific continent by size Query 9
        ArrayList<Object> Query9;
        Query9 = s.GetQTypeByPopSize(QType.City, Area.Region, "Western Europe", 25);

        // get all cities in a specific continent by size Query 10
        ArrayList<Object> Query10;
        Query10 = s.GetQTypeByPopSize(QType.City, Area.Country, "Japan", 25);

        // get all cities in a specific continent by size Query 11
        ArrayList<Object> Query11;
        Query11 = s.GetQTypeByPopSize(QType.City, Area.District, "Yunnan", 25);

        // get all cities in a specific continent by size Query 12
        ArrayList<Object> Query12;
        Query12 = s.GetQTypeByPopSize(QType.City, Area.World, "", 25);

        // get all cities in a specific continent by size Query 13
        ArrayList<Object> Query13;
        Query13 = s.GetQTypeByPopSize(QType.City, Area.Continent, "Asia", 25);

        // get all cities in a specific continent by size Query 14
        ArrayList<Object> Query14;
        Query14 = s.GetQTypeByPopSize(QType.City, Area.Region, "Caribbean", 25);

        // get all cities in a specific continent by size Query 15
        ArrayList<Object> Query15;
        Query15 = s.GetQTypeByPopSize(QType.City, Area.Country, "France", 25);

        // get all cities in a specific continent by size Query16
        ArrayList<Object> Query16;
        Query16 = s.GetQTypeByPopSize(QType.City, Area.District, "New York", 25);

        // get all cities in a specific continent by size Query17
        ArrayList<Object> Query17;
        Query17 = s.GetQTypeByPopSize(QType.CapitalCities, Area.World, "", 25);

        // get all cities in a specific continent by size Query18
        ArrayList<Object> Query18;
        Query18 = s.GetQTypeByPopSize(QType.CapitalCities, Area.Continent, "Africa", 25);

        // get all cities in a specific continent by size Query19
        ArrayList<Object> Query19;
        Query19 = s.GetQTypeByPopSize(QType.CapitalCities, Area.Region, "North America", 25);

        // get all cities in a specific continent by size Query 20
        ArrayList<Object> Query20;
        Query20 = s.GetQTypeByPopSize(QType.CapitalCities, Area.World, "", 25);

        // get all cities in a specific continent by size Query 21
        ArrayList<Object> Query21;
        Query21 = s.GetQTypeByPopSize(QType.CapitalCities, Area.Continent, "Europe", 25);

        // get all cities in a specific continent by size Query 22
        ArrayList<Object> Query22;
        Query22 = s.GetQTypeByPopSize(QType.CapitalCities, Area.Region, "South America", 25);

        print("\n");

        print("\n\n(Query 1 - Country, World, LIMIT 300 ) Countries by Pop desc");
        s.displayObjects(allCountries);

        print("\n\n(Query2 - Country, Continent, Europe, LIMIT 20 ) Countries by Pop in a specific desc");
        s.displayObjects(allCountriesInContinent);

        print("\n\n(Query3 - Country, Region, Western Europe, LIMIT 10 ) Countries by Pop in a specific desc");
        s.displayObjects(allCountriesInRegion);

        print("\n\n(Query 4 - Country, World, LIMIT 15 ) Countries in the world by N");
        s.displayObjects(Query4);

        print("\n\n(Query 5 - Country, Continent, Asia, LIMIT 25 ) Countries in continent by N");
        s.displayObjects(Query5);

        print("\n\n(Query 6 - Country, Region, Western Europe, LIMIT 5) Countries in region by N");
        s.displayObjects(Query6);

        print("\n\n(Query 7 - City, World, LIMIT 100 ) Cities in the world organised by largest population to smallest");
        s.displayObjects(Query7);

        print("\n\n(Query8 - City, Continent, Europe, LIMIT 25) Cities by Pop desc");
        s.displayObjects(Query8);

        print("\n\n(Query9 - City, Region, Western Europe, LIMIT 25) Cities by Pop desc");
        s.displayObjects(Query9);

        print("\n\n(Query10 - City, Country, Japan, LIMIT 25) Cities by Pop desc");
        s.displayObjects(Query10);

        print("\n\n(Query11 - City, Country, Yunnan, LIMIT 25) Cities by Pop desc");
        s.displayObjects(Query11);

        print("\n\n(Query 12 - City, World, LIMIT 25 ) Cities in the world by N");
        s.displayObjects(Query12);

        print("\n\n(Query 13 - City, Continent, LIMIT 25 ) Cities in the world by N");
        s.displayObjects(Query13);

        print("\n\n(Query 14 - City, Region, LIMIT 25 ) Cities in the world by N");
        s.displayObjects(Query14);

        print("\n\n(Query 15 - City, Country, LIMIT 25 ) Cities in the world by N");
        s.displayObjects(Query15);

        print("\n\n(Query 16- City, District, LIMIT 25 ) Cities in the world by N");
        s.displayObjects(Query16);

        print("\n\n(Query 17 - CapitalCities , World, LIMIT 100 ) Capital Cities in the world organised by largest population to smallest");
        s.displayObjects(Query17);

        print("\n\n(Query 18- CapitalCities, Continent , LIMIT 100 ) Capital Cities in the  Continent organised by largest population to smallest");
        s.displayObjects(Query18);

        print("\n\n(Query 19 - CapitalCities, Region, LIMIT 100 ) Capital Cities in the Region organised by largest population to smallest");
        s.displayObjects(Query19);

        print("\n\n(Query 20 - CapitalCities, World, LIMIT 25 ) CapitalCities in the world by N");
        s.displayObjects(Query20);

        print("\n\n(Query 21 - CapitalCities, Continent, LIMIT 25 ) CapitalCities in the Continent by N");
        s.displayObjects(Query21);

        print("\n\n(Query 22 - CapitalCities, Region, LIMIT 25 ) CapitalCities in the Region by N");
        s.displayObjects(Query22);

        print("\n\n(Query 23 - Population Sizes, Continent,) population of people, people living in cities, and people not living in cities in each Continent");
        s.GetPopInVOutCity(Area.Continent , "Africa");

        print("\n\n(Query 24 - Population Sizes, Region, ) population of people, people living in cities, and people not living in cities in each Region");
        s.GetPopInVOutCity(Area.Region , "Southern Africa");

        print("\n\n(Query 25 - Population Sizes, Country,) population of people, people living in cities, and people not living in cities in each Country");
        s.GetPopInVOutCity(Area.Country , "France");

        // overall population reports
        print("\n Query 26 - Overall Population of World \n");
        s.GetOverallPopulationByArea(Area.World, "");

        print("\n Query 27 - Overall Population of continent \n");
        s.GetOverallPopulationByArea(Area.Continent, "Europe");

        print("\n Query 28 - Overall Population by Region \n");
        s.GetOverallPopulationByArea(Area.Region, "Southern Africa");

        print("\n Query 29 - Overall Population by country  \n");
        s.GetOverallPopulationByArea(Area.Country, "France");

        print("\n Query 30 - Overall Population by district  \n");
        s.GetOverallPopulationByAreaForDistrictCity(Area.District, "New York");

        print("\n Query 31 - Overall Population by city  \n");
        s.GetOverallPopulationByAreaForDistrictCity(Area.City, "Paris");

        // overall languages reports
        print("\n Languages Report: \n");

        print("\n Query 32 -  how many people in the world population speak Chinese \n");
        s.GetPopulationByLanguageSpoken("Chinese");

        print("\n Query 33 -  how many people in the world population speak English \n");
        s.GetPopulationByLanguageSpoken("English");

        print("\n Query 34 -  how many people in the world population speak Hindi \n");
        s.GetPopulationByLanguageSpoken("Hindi");

        print("\n Query 35 -  how many people in the world population speak Spanish \n");
        s.GetPopulationByLanguageSpoken("Spanish");

        print("\n Query 36 -  how many people in the world population speak Arabic \n");
        s.GetPopulationByLanguageSpoken("Arabic");

        // country report
        print("\n Query 37 - Country Report:\n");
        Country australia = s.getCountry("AUS");
        s.displayCountry(australia);


        // city report
        print("\n Query 38 - City Report:\n");
        City kabul = s.getCity(1);
        s.displayCity(kabul);


        // capital report
        print("\n Query 39 - Capital Report:\n");
        City Delhi = s.getCity(1109);
        s.displayCity(Delhi);

        /*print("\n QUERYTESTER - This is to verify statement for wrong use of parameters \n");
        s.GetOverallPopulationByArea(Area.City, "");
        s.GetOverallPopulationByArea(Area.District, "");
        s.GetOverallPopulationByAreaForDistrictCity(Area.World, "");
        s.GetOverallPopulationByAreaForDistrictCity(Area.Continent, "");
        s.GetOverallPopulationByAreaForDistrictCity(Area.Region, "");
        s.GetOverallPopulationByAreaForDistrictCity(Area.Country, "");*/


        // Disconnect from database
        disconnect();

    } // main end


}
