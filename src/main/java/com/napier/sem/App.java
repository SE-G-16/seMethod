package com.napier.sem;

public class App {

    // main entry point

    public static void main(String[] args)
    {
        // Create new Application
        SqlApp a = new SqlApp();

        // Connect to database
        a.connect();

        // Disconnect from database
        a.disconnect();


    }
}
