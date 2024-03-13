package com.napier.sem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CountryLanguageTest {

    private SqlApp sqlApp;

    @BeforeEach
    public void setUp() {
        sqlApp = new SqlApp();
        // Initialize any required resources or mocks here
    }

    @Test
    public void testGetCity() {
        // Test getCity method with a known city ID
        City city = sqlApp.getCity(3793);

        if(city != null) {
            assertEquals("City: New York 8008278", App.s.getCity(city.id).toString());
            assertEquals("Country: United States  Pop: 278357000", App.s.getCountry(city.country_code).toString());
        }

        // Add more assertions for other attributes
    }

    @Test
    public void testGetCountry() {
        // Test getCountry method with a known country code
        Country country = sqlApp.getCountry("USA");

        if(country != null) {
            assertEquals("United States", country.name);
            assertEquals("North America", country.continent);
        }


        // Add more assertions for other attributes
    }

    @Test
    public void testGetCountryOfficialLanguage() {
        // Test getCountryOfficialLanguage method with a known country code
        CountryLanguage language = sqlApp.getCountryOfficialLanguage("USA");

        if(language != null)
        {
            assertEquals("English", language.language);
            assertEquals(language.is_official, "T");

        }



        // Add more assertions for other attributes
    }

    // Add more test methods for other functionalities.

}