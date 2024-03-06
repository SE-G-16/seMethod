package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class CityTest {

    static App app;

    @BeforeAll
    static void init()
    {
        app = new App();
        app.connect(App.LocationLocalhostStr, 30000);

    }

    @Test
    void testGetCity()
    {
        City city = App.s.getCity(3602);
        assertEquals(city.name, "Vladivostok");
        assertEquals(city.country_code, "RUS");
        assertEquals(city.district, "Primorje");
        assertEquals(city.population, 606200);
    }
  
}