package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.sql.ResultSet;
import java.sql.Statement;


import java.net.UnknownHostException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

// class for test purposes
class Dummy
{
    public String name;

    // constructor
    Dummy(String _name)
    {
        name = _name;

    }

    @Override
    public String toString() {
        return name.toString();
    }
}


class SqlAppTest {



    static SqlApp s;


    @BeforeAll
    static void init() throws UnknownHostException {
        App.connect(App.LocationLocalhostStr, 3000);
    }

    /**
     * Test QType Enum
     */
    @Test
    protected void testQtypeEnum()
    {
        var qnum = QType.Country;
        assertEquals( qnum.toString(), "Country");
    }

    /**
     * Test for Area Enum
     */
    @Test
    protected void testAreaEnum()
    {
        var area = Area.Continent;
        assertEquals( area.toString(), "Continent");
    }

    /**
     * testGetCity
     */
    @Test
    protected void testGetCity()
    {
        s = new SqlApp();

        City city = s.getCity(455);

        if(city != null && App.con != null)
        {
            s.displayCity(city);

            assertEquals(city.name, "Águas Lindas de Goiás");
            assertEquals(city.country_code, "BRA");
            assertEquals(city.district, "Goiás");
            assertEquals(city.population, 89200);

        }
        else
        {
            System.out.println("city or app is null");
        }

    }

    /**
     * this is a test for a sql query if can run
     */
    @Test
    protected void sqlQuerytest()
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
                            + "WHERE isofficial = 'T'";

            //


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

                System.out.println(countryLanguage.country_code);

                assertEquals("Dutch", countryLanguage.language);
            }
            else
                System.out.println("else failed");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get country language details");

        }
    }


    /**
     * test get city
     */
    @Test
    public void getCity() {

        if(App.con == null)
        {
            return;
        }

        City city = App.s.getCity(1106);
        assertEquals(1106, city.id);
        assertEquals("New Bombay", city.name);
        assertEquals("IND", city.country_code);
        assertEquals(307297, city.population);
        assertEquals("Maharashtra", city.district);

    }

    /**
     * test display city method
     */
    @Test
    protected void displayCity() {

        if(App.con == null)
        {
            return;
        }

        City city = App.s.getCity(1106);

        String result = s.displayCity(city);
        String expected = "ID: 1106\nName: New Bombay\nCode: IND\nDistrict: Maharashtra\nPop: 307297\n";

        assertEquals(expected, result);

    }

    /**
     * test get country
     */
    @Test
    protected void getCountry() {
        if(App.con == null)
        {
            return;
        }

        Country country = App.s.getCountry("GBR");
        assertEquals("GBR", country.code);
        assertEquals("United Kingdom", country.name);
        assertEquals("Europe", country.continent);
        assertEquals("British Islands", country.region);
        assertEquals(242900.00, country.surface_area.doubleValue());
        assertEquals(59623400, country.population);
        assertEquals(77.7, country.life_expectancy.doubleValue());
        assertEquals(1378330.00, country.gnp.doubleValue());
        assertEquals(1296830.00, country.old_gnp.doubleValue());
        assertEquals("United Kingdom", country.local_name);
        assertEquals("Constitutional Monarchy", country.government_type);
        assertEquals("Elisabeth II", country.head_of_state);
        assertEquals(456, country.capital);
        assertEquals("GB", country.code_two);

    }

    /**
     * test display country
     */
    @Test
    protected void displayCountry() {

        if(App.con == null)
        {
            return;
        }

        Country country = App.s.getCountry("GBR");

        String returnStr = App.s.displayCountry(country);
        String expected = "Code: GBR\n" +
                "Name: United Kingdom\n" +
                "Continent: Europe\n" +
                "Region: British Islands\n" +
                "Surface Area: 242900.0\n" +
                "Independence Year: 1066\n" +
                "Population: 59623400\n" +
                "Life Expectancy: 77.7\n" +
                "Gross Nation Product: 1378330.0\n" +
                "Old Gross Nation Product: 1296830.0\n" +
                "Local Name: United Kingdom\n" +
                "Government Type: Constitutional Monarchy\n" +
                "Head of State: Elisabeth II\n" +
                "Capital: 456\n" +
                "Code 2: GB\n";

        assertEquals(expected, returnStr);


    }

    @Test
    void getCountryOfficialLanguage() {

    }

    @Test
    void getCountryLanguage() {

    }

    @Test
    void displayCountryLanguage() {

    }

    @Test
    void displayObjects() {
        ArrayList<Object> newList = new ArrayList<>();

        Object cat = new Dummy("Felix");
        Object dog = new Dummy("Snoopy");
        Object sheep = new Dummy("Dolly");

        newList.add(cat.toString());
        newList.add(dog.toString());
        newList.add(sheep.toString());

        String gh = String.valueOf(App.s.displayObjects(newList));

        //App.Print(gh);

        assertEquals("\nsize of list: 3\n\nFelix\nSnoopy\nDolly\n\n----------------------------------------------\n", gh);

    }

    @Test
    void getQTypeByPopSize() {
    }

    @Test
    void getPopInVOutCity() {
    }


}