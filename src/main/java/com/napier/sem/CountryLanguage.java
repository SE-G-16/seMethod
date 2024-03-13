package com.napier.sem;

/**
 * Represents a Country Language
 */

public class CountryLanguage {

    /**
     * Language Country's code
     */
    public String country_code;

    /**
     * languages
     */
    public String language;

    /**
     * official language
     */
    public String is_official;

    /**
     * language percentage
     */
    public double percentage;

    @Override
    public String toString() {

        return "Country: " + country_code + " " +  language + " " + is_official + " " + percentage;
    }

}
