/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itexps.sel.seleniumapp;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 *
 * @author itexps
 */
public class FileUtils {
    public static String[] readCSVFile(String pathToCsv, int line) throws Exception{
        BufferedReader csvReader = new BufferedReader(new FileReader(pathToCsv));
        String[] result=null;
        String row;
        int c=1;
        while ((row = csvReader.readLine()) != null) {
            result = row.split(",");
            if(c==line)
                break;
            c++;
        }
        csvReader.close();
        return result;
    } 
}
