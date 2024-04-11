package com.napier.sem;

import java.sql.*;
import java.util.ArrayList;

enum QType {
    Country,
    City,
    CapitalCities
}

enum Area {
    World,
    Continent,
    Region,
    Country,

    District,


}



public class SqlApp
{
    //<editor-fold desc="connections methods>"


    /**
     * Connect to the MySQL database.
     */

    /*public void connect()  {



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

                App.con = DriverManager.getConnection("jdbc:mysql://db:3306/world?allowPublicKeyRetrieval=true&useSSL=false", "root", "example");
                System.out.println("Successfully connected");
                break;
            }
            catch (SQLException sqle)
            {
                System.out.println("Failed to connect to database attempt inside SQLAPP " + Integer.toString(i));
                System.out.println(sqle.getMessage());
            }
            catch (InterruptedException ie)
            {
                System.out.println("Thread interrupted? Should not happen.");
            }
        }
    }*/

    /**
     * Disconnect from the MySQL database.
     */
    /*public void disconnect()
    {
        // attempting to disconnect
        System.out.println("Attempting to disconnect to database...");
        if (App.con != null)
        {
            try
            {
                // Close connection
                App.con.close();
            }
            catch (Exception e)
            {
                System.out.println("Error closing connection to database");
            }
        }
    }
    */


    //</editor-fold>

    //////////////////////////////////////////////////////////////////////////

    //<editor-fold desc="city methods>"

