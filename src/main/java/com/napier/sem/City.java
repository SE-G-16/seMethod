package com.napier.sem;

/**
 * Represents a City
 */
public class City {
    /**
     * City ID number
     */
    public int id;

    /**
     * City name
     */
    public String name;

    /**
     * City country's code
     */
    public String country_code;

    /**
     * City district
     */
    public String district;

    /**
     * City's population
     */
    public int population;

    @Override
    public String toString() {

        return "City: " + name + " " +  population;
    }

}
