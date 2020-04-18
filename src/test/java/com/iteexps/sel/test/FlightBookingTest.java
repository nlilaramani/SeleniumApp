/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iteexps.sel.test;

import com.itexps.sel.seleniumapp.DriverUtils;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 *
 * @author itexps
 */
public class FlightBookingTest {
    
    public FlightBookingTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    WebDriver driver;
    @Before
    public void setUp() {
        driver=DriverUtils.getChromeDriver(); // Launch the browser
        WebDriver.Options option=driver.manage();
        WebDriver.Window w=option.window();
        w.maximize();
        option.timeouts().implicitlyWait(30, TimeUnit.SECONDS);
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
        driver.get("http://newtours.demoaut.com");
        driver.findElement(By.name("userName")).sendKeys("mercury");
        driver.findElement(By.name("password")).sendKeys("mercury");
        driver.findElement(By.name("login")).click();
        driver.findElements(By.name("tripType")).get(0).click();
        driver.findElement(By.name("passCount")).sendKeys("2");
        new Select(driver.findElement(By.name("fromPort"))).selectByIndex(2);
        new Select(driver.findElement(By.name("fromMonth"))).selectByIndex(5);
        new Select(driver.findElement(By.name("fromDay"))).selectByIndex(10);
        new Select(driver.findElement(By.name("toPort"))).selectByIndex(4);
        new Select(driver.findElement(By.name("toMonth"))).selectByIndex(6);
        new Select(driver.findElement(By.name("toDay"))).selectByIndex(8);
        driver.findElements(By.name("servClass")).get(1).click();
        driver.findElement(By.xpath("//input[@name='findFlights']")).click();
        driver.findElements(By.name("outFlight")).get(2).click();
        driver.findElements(By.name("inFlight")).get(1).click();
        driver.findElement(By.xpath("//input[@name='reserveFlights']")).click();
        for(int i=0;i<2;i++){
            String first="passFirst"+i;
            String last="passLast"+i;
            driver.findElement(By.name(first)).sendKeys("FN"+i);
            driver.findElement(By.name(last)).sendKeys("LN"+i);
        }
        driver.findElement(By.name("creditnumber")).sendKeys("1212121212");
        driver.findElement(By.name("buyFlights")).click();
        boolean result=driver.getPageSource().contains("Your itinerary has been booked!");
        WebElement e=driver.findElement(By.xpath("//img[@src='/images/masts/mast_confirmation.gif']"));
        assert(e.isDisplayed());
    }
}
