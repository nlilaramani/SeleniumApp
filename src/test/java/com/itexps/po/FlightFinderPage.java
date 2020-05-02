/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itexps.po;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

/**
 *
 * @author itexps
 */
public class FlightFinderPage {
    @FindBy(name="tripType")
    private List<WebElement> tripType;
    @FindBy(name="passCount")
    private WebElement passengerCount;
    @FindBy(name="fromPort")
    private WebElement fromPort;
    @FindBy(name="fromMonth")
    private WebElement fromMonth;
    @FindBy(name="fromDay")
    private WebElement fromDay;
//new Select(driver.findElement(By.name("fromMonth"))).selectByIndex(5);
    @FindBy(name="toPort")
    private WebElement toPort;
    @FindBy(name="toMonth")
    private WebElement toMonth;
    @FindBy(name="toDay")
    private WebElement toDay;
    @FindBy(name="servClass")
    private List<WebElement> servClass;
    @FindBy(xpath="//input[@name='findFlights']")
    private WebElement findFlights;
    public FlightFinderPage(WebDriver driver){
       PageFactory.initElements(driver, this);
    }

    public void findFlights(String triptype,int passengers, String fromPort, String toPort){
      tripType.get(0).click();
      new Select(passengerCount).selectByIndex(passengers-1);
      this.fromPort.sendKeys(fromPort);
      this.toPort.sendKeys(toPort);
      findFlights.click();
      
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
