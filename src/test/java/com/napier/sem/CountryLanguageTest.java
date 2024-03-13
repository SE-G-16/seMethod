package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.net.UnknownHostException;

import static org.junit.jupiter.api.Assertions.*;

public class CountryLanguageTest {

    @BeforeAll
    static void init() throws UnknownHostException {
        App.connect(App.LocationLocalhostStr, 3000);
    }

    @Test
    public void testGetCity() {

        if(App.con == null)
        {
            return;
        }

        // Test getCity method with a known city ID
        City city = App.s.getCity(3793);

        if(city != null) {
            assertEquals("City: New York 8008278", App.s.getCity(city.id).toString());
            assertEquals("Country: United States  Pop: 278357000", App.s.getCountry(city.country_code).toString());
        }

        // Add more assertions for other attributes
    }

    @Test
    public void testGetCountry() {

        if(App.con == null)
        {
            return;
        }

        // Test getCountry method with a known country code
        Country country = App.s.getCountry("USA");

        if(country != null) {
            assertEquals("United States", country.name);
            assertEquals("North America", country.continent);

        }


        // Add more assertions for other attributes
    }

    @Test
    public void testGetCountryOfficialLanguage() {

        if(App.con == null)
        {
            return;
        }

        // Test getCountryOfficialLanguage method with a known country code
        CountryLanguage language = App.s.getCountryOfficialLanguage("USA");

        if(language != null)
        {
            assertEquals("English", language.language);
            assertEquals(language.is_official, "T");

        }
        // Add more assertions for other attributes
    }

    @Test
    public void testGetCountryLanguage()
    {
        if(App.con == null)
        {
            return;
        }

        CountryLanguage cl = App.s.getCountryLanguage("GBR");

        if(cl != null)
        {
           //System.out.println(cl.country_code + " " + cl.language + " " + cl.percentage);
           assertEquals("GBR", cl.country_code);
           assertEquals("English", cl.language);
           assertEquals(97.3, cl.percentage);
           assertEquals("T", cl.is_official);

        }

    }

    // Add more test methods for other functionalities.

}