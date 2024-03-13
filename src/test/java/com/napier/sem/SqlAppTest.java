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

    @Test
    void testQtypeEnum()
    {
        var qnum = QType.Country;
        assertEquals( qnum.toString(), "Country");
    }

    @Test
    void testAreaEnum()
    {
        var area = Area.Continent;
        assertEquals( area.toString(), "Continent");
    }

    @Test
    void testGetCity()
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

    @Test
    void sqlQuerytest()
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


    @Test
    void getCity() {

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

    @Test
    void displayCity() {

        if(App.con == null)
        {
            return;
        }

        City city = App.s.getCity(1106);

        String result = s.displayCity(city);

        assertEquals("ID: 1106\nName: New Bombay\nCode: IND\nDistrict: Maharashtra\nPop: 307297\n", result);

    }

    @Test
    void getCountry() {

    }

    @Test
    void displayCountry() {

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