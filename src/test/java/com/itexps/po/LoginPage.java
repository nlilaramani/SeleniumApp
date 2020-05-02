/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itexps.po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



/**
 *
 * @author itexps
 */
public class LoginPage {
    protected static WebDriver driver;
    @FindBy(name="userName")
    private WebElement username;
    @FindBy(name="password")
    private WebElement password;
    @FindBy(name="login")
    private WebElement signIn;
    /**
     * @param args the command line arguments
     */
    public LoginPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
        driver.get("http://newtours.demoaut.com");
    }
    
    public FlightFinderPage login(String user,String pwd){
        username.sendKeys(user);
        password.sendKeys(pwd);
        signIn.click();
        return new FlightFinderPage(driver);
    }
}
