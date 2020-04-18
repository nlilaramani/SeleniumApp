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
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.WebElement;

/**
 *
 * @author itexps
 */
public class GoogleSearchTest {
    
    public GoogleSearchTest() {
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
        Options option=driver.manage();
        Window w=option.window();
        w.maximize();
        option.timeouts().implicitlyWait(50, TimeUnit.SECONDS);
    }
    
    @After
    public void tearDown() {
        //driver.quit();
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void testGoogleSearch(){
        driver.get("http://www.google.com"); // Navigate to google web site
        //type Selenium Jobs in Search text box
        By by=By.name("q"); // Look for element with attribute name and its value is q
        //ExplicitlyWait(for q to become available)
        WebElement e=driver.findElement(by);
        e.sendKeys("Selenium Jobs"); // Type text "Selenium jobs" in text box
        e.submit(); // Submit the querys
        //e.click();
        String title=driver.getTitle();
        assertTrue(title.toLowerCase().contains("selenium jobs"));
        
    }
    @Test
    public void testNavigation(){
        Navigation nav=driver.navigate();
        nav.to("http://www.itexps.com");
        nav.to("http://www.google.com");
        nav.to("http://www.microsoft.com");
        nav.back();
        nav.forward();
        nav.refresh();
    }
}
