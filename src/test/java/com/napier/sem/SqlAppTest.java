package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import java.net.UnknownHostException;

import static org.junit.jupiter.api.Assertions.*;

class SqlAppTest {


    static App app;
    static SqlApp s;


    @BeforeAll
    static void init() throws UnknownHostException {

        app = new App();
        app.connect(App.LocationLocalhostStr, 3000);


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

        if(city != null && app != null)
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

}