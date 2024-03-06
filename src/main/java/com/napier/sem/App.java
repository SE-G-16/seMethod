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

        // get all countries in world by size  Query 1.
        ArrayList<Object> allCountries = s.GetQTypeByPopSize(QType.Country, Area.World, "", 300);

        // get all countries in a specific continent by size Query 2.
        ArrayList<Object> allCountriesInContinent = s.GetQTypeByPopSize(QType.Country, Area.Continent, "Europe", 20);

        // get all countries in a specific continent by size Query 3.
        ArrayList<Object> allCountriesInRegion = s.GetQTypeByPopSize(QType.Country, Area.Region, "Western Europe", 10);

        // Get all countries in the world where n is provided by user Query 4.
        ArrayList<Object> Query4 = s.GetQTypeByPopSize(QType.Country, Area.World, "", 10);

        //The top N populated countries in a continent where N is provided by the user Query 5.
        ArrayList<Object> Query5 = s.GetQTypeByPopSize(QType.Country, Area.Continent,"Europe",25);

        //The top N populated countries in a region where N is provided by the user Query 6.
        ArrayList<Object> Query6 = s.GetQTypeByPopSize(QType.Country, Area.Region,"Western Europe",5);

        //All the cities in the world organised by largest population to smallest Query 7.
        ArrayList<Object> Query7 = s.GetQTypeByPopSize(QType.City, Area.World, "", 15);

        // get all cities in a specific continent by size Query 8
        ArrayList<Object> Query8 = s.GetQTypeByPopSize(QType.City, Area.Continent, "Europe", 15);

        // get all capitals in a specific continent by size Query 10
        ArrayList<Object> allCapitals = s.GetQTypeByPopSize(QType.CapitalCities, Area.World, "", 15);

        // get all capitals in a specific continent by size and by a specific continent Query 20
        ArrayList<Object> euroCapitals = s.GetQTypeByPopSize(QType.CapitalCities, Area.Continent, "Europe", 15);

        // get all capitals in a specific continent by size and by a specific region Query 22
        ArrayList<Object> westEuroCapitals = s.GetQTypeByPopSize(QType.CapitalCities, Area.Region, "Western Europe", 15);



        System.out.println("\n(Query 1)Countries by Pop desc\n");
        s.displayObjects(allCountries);

        System.out.println("\n(Query2)Countries by Pop in a specific desc\n");
        s.displayObjects(allCountriesInContinent);

        System.out.println("\n(Query3)Countries by Pop in a specific desc\n");
        s.displayObjects(allCountriesInRegion);

        System.out.println("\n(Query 4)Countries in the world by N\n");
        s.displayObjects(Query4);

        System.out.println("\n(Query 5)Countries in continent by N\n");
        s.displayObjects(Query5);

        System.out.println("\n(Query 6)Countries in region by N\n");
        s.displayObjects(Query6);

        System.out.println("\n(Query 7)cities in the world organised by largest population to smallest\n");
        s.displayObjects(Query7);

        System.out.println("\n(Query8)Cities by Pop desc\n");
        s.displayObjects(Query8);

        System.out.println("\nCapitals by Pop desc\n");
        s.displayObjects(allCapitals);

        System.out.println("\nCapitals by Pop desc in europe\n");
        s.displayObjects(euroCapitals);

        System.out.println("\nCapitals by Pop desc in western europe region\n");
        s.displayObjects(westEuroCapitals);


        // Disconnect from database
        disconnect();

    }




}
