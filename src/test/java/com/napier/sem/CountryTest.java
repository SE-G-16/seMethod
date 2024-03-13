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
    @Test
    void testDisplayCountry() {
        Country cou = App.s.getCountry("CAN");


        if (cou != null) {

            App.s.displayCountry(cou);
            assertEquals(cou.name, "Canada");
            assertEquals(cou.continent, "North America");
            assertEquals(cou.region, "North America");
            assertEquals(cou.surface_area.doubleValue(), 9970610.0);
            assertEquals(cou.independence_year.intValue(), 1867);
            assertEquals(cou.population, 31147000);
            assertEquals(cou.life_expectancy.doubleValue(), 79.4);
            assertEquals(cou.gnp.doubleValue(), 598862.0);
            assertEquals(cou.local_name, "Canada");
            assertEquals(cou.government_type, "Constitutional Monarchy, Federation");
            assertEquals(cou.head_of_state, "Elisabeth II");
            assertEquals(cou.capital, 1822);
            assertEquals(cou.code_two, "CA");
        }
    }

    @Test
    void testGetString()
    {
        Country mex = App.s.getCountry("MEX");
        if(mex != null)
        {
            assertEquals(mex.toString(), "Country: Mexico  Pop: 98881000");
        }

    }


}