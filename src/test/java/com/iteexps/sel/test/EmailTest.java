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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 *
 * @author itexps
 */
public class EmailTest {
    
    public EmailTest() {
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
    public void testCreateProfile(){
        driver.get("https://www.hotmail.com"); // navigate
        
        //By by=By.partialLinkText("Create free account");
        //WebElement e=driver.findElement(by);
        //e.click();
        driver.findElement(By.partialLinkText("Create free account")).click();
        //by=By.id("MemberName"); // Locate by id
        //e=driver.findElement(by);
        //e.sendKeys("SampleNL"); // Type email id
        //driver.findElement(By.id("MemberName")).sendKeys("sampleNL");
        //WebElement e=driver.findElement(By.xpath("//input[@id='MemberName']"));
        //e.clear();
        //e.sendKeys("sampleNL");
        driver.findElement(By.xpath("//input[@id='MemberName']")).sendKeys("sampleNL");
        
        //driver.findElement(By.name("LiveDomainBoxList")).sendKeys("hotmail.com");
        driver.findElement(By.xpath("//select[@name='LiveDomainBoxList']")).sendKeys("hotmail.com");
        driver.findElement(By.id("iSignupAction")).click();
        driver.findElement(By.id("PasswordInput")).sendKeys("NLsample@123");
        driver.findElement(By.id("iSignupAction")).click();
        
        //driver.findElements(By.tagName("input")).get(1).sendkeys("Last Name");
    }
    
    @Test
    public void testSignin() {
        driver.get("http://www.hotmail.com"); // Navigate
        driver.findElement(By.partialLinkText("Sign in")).click();
        driver.findElement(By.id("i0116")).sendKeys("SelSample@hotmail.com");
        driver.findElement(By.className("btn-primary")).click();
        // Explicitly pause the program for 3 seconds
        try{
            Thread.currentThread().sleep(500);
        }catch(Exception e){
            System.out.println("Program interrupted");
        }
        //Explicit Timeout
        WebElement e=driver.findElement(By.name("passwd"));
        new WebDriverWait(driver,30).until(ExpectedConditions.elementToBeClickable(e));
        e.sendKeys("Sel@123!");
        // Keep me signed in
        e=driver.findElement(By.name("KMSI"));
        if (!e.isSelected()){
            driver.findElement(By.name("KMSI")).click(); // Its inverting the value
        }
        driver.findElement(By.id("idSIButton9")).click();
    }
    
    
    
    
    @Test
    public void testLogin() throws InterruptedException{
        driver.get("http://www.hotmail.com");
        WebElement e=driver.findElement(By.partialLinkText("Sign"));
        e.click();
        e=driver.findElement(By.id("i0116"));
        //e=driver.findElement(By.id("i0116"));
        e.sendKeys("SelSample@hotmail.com");
        e=driver.findElement(By.className("btn-primary"));
        new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(e));
        e.click();
        /*(e=driver.findElement(By.tagName("a"));
        e.click();*/
        // Excplicitwait
        //Thread.currentThread().sleep(4000);
        Thread.currentThread().sleep(1000); // Pause for 3 seconds
        
        // Explicit timeout using Selenium
        e=driver.findElement(By.xpath("//input[@type='password']"));
        new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(e));
        //ExpectedConditions.
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Sel@123!");
        //driver.findElement(By.name("passwd")).sendKeys("Sel@123");
        driver.findElement(By.name("KMSI")).click();
        driver.findElement(By.name("KMSI")).submit();
        
    }
    
}
