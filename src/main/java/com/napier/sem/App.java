package com.napier.sem;

import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.Arrays;

import static java.net.InetAddress.getLocalHost;

public class App {

    public static App a;

    public static Connection con = null;
    public static SqlApp s = new SqlApp();

    public static String LocationDBStr = "db:3306";
    public static String LocationLocalhostStr = "localhost:3306";

    public void connect(String location, int delay) throws UnknownHostException {

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
        a = new App();

        System.out.println("Args length: " + args.length + " /args/ " + Arrays.toString(args));
        /*if(args.length < 1){
            // localhost:3306
            a.connect(LocationLocalhostStr, 0);

        }else{
            // db:3306
            a.connect(LocationDBStr, 3000);
        }*/

        a.connect(LocationDBStr, 3000);

        // get all countries in world by size  Query 1. 239 so 250 covers all for limit
        ArrayList<Object> allCountries = s.GetQTypeByPopSize(QType.Country, Area.World, "", 250);

        // get all countries in a specific continent by size Query 2.
        ArrayList<Object> allCountriesInContinent = s.GetQTypeByPopSize(QType.Country, Area.Continent, "Europe", 20);

        // get all countries in a specific continent by size Query 3.
        ArrayList<Object> allCountriesInRegion = s.GetQTypeByPopSize(QType.Country, Area.Region, "Western Europe", 10);

        // Get all countries in the world where n is provided by user Query 4.
        ArrayList<Object> Query4 = s.GetQTypeByPopSize(QType.Country, Area.World, "", 15);

        //The top N populated countries in a continent where N is provided by the user Query 5.
        ArrayList<Object> Query5 = s.GetQTypeByPopSize(QType.Country, Area.Continent,"Asia",25);

        //The top N populated countries in a region where N is provided by the user Query 6.
        ArrayList<Object> Query6 = s.GetQTypeByPopSize(QType.Country, Area.Region,"Western Europe",5);

        //All the cities in the world organised by largest population to smallest Query 7.
        ArrayList<Object> Query7 = s.GetQTypeByPopSize(QType.City, Area.World, "", 100);

        // get all cities in a specific continent by size Query 8
        ArrayList<Object> Query8 = s.GetQTypeByPopSize(QType.City, Area.Continent, "Europe", 25);

        // get all cities in a specific continent by size Query 9
        ArrayList<Object> Query9 = s.GetQTypeByPopSize(QType.City, Area.Region, "Western Europe", 25);

        // get all cities in a specific continent by size Query 10
        ArrayList<Object> Query10 = s.GetQTypeByPopSize(QType.City, Area.Country, "Japan", 25);

        // get all cities in a specific continent by size Query 11
        ArrayList<Object> Query11 = s.GetQTypeByPopSize(QType.City, Area.District, "Yunnan", 25);

        // get all cities in a specific continent by size Query 12
        ArrayList<Object> Query12 = s.GetQTypeByPopSize(QType.City, Area.World, "", 25);

        // get all cities in a specific continent by size Query 13
        ArrayList<Object> Query13 = s.GetQTypeByPopSize(QType.City, Area.Continent, "Asia", 25);

        // get all cities in a specific continent by size Query 14
        ArrayList<Object> Query14 = s.GetQTypeByPopSize(QType.City, Area.Region, "Caribbean", 25);

        // get all cities in a specific continent by size Query 15
        ArrayList<Object> Query15 = s.GetQTypeByPopSize(QType.City, Area.Country, "France", 25);

        // get all cities in a specific continent by size Query16
        ArrayList<Object> Query16 = s.GetQTypeByPopSize(QType.City, Area.District, "New York", 25);

        // get all cities in a specific continent by size Query17
        ArrayList<Object> Query17 = s.GetQTypeByPopSize(QType.CapitalCities, Area.World, "", 25);

        // get all cities in a specific continent by size Query18
        ArrayList<Object> Query18 = s.GetQTypeByPopSize(QType.CapitalCities, Area.Continent, "Africa", 25);

        // get all cities in a specific continent by size Query19
        ArrayList<Object> Query19 = s.GetQTypeByPopSize(QType.CapitalCities, Area.Region, "North America", 25);

        // get all cities in a specific continent by size Query 20
        ArrayList<Object> Query20 = s.GetQTypeByPopSize(QType.CapitalCities, Area.World, "", 25);

        // get all cities in a specific continent by size Query 21
        ArrayList<Object> Query21 = s.GetQTypeByPopSize(QType.CapitalCities, Area.Continent, "Europe", 25);

        // get all cities in a specific continent by size Query 22
        ArrayList<Object> Query22 = s.GetQTypeByPopSize(QType.CapitalCities, Area.Region, "South America", 25);



        //examples
        // get all capitals in a specific continent by size Query 10
        //ArrayList<Object> allCapitals = s.GetQTypeByPopSize(QType.CapitalCities, Area.World, "", 15);

        // get all capitals in a specific continent by size and by a specific continent Query 20
        //ArrayList<Object> euroCapitals = s.GetQTypeByPopSize(QType.CapitalCities, Area.Continent, "Europe", 15);

        // get all capitals in a specific continent by size and by a specific region Query 22
        //ArrayList<Object> westEuroCapitals = s.GetQTypeByPopSize(QType.CapitalCities, Area.Region, "Western Europe", 15);



        System.out.println("\n\n(Query 1 - Country, World, LIMIT 300 ) Countries by Pop desc");
        s.displayObjects(allCountries);

        System.out.println("\n\n(Query2 - Country, Continent, Europe, LIMIT 20 ) Countries by Pop in a specific desc");
        s.displayObjects(allCountriesInContinent);

        System.out.println("\n\n(Query3 - Country, Region, Western Europe, LIMIT 10 ) Countries by Pop in a specific desc");
        s.displayObjects(allCountriesInRegion);

        System.out.println("\n\n(Query 4 - Country, World, LIMIT 15 ) Countries in the world by N");
        s.displayObjects(Query4);

        System.out.println("\n\n(Query 5 - Country, Continent, Asia, LIMIT 25 ) Countries in continent by N");
        s.displayObjects(Query5);

        System.out.println("\n\n(Query 6 - Country, Region, Western Europe, LIMIT 5) Countries in region by N");
        s.displayObjects(Query6);

        System.out.println("\n\n(Query 7 - City, World, LIMIT 100 ) Cities in the world organised by largest population to smallest");
        s.displayObjects(Query7);

        System.out.println("\n\n(Query8 - City, Continent, Europe, LIMIT 25) Cities by Pop desc");
        s.displayObjects(Query8);

        System.out.println("\n\n(Query9 - City, Region, Western Europe, LIMIT 25) Cities by Pop desc");
        s.displayObjects(Query9);

        System.out.println("\n\n(Query10 - City, Country, Japan, LIMIT 25) Cities by Pop desc");
        s.displayObjects(Query10);

        System.out.println("\n\n(Query11 - City, Country, Yunnan, LIMIT 25) Cities by Pop desc");
        s.displayObjects(Query11);

        System.out.println("\n\n(Query 12 - City, World, LIMIT 25 ) Cities in the world by N");
        s.displayObjects(Query12);

        System.out.println("\n\n(Query 13 - City, Continent, LIMIT 25 ) Cities in the world by N");
        s.displayObjects(Query13);

        System.out.println("\n\n(Query 14 - City, Region, LIMIT 25 ) Cities in the world by N");
        s.displayObjects(Query14);

        System.out.println("\n\n(Query 15 - City, Country, LIMIT 25 ) Cities in the world by N");
        s.displayObjects(Query15);


        System.out.println("\n\n(Query 16- City, District, LIMIT 25 ) Cities in the world by N");
        s.displayObjects(Query16);

        System.out.println("\n\n(Query 17 - CapitalCities , World, LIMIT 100 ) Capital Cities in the world organised by largest population to smallest");
        s.displayObjects(Query17);

        System.out.println("\n\n(Query 18- CapitalCities, Continent , LIMIT 100 ) Capital Cities in the  Continent organised by largest population to smallest");
        s.displayObjects(Query18);

        System.out.println("\n\n(Query 19 - CapitalCities, Region, LIMIT 100 ) Capital Cities in the Region organised by largest population to smallest");
        s.displayObjects(Query19);

        System.out.println("\n\n(Query 20 - CapitalCities, World, LIMIT 25 ) CapitalCities in the world by N");
        s.displayObjects(Query20);

        System.out.println("\n\n(Query 21 - CapitalCities, Continent, LIMIT 25 ) CapitalCities in the Continent by N");
        s.displayObjects(Query21);

        System.out.println("\n\n(Query 22 - CapitalCities, Region, LIMIT 25 ) CapitalCities in the Region by N");
        s.displayObjects(Query22);












        /*System.out.println("\nCapitals by Pop desc\n");
        s.displayObjects(allCapitals);

        System.out.println("\nCapitals by Pop desc in europe\n");
        s.displayObjects(euroCapitals);

        System.out.println("\nCapitals by Pop desc in western europe region\n");
        s.displayObjects(westEuroCapitals);*/


        // Disconnect from database
        disconnect();

    }




}
