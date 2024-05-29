package com.opentext.assignment.linereader;

import com.opentext.assignment.linereader.Driver;
import com.opentext.assignment.linereader.FileHandler;

import java.io.FileNotFoundException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )  {
        Driver driver = null;
        try {
            driver = new Driver(new FileHandler(args[0]));
            driver.start();
        } catch (FileNotFoundException e) {
            System.err.println("Invalid file path. Program exits now.");
        }

    }
}
