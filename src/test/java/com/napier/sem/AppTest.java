package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.net.UnknownHostException;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    static App app;


    @BeforeAll
    static void init() throws UnknownHostException {

        app = new App();
        app.connect(App.LocationLocalhostStr, 3000);

    }


    /*@Test
    void testSystemOut()
    {
        System.out.println("hello");
        assertSame(System.in.toString(), "hello");

    }*/

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
    void testSqlApp()
    {
        assertNotEquals(app, null);
    }


    @Test
    void testGetCountry()
    {
        Country country = App.s.getCountry("AND");

        // null check
        if(country != null)
        {
            assertEquals(country.code, "AND");
            assertEquals(country.name, "Andorra");
            assertEquals(country.continent, "Europe");
        }
        else
        {
            System.out.println("country is null");
        }

        if(country != null)
        {
            System.out.println("\nAPP TEST: " + country.code + " / " + country.name + " / " + country.continent);
        }
    }

}