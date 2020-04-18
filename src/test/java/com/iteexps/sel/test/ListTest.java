/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iteexps.sel.test;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author itexps
 */
public class ListTest {
    
    public ListTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    // List collection
    @Test
    public void testList(){
        //int i;
        double d;
        String s;
        String[] strArray={"ABC","XYZ"};
        // It is index bound
        // Its size is immutable/limited
        // Datastructure collections
        // Performance
        // Implement collections -interface
         // List - Collection & Array
         // Collection - Objects as elements
         List<String> friends;
         friends=new ArrayList();
         friends.add("Paul");
         friends.add("Tom");
         friends.add("Bob");
         System.out.println(friends.size());
         for(int i=0;i<friends.size();i++){
             System.out.println(friends.get(i));
         }
         for(Object o:friends){ 
             System.out.println(o);
         }
         //friends.contains("Tom");
         friends.remove("Bob");
         friends.add("Rob");
         for(Object o:friends){ 
             System.out.println(o);
         }
         
        
    }
    
    
    
}
