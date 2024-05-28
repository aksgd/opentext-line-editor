package org.example;

import linereader.assignment.opentext.Driver;
import linereader.assignment.opentext.FileHandler;

import java.io.FileNotFoundException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws FileNotFoundException {
        var driver = new Driver(new FileHandler(args[0]));
        driver.start();
    }
}
