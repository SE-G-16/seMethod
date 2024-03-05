package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountryTest {

    static App app;

    @BeforeAll
    static void init()
    {
        app = new App();
        app.connect("localhost:3306", 30000);

    }

    @Test
    void testGetCountry()
    {
        Country country = app.s.getCountry("AND");
        assertEquals(country.code, "AND");
        assertEquals(country.name, "Andorra");
        assertEquals(country.continent, "Europe");
    }


}