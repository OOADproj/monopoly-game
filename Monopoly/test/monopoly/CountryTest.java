/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monopoly;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Gina Salib
 */
public class CountryTest {
    
    public CountryTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getcIndex method, of class Country.
     */
    @Test
    public void testGetcIndex() {
        System.out.println("getcIndex");
        Country instance = null;
        int expResult = 0;
        int result = instance.getcIndex();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isSetComplete method, of class Country.
     */
    @Test
    public void testIsSetComplete() {
        System.out.println("isSetComplete");
        Country instance = null;
        boolean expResult = false;
        boolean result = instance.isSetComplete();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSetComplete method, of class Country.
     */
    @Test
    public void testSetSetComplete() {
        System.out.println("setSetComplete");
        boolean setComplete = false;
        Country instance = null;
        instance.setSetComplete(setComplete);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCost method, of class Country.
     */
    @Test
    public void testGetCost() {
        System.out.println("getCost");
        Country instance = null;
        int expResult = 0;
        int result = instance.getCost();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCost method, of class Country.
     */
    @Test
    public void testSetCost() {
        System.out.println("setCost");
        int Cost = 0;
        Country instance = null;
        instance.setCost(Cost);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRent method, of class Country.
     */
    @Test
    public void testGetRent() {
        System.out.println("getRent");
        Country instance = null;
        int expResult = 0;
        int result = instance.getRent();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRent method, of class Country.
     */
    @Test
    public void testSetRent() {
        System.out.println("setRent");
        int Rent = 0;
        Country instance = null;
        instance.setRent(Rent);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isBought method, of class Country.
     */
    @Test
    public void testIsBought() {
        System.out.println("isBought");
        String [] s = new String [2];
        s[0]="P1";
        s[1]="P2";
        Game g = new Game(2,s);
        for(int i=0;i<g.Countries.size();i++)
        {
        if(g.Countries.get(i) instanceof Country)
        {
            Country instance = (Country) g.Countries.get(i);
            boolean expResult = false;
           boolean result = instance.isBought();
           assertEquals(expResult, result);
           
        }
        }
        
        
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of setBought method, of class Country.
     */
    @Test
    public void testSetBought() {
        System.out.println("setBought");
        boolean Bought = false;
        Country instance = null;
        instance.setBought(Bought);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getnHotels method, of class Country.
     */
    @Test
    public void testGetnHotels() {
        System.out.println("getnHotels");
        Country instance = null;
        int expResult = 0;
        int result = instance.getnHotels();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setnHotels method, of class Country.
     */
    @Test
    public void testSetnHotels() {
        System.out.println("setnHotels");
        int nHotels = 0;
        Country instance = null;
        instance.setnHotels(nHotels);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getnHouses method, of class Country.
     */
    @Test
    public void testGetnHouses() {
        System.out.println("getnHouses");
        Country instance = null;
        int expResult = 0;
        int result = instance.getnHouses();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setnHouses method, of class Country.
     */
    @Test
    public void testSetnHouses() {
        System.out.println("setnHouses");
        int nHouses = 0;
        Country instance = null;
        instance.setnHouses(nHouses);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOwner method, of class Country.
     */
    @Test
    public void testGetOwner() {
        System.out.println("getOwner");
        Country instance = null;
        String expResult = "";
        String result = instance.getOwner();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setOwner method, of class Country.
     */
    @Test
    public void testSetOwner() {
        System.out.println("setOwner");
        String Owner = "";
        Country instance = null;
        instance.setOwner(Owner);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeOwner method, of class Country.
     */
    @Test
    public void testRemoveOwner() {
        System.out.println("removeOwner");
        Country instance = null;
        instance.removeOwner();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of viewInformation method, of class Country.
     */
    @Test
    public void testViewInformation() {
        System.out.println("viewInformation");
        Country instance = null;
        String expResult = "";
        String result = instance.viewInformation();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
