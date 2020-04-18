/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itexps.sel.seleniumapp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



/**
 *
 * @author itexps
 */
public class DriverUtils {
    
    public static WebDriver getChromeDriver(){
        System.setProperty("webdriver.chrome.driver", "c:\\drivers\\chromedriver.exe");
        return new ChromeDriver();
    }
    
    public int getNumber(){
        return 10;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        getChromeDriver();
    }
}