    public City getCity(int ID)
    {
        try
        {
            // Create an SQL statement
            Statement stmt = App.con.createStatement();
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

    public String displayCity(City _city)
    {
        StringBuilder stb = new StringBuilder();

        if (_city != null)
        {
            System.out.println(
                    "ID: " + _city.id + "\n" +
                            "Name: " + _city.name + "\n" +
                            "Code: " + _city.country_code + "\n" +
                            "District: " + _city.district + "\n" +
                            "Pop: " + _city.population + "\n"

                            );

            stb.append("ID: ").append(_city.id).append("\n");
            stb.append("Name: ").append(_city.name).append("\n");
            stb.append("Code: ").append(_city.country_code).append("\n");
            stb.append("District: ").append(_city.district).append("\n");
            stb.append("Pop: ").append(_city.population).append("\n");

            return stb.toString();
        }
        return stb.toString();
    }

    //</editor-fold>

    //<editor-fold desc="country methods>"

    // a method for retrieving the information from the selected country
    public Country getCountry(String _code)
    {
        try
        {
            // Create an SQL statement
            Statement stmt = App.con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    /*"SELECT code, name, continent, region, "
            + "surfacearea, indepYear, population, lifeexpectancy, "
            + "gnp, gnpold , localname, governmentform, "
            + "headofstate, capital, code2 "*/

                            "SELECT * "

                            + "FROM country "
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
    public String displayCountry(Country _country)
    {
        StringBuilder stb = new StringBuilder();

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
                            "Old Gross Nation Product: " + _country.old_gnp + "\n" +
                            "Local Name: " + _country.local_name + "\n" +
                            "Government Type: " + _country.government_type + "\n" +
                            "Head of State: " + _country.head_of_state + "\n" +
                            "Capital: " + _country.capital + "\n" +
                            "Code 2: " + _country.code_two + "\n"

            );

            stb.append("Code: ").append(_country.code).append("\n");
            stb.append("Name: ").append(_country.name).append("\n");
            stb.append("Continent: ").append(_country.continent).append("\n");
            stb.append("Region: ").append(_country.region).append("\n");
            stb.append("Surface Area: ").append(_country.surface_area).append("\n");
            stb.append("Independence Year: ").append(_country.independence_year).append("\n");
            stb.append("Population: ").append(_country.population).append("\n");
            stb.append("Life Expectancy: ").append(_country.life_expectancy).append("\n");
            stb.append("Gross Nation Product: ").append(_country.gnp).append("\n");
            stb.append("Old Gross Nation Product: ").append(_country.old_gnp).append("\n");
            stb.append("Local Name: ").append(_country.local_name).append("\n");
            stb.append("Government Type: ").append(_country.government_type).append("\n");
            stb.append("Head of State: ").append(_country.head_of_state).append("\n");
            stb.append("Capital: ").append(_country.capital).append("\n");
            stb.append("Code 2: ").append(_country.code_two).append("\n");


            return stb.toString();
        }

        return stb.toString();
    }
    //</editor-fold>

    //<editor-fold desc="country language methods>"

    // a method for retrieving the information from the selected country language
    public CountryLanguage getCountryOfficialLanguage(String _code)
    {
        try
        {
            // Create an SQL statement
            Statement stmt = App.con.createStatement();
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

    // get country language
    public CountryLanguage getCountryLanguage(String _code)
    {
        try
        {
            // Create an SQL statement
            Statement stmt = App.con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT  countrycode, language, isofficial, percentage "
                            + "FROM countrylanguage "
                            //+ "WHERE code =  'CUB'";
                            + "WHERE countrycode =  '" + _code + "'";

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

    /**
     * @param _language
     */
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

    ///////////////////////////////////////////////////////////////////////////////////////

    // multi use display using tostring
    public StringBuilder displayObjects(ArrayList<Object> objList) {

        StringBuilder outPut = new StringBuilder();

        if(objList != null || objList.isEmpty())
        {
            outPut.append("\nsize of list: " + objList.size() + "\n\n");
            System.out.println("\nsize of list: " + objList.size() + "\n");

            for (Object i : objList) {
                outPut.append(i.toString() + "\n");
                System.out.println(i.toString());
            }

            outPut.append("\n----------------------------------------------\n");
            System.out.println("\n----------------------------------------------\n");

            return outPut;

        }
        else
        {
            System.out.println("\nObject list is empty!\n");
        }


        return outPut;
    }


    /**
     * @param _qtype
     * @param _area
     * @param areaStr
     * @param topAmt
     * @return
     */
    // Qtype = Country,City, CapitalCities
    // Area = World, Continent, Region, Country, District
    // areaStr = "Europe, Germany, etc"
    public ArrayList<Object> GetQTypeByPopSize (QType _qtype, Area _area, String areaStr, Integer topAmt)
    {
        //System.out.println("/ " + _qtype +" / " + _area + " / " + areaStr + " / " + topAmt);
        String _clmName = (_area == Area.Country) ? "country.name" : _area.toString();
        //System.out.println("column name passed: " + _clmName);

        String sqlArgs = "";

        switch (_area) {
            case World:
                sqlArgs = "";
                break;

            case Continent:
                sqlArgs = "where " + _clmName + " = '" + areaStr + "'";
                break;

            case Region:
                sqlArgs = "where " + _clmName + " = '" + areaStr + "'";
                break;

            case Country:

                sqlArgs = "where " + _clmName + " = '" + areaStr + "'";
                break;

            case District:
                sqlArgs = "where " + _clmName + " = '" + areaStr + "'";
                break;

            default:
                sqlArgs = "";
                break;
        }

        // adding a limit amount to a query
        String topArgs = "";
        if(topAmt != null)
        {
            topArgs = "LIMIT " + topAmt.toString();
        }

        // specify differnet types
        if(_qtype == QType.Country)
        {
            try {
                ArrayList<Country> countries = new ArrayList<>();

                // Create an SQL statement
                Statement stmt = App.con.createStatement();
                // Create string for SQL statement
                String strSelect =
                        "SELECT  * FROM country "

                            + sqlArgs
                            + " order by population desc "
                            + topArgs
                        ;
                System.out.println("SQL statement: " + strSelect);

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
                return new ArrayList<>(countries);
            }
            catch (Exception e)
            {
                System.out.println(e.getMessage());
                System.out.println("Failed to get " + _qtype + " details");
                return null;
            }
        }
        else if (_qtype == QType.City)
        {


            try {
                ArrayList<City> cities = new ArrayList<>();

                // Create an SQL statement
                Statement stmt = App.con.createStatement();
                // Create string for SQL statement
                String strSelect =
                        "SELECT  * FROM city left join country on city.ID = country.capital "

                                + sqlArgs
                                + " order by city.population desc "
                                + topArgs
                        ;

                System.out.println("SQL statement: " + strSelect);

                // Execute SQL statement
                ResultSet rset = stmt.executeQuery(strSelect);
                // Return new employee if valid.
                // Check one is returned
                while (rset.next()) {

                    City city = new City();
                    city.country_code = rset.getString("countrycode");
                    city.name = rset.getString("name");
                    city.population = rset.getInt("population");

                    cities.add(city);
                }
                return new ArrayList<>(cities);
            }
            catch (Exception e)
            {
                System.out.println(e.getMessage());
                System.out.println("Failed to get " + _qtype + " details");
                return null;
            }

        }
        else if (_qtype == QType.CapitalCities)
        {
            // tested query

            // SELECT city.id, city.name, city.Population AS `city population`, country.Population AS `country pop`
            //FROM country
            //LEFT JOIN city ON city.ID = country.Capital
            //
            //order BY city.Population DESC
            //LIMIT 10


            try {
                ArrayList<City> capitalCities = new ArrayList<>();

                // Create an SQL statement
                Statement stmt = App.con.createStatement();
                // Create string for SQL statement
                String strSelect =

                        "SELECT * FROM city Left Join country ON city.ID = country.Capital "
                                + sqlArgs
                                + " order by city.population desc "
                                + topArgs
                        ;

                System.out.println("SQL statement: " + strSelect);

                // Execute SQL statement
                ResultSet rset = stmt.executeQuery(strSelect);
                // Return new employee if valid.
                // Check one is returned
                while (rset.next()) {

                    City city = new City();
                    city.country_code = rset.getString("countrycode");
                    city.name = rset.getString("name");
                    city.population = rset.getInt("population");

                    capitalCities.add(city);
                }
                return new ArrayList<>(capitalCities);
            }
            catch (Exception e)
            {
                System.out.println(e.getMessage());
                System.out.println("Failed to get " + _qtype + " details");
                return null;
            }

        }
        else
        {
            System.out.println("Qtype invalid: " + _qtype );
            return null;
        }
    } // end of GetQTypeByPopSize

    /**
     * @param _area
     * @param _areaStr
     */
    public void GetPopInVOutCity(Area _area, String _areaStr)
    {
        Integer cityTotal = 0;
        Integer totalPopulation = 0;

        //System.out.println("/ " + _qtype +" / " + _area + " / " + areaStr + " / " + topAmt);
        String _clmName = (_area == Area.Country) ? "country.name" : _area.toString();

        //System.out.println("column name passed: " + _clmName);

        String sqlArgs = "";

        switch (_area) {
            case World:
                sqlArgs = "";
                break;

            case Continent:
                sqlArgs = "where " + _clmName + " = '" + _areaStr + "'";
                break;

            case Region:
                sqlArgs = "where " + _clmName + " = '" + _areaStr + "'";
                break;

            case Country:

                sqlArgs = "where " + _clmName + " = '" + _areaStr + "'";
                break;

            case District:
                sqlArgs = "where " + _clmName + " = '" + _areaStr + "'";
                break;

            default:
                sqlArgs = "";
                break;
        }

        // get population of just cities
        try {
            // Create an SQL statement
            Statement stmt = App.con.createStatement();
            // Create string for SQL statement
            String cityPopSelect =
                    "SELECT sum(city.Population) as cityPop " +
                            " FROM country " +
                            " LEFT JOIN city ON country.Code = city.CountryCode " +
                            sqlArgs +

                            " GROUP BY country.code, city.Population " +
                            ""

                    //+ sqlArgs
                    //+ topArgs
                    ;

            System.out.println("SQL statement: " + cityPopSelect);

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(cityPopSelect);
            // Return new employee if valid.
            // Check one is returned
            while (rset.next()) {

                cityTotal += rset.getInt("cityPop");
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            //System.out.println("Failed to get " + _qtype + " details");
        }

        // get total population
        try {
            // Create an SQL statement
            Statement stmt = App.con.createStatement();
            // Create string for SQL statement
            String countryPopByArea =
                    "SELECT country.Population as totalPop, country.name, country.Continent " +
                            " FROM country " +
                            " LEFT JOIN city ON country.Code = city.CountryCode " +
                            sqlArgs +
                            " GROUP BY country.name, totalPop, country.Continent ";

            //+ sqlArgs
            //+ topArgs
            ;

            System.out.println("SQL statement: " + countryPopByArea);

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(countryPopByArea);
            // Return new employee if valid.
            // Check one is returned
            while (rset.next()) {

                totalPopulation += rset.getInt("totalPop");
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            //System.out.println("Failed to get " + _qtype + " details");
        }

        var outSidePop = (totalPopulation - cityTotal);
        float inPerc = ((float) cityTotal / totalPopulation) * 100;
        float outPerc = ((float) outSidePop / totalPopulation) * 100;

        System.out.println(
                " \nCountry Code: " + _areaStr +
                " \nTotal Overall Population Amount : " + totalPopulation +
                " \nPopulation Living in the Cities : " + cityTotal +
                " \nPopulation Livign Outside Cities : " + (totalPopulation - cityTotal) +
                " \nPerecentage in cities : " + String.format("%.2f", inPerc) +
                " \nPercentage outside cities : "  + String.format("%.2f", outPerc)
        );

    } // end GetPopInVOutCity()

} // end SqlApp