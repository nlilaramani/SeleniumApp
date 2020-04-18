/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.itexps.sel.seleniumapp;

/**
 *
 * @author itexps
 */
public class ExceptionsSample {
    
    public static void main(String[] args){
        
        String[] names={"n1","n2","n3"};
        try{
            for(int i=0;i<=3;i++){
                System.out.println(names[i]);
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println("Program Ends here");
        int result=100;
        try{
            for(int i=10;i>=0;i--){
                result=result/i; 
                System.out.println(result);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        System.out.println("Program Ends here-2");
    }
    
}
