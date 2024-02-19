package com.napier.sem;

import java.sql.*;

public class SqlApp
{

    /**
     * Connection to MySQL database.
     */
    private Connection con = null;

    /**
     * Connect to the MySQL database.
     */
    public void connect()
    {
        // attempting to connect
        System.out.println("Attempting to connect to database...");
        try
        {
            // Load Database driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Could not load SQL driver");
            System.exit(-1);
        }

        int retries = 10;
        for (int i = 0; i < retries; ++i)
        {
            System.out.println("Connecting to database...");
            try
            {
                // Wait a bit for db to start
                Thread.sleep(30000);
                // Connect to database
                con = DriverManager.getConnection("jdbc:mysql://db:3306/world?useSSL=false", "root", "example");
                System.out.println("Successfully connected");
                break;
            }
            catch (SQLException sqle)
            {
                System.out.println("Failed to connect to database attempt " + Integer.toString(i));
                System.out.println(sqle.getMessage());
            }
            catch (InterruptedException ie)
            {
                System.out.println("Thread interrupted? Should not happen.");
            }
        }
    }

    /**
     * Disconnect from the MySQL database.
     */
    public void disconnect()
    {
        // attempting to disconnect
        System.out.println("Attempting to disconnect to database...");
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

    public City getCity(int ID)
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT id, name, CountryCode, district, population "
                            + "FROM city "
                            + "WHERE id = " + ID;
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return new employee if valid.
            // Check one is returned
            if (rset.next())
            {
                City city = new City();
                city.id = rset.getInt("id");
                city.name = rset.getString("name");
                city.country_code = rset.getString("countrycode");
                city.district = rset.getString("district");
                city.population = rset.getInt("population");
                return city;
            }
            else
                return null;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get city details");
            return null;
        }
    }

    public void displayCity(City _city)
    {
        if (_city != null)
        {
            System.out.println(
                    "ID: " + _city.id + "\n" +
                            "Name: " + _city.name + "\n" +
                            "Code: " + _city.country_code + "\n" +
                            "District: " + _city.district + "\n" +
                            "Pop: " + _city.population + "\n"

                            );
        }
    }
}