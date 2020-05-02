/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iteexps.sel.test;

import com.itexps.sel.seleniumapp.DriverUtils;
import com.itexps.sel.seleniumapp.FileUtils;
import java.io.File;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 *
 * @author itexps
 */
public class UserProfileTest {
    
    public UserProfileTest() {
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
    public void testUserProfile(){
        driver.get("file:///C:/Users/itexps/Documents/user_profile.html");
          if (driver.findElements(By.tagName("input")).get(5).isDisplayed()){
             driver.findElements(By.tagName("input")).get(5).click();
        }
        driver.findElements(By.tagName("input")).get(1).sendKeys("abc");
        if(driver.findElements(By.tagName("input")).get(2).isEnabled()){
            driver.findElements(By.tagName("input")).get(2).sendKeys("xyz");
        }
        if(driver.findElements(By.tagName("input")).get(2).isEnabled()){
            driver.findElements(By.tagName("input")).get(2).sendKeys("xyz");
        }
        if (driver.findElements(By.tagName("input")).get(5).isDisplayed()){
             driver.findElements(By.tagName("input")).get(5).click();
        }
        WebElement e=driver.findElement(By.tagName("select"));
        new Select(e).selectByIndex(2);
        
    }
    @Test
    public void testUserProfile1(){
        driver.get("file:///C:/Users/itexps/Documents/user_profile.html");
        driver.findElements(By.name("g")).get(0).click();
    }
    
    
    @Test
    public void testUserProfileData() throws Exception{
        driver.get("file:///C:/Users/itexps/Documents/user_profile.html");
        String[] data=FileUtils.readCSVFile("c:\\qa\\userprofile.csv",2);
        driver.findElements(By.tagName("input")).get(0).sendKeys(data[0]);
        driver.findElements(By.tagName("input")).get(1).sendKeys(data[1]);
        driver.findElements(By.tagName("input")).get(2).sendKeys(data[2]);
        driver.findElements(By.tagName("input")).get(3).sendKeys(data[3]);
        if(data[4].equalsIgnoreCase("M")){
         if (driver.findElements(By.tagName("input")).get(4).isDisplayed()){
             driver.findElements(By.tagName("input")).get(4).click();
         }
        }else{
         if (driver.findElements(By.tagName("input")).get(5).isDisplayed()){
             driver.findElements(By.tagName("input")).get(5).click();
         }
         }
        WebElement e=driver.findElement(By.tagName("select"));
        //new Select(e).sendKeys(data[6]);
        e.sendKeys(data[5]);
    }
    
    @Test
    public void testScroll(){
        driver.get("http://www.infotekguide.com");
        JavascriptExecutor js=(JavascriptExecutor)driver;
        //Scrolling
        js.executeScript("window.scrollBy(0,1000)");
        //Opening a new tab
        js.executeScript("window.open()");
        driver.navigate().back();
        TakesScreenshot screen=(TakesScreenshot)driver;
        File file=new File("c://qa//screenshot.png");
        file=screen.getScreenshotAs(OutputType.FILE);
    }
    @Test
    public void testScreenshot(){
        driver.get("http://www.google.com");
        TakesScreenshot screen=(TakesScreenshot)driver;
        File destfile=new File("c://qa//screenshot.png");
        File file=screen.getScreenshotAs(OutputType.FILE);
        //FileUtils().fileCopy(file,destfile);
    }
    
}
