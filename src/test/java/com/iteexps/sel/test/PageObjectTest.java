/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iteexps.sel.test;

import com.itexps.po.FlightFinderPage;
import com.itexps.po.LoginPage;
import com.itexps.sel.seleniumapp.DriverUtils;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;

/**
 *
 * @author itexps
 */
public class PageObjectTest {
    
    public PageObjectTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    LoginPage loginPage;
    FlightFinderPage flightFinderPage;
    @Before
    public void setUp() {
        WebDriver driver=DriverUtils.getChromeDriver();
        WebDriver.Options option=driver.manage();
        WebDriver.Window w=option.window();
        w.maximize();
        option.timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        loginPage=new LoginPage(driver);
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void testFlightBooking(){
        FlightFinderPage flightFinderPage=loginPage.login("mercury", "mercury");
        flightFinderPage.findFlights("roundTrip", 2, "New York", "London");
    }
}
