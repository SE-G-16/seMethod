package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import java.net.UnknownHostException;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {


    @BeforeAll
    static void init() throws UnknownHostException {


        App.connect(App.LocationLocalhostStr, 3000);

    }


    /*@Test
    void testSystemOut()
    {
        System.out.println("hello");
        assertSame(System.in.toString(), "hello");

    }*/

    @Test
    void testQtypeEnum()
    {
        var qnum = QType.Country;
        assertEquals( qnum.toString(), "Country");
    }

    @Test
    void testAreaEnum()
    {
        var area = Area.Continent;
        assertEquals( area.toString(), "Continent");
    }

    @Test
    void testGetCountry()
    {
        if(App.con == null)
        {
            return;
        }

        Country country = App.s.getCountry("AND");

        // null check
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

        if(country != null)
        {
            System.out.println("\nAPP TEST: " + country.code + " / " + country.name + " / " + country.continent);
        }
    }



    @Test
    void print() {

        String nullPrint = String.valueOf(App.print(null));
        assertEquals("" , nullPrint);

        String zeroPrint = String.valueOf(App.print("0"));
        assertEquals("0" , zeroPrint);

        String aaa = String.valueOf(App.print("hello print method" + " cat"));
        String bbb = String.valueOf(App.print( ""));
        String ccc = String.valueOf(App.print("44433"));

        assertEquals("hello print method cat", aaa);
        assertEquals("", bbb);
        assertEquals("44433", ccc);
    }

    @Test
    void connect() throws UnknownHostException, SQLException {
        App.disconnect();
        App.connect(App.LocationLocalhostStr, 500);

        if(App.con != null)
        {
            assertTrue(App.con.isValid(500));
        }

    }

    @Test
    void disconnect() throws SQLException {

        if(App.con != null)
        {
            App.disconnect();
            assertTrue(App.con.isClosed());
        }

    }

    @Test
    public void main() throws UnknownHostException, SQLException {

        if(App.con == null)
        {
            return;
        }

        App.disconnect();
        App.connect(App.LocationLocalhostStr, 500);
        if(App.con != null)
        {
            assertTrue(App.con.isValid(500));
        }

        App.disconnect();
        if(App.con != null)
        {
            assertTrue(App.con.isClosed());
        }

    }
}