package com.napier.sem;

import java.sql.*;
import java.util.ArrayList;

public class SqlApp
{
    //<editor-fold desc="connections methods>"

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

    //</editor-fold>

    //<editor-fold desc="city methods>"

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

    //</editor-fold>

    //<editor-fold desc="country methods>"

    // a method for retrieving the information from the selected country
    public Country getCountry(String _code)
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT code, name, continent, region, "
            + "surfacearea, indepYear, population, lifeexpectancy, "
            + "gnp, gnpold , localname, governmentform, "
            + "headofstate, capital, code2 "
                            + "FROM country "
                            //+ "WHERE code =  'CUB'";
                            + "WHERE code =  '" + _code + "'";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return new employee if valid.
            // Check one is returned
            if (rset.next())
            {
                Country country = new Country();
                country.code = rset.getString("code");
                country.name = rset.getString("name");
                country.continent = rset.getString("continent");
                country.region = rset.getString("region");
                country.surface_area = rset.getDouble("surfacearea");
                country.independence_year = rset.getShort("indepyear");
                country.population = rset.getInt("population");
                country.life_expectancy = rset.getDouble("lifeexpectancy");
                country.gnp = rset.getDouble("gnp");
                country.old_gnp = rset.getDouble("gnpold");
                country.local_name = rset.getString("localname");
                country.government_type = rset.getString("governmentform");
                country.head_of_state = rset.getString("headofstate");
                country.capital = rset.getInt("capital");
                country.code_two = rset.getString("code2");
                return country;
            }
            else
                return null;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country details");
            return null;
        }
    }

    // a method for displaying the country
    public void displayCountry(Country _country)
    {
        if (_country != null)
        {
            System.out.println(
                    "Code: " + _country.code + "\n" +
                            "Name: " + _country.name + "\n" +
                            "Continent: " + _country.continent + "\n" +
                            "Region: " + _country.region + "\n" +
                            "Surface Area: " + _country.surface_area + "\n" +
                            "Independence Year: " + _country.independence_year + "\n" +
                            "Population: " + _country.population + "\n" +
                            "Life Expectancy: " + _country.life_expectancy + "\n" +
                            "Gross Nation Product: " + _country.gnp + "\n" +
                            "Local Name : " + _country.local_name + "\n" +
                            "Government Type: " + _country.government_type + "\n" +
                            "Head of State: " + _country.head_of_state + "\n" +
                            "Capital: " + _country.capital + "\n" +
                            "Code 2:" + _country.code_two + "\n"

            );
        }
    }
    //</editor-fold>

    //<editor-fold desc="country language methods>"

    // a method for retrieving the information from the selected country language
    public CountryLanguage getCountryOfficialLanguage(String _code)
    {
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT  countrycode, language, isofficial, percentage "
                            + "FROM countrylanguage "
                            //+ "WHERE code =  'CUB'";
                            + "WHERE countrycode =  '" + _code + "'"
                            + " AND isofficial = 'T'";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return new employee if valid.
            // Check one is returned
            if (rset.next())
            {
                CountryLanguage countryLanguage = new CountryLanguage();
                countryLanguage.country_code = rset.getString("countrycode");
                countryLanguage.language = rset.getString("language");
                countryLanguage.is_official = rset.getString("isofficial");
                countryLanguage.percentage = rset.getDouble("percentage");

                return countryLanguage;
            }
            else
                return null;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country language details");
            return null;
        }
    }

    // a method for displaying the country language
    public void displayCountryLanguage(CountryLanguage _language)
    {
        if (_language != null)
        {
            System.out.println(
                    "Country Code: " + _language.country_code + "\n" +
                            "Language: " + _language.language + "\n" +
                            "Is Official language : " + _language.is_official + "\n" +
                            "Pecentage: " + _language.percentage + "\n"

            );
        }
    }


    //</editor-fold>

    public void displayObjects(ArrayList<Object> objlist) {
        System.out.println("\nsize of list: " + objlist.size() + "\n");

        for (Object i : objlist) {
            System.out.println(i.getClass().toString());
        }

    }



    public ArrayList<Object> GetAllByPopulation (String _input)
    {
        System.out.println(_input);
        try {
            ArrayList<Object> objects = new ArrayList<Object>();

            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT  * "
                            + "FROM country order by population desc ";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return new employee if valid.
            // Check one is returned
            while (rset.next()) {

                Object obj = new Object();
                //obj.code = rset.getString("code");
                //obj.name = rset.getString("name");
                //obj.population = rset.getInt("population");

                objects.add(obj);
            }
            return objects;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get " + _input + " details");
            return null;
        }
    }



    // continet population
    public ArrayList<Country> GetAllCountriesByPopulationByContinent (String _continent)
    {
        try {
            ArrayList<Country> countries = new ArrayList<Country>();

            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT  * "
                            + "FROM country "
                            + "WHERE continent = '" + _continent + "'"

                            + " order by population desc ";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return new employee if valid.
            // Check one is returned
            while (rset.next()) {

                Country country = new Country();
                country.code = rset.getString("code");
                country.name = rset.getString("name");
                country.population = rset.getInt("population");

                countries.add(country);
            }
            return countries;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country language details");
            return null;
        }
    }

    // continet population
    public ArrayList<Country> GetAllCountriesByPopulationByRegion (String _region)
    {
        try {
            ArrayList<Country> countries = new ArrayList<Country>();

            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT  * "
                            + "FROM country "
                            + "WHERE region = '" + _region + "'"

                            + " order by population desc ";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);
            // Return new employee if valid.
            // Check one is returned
            while (rset.next()) {

                Country country = new Country();
                country.code = rset.getString("code");
                country.name = rset.getString("name");
                country.population = rset.getInt("population");

                countries.add(country);
            }
            return countries;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country language details");
            return null;
        }
    }



}