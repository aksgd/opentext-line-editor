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
        if(args.length > 0) {
            try {
                new Driver(new FileHandler(args[0])).start();
            } catch (FileNotFoundException e) {
                System.err.println("Invalid file path. Program exits now.");
            }
        }

    }
}
