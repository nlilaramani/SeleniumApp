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

/**
 *
 * @author itexps
 */
public class SampleTest {
    
    public SampleTest() {
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
    public void testIframe(){
        driver.get("file:///c:/users/itexps/documents/sample.html");
        driver.switchTo().frame("iframe_1");
        driver.findElement(By.name("userName")).sendKeys("mercury");
    }
    
    @Test
    public void testAlert(){
        driver.get("file:///c:/users/itexps/documents/sample.html");
        driver.findElement(By.tagName("button")).click();
        //driver.switchTo().alert().dismiss();
        driver.switchTo().alert().accept();
        
        
        driver.switchTo().window("<Window Handle>");
        driver.getWindowHandles();
        //driver.switchTo().window(driver.getWindowHandles().toArray(ts)[1]);
        driver.findElement(By.tagName("button"));
    }
}
