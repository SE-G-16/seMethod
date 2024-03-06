package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.net.UnknownHostException;

import static org.junit.jupiter.api.Assertions.*;

class CountryTest {

    static App app = new App();

    @BeforeAll
    static void init() throws UnknownHostException {
        app.connect(App.LocationLocalhostStr, 3000);
    }

    @Test
    void testGetCountry()
    {
        Country country = App.s.getCountry("AND");

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


    }


}