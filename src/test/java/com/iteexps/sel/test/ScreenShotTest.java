/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iteexps.sel.test;

import com.itexps.sel.seleniumapp.DriverUtils;
import java.io.File;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

/**
 *
 * @author itexps
 */
public class ScreenShotTest {
    
    public ScreenShotTest() {
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
    public void testScreenshot(){
        driver.get("http://www.google.com");
        TakesScreenshot screen=(TakesScreenshot)driver;
        File destfile=new File("c://qa//screenshot.png");
        File file=screen.getScreenshotAs(OutputType.FILE);
        //FileUtils().fileCopy(file,destfile);
    }
}
