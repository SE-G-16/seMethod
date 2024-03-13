package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.net.UnknownHostException;

import static org.junit.jupiter.api.Assertions.*;
class CityTest {

    @BeforeAll
    static void init() throws UnknownHostException {
        App.connect(App.LocationLocalhostStr, 3000);
    }

    @Test
    void testGetCity()
    {
        if(App.con == null)
        {
            return;
        }

        City city = App.s.getCity(3602);

        if(city != null)
        {

            assertEquals(city.id, 3602);
            assertEquals(city.name, "Vladivostok");
            assertEquals(city.country_code, "RUS");
            assertEquals(city.district, "Primorje");
            assertEquals(city.population, 606200);

        }
        else
        {
            System.out.println("city is null");
        }


    }


  
}