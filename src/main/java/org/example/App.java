package org.example;

import linereader.assignment.opentext.FileHandler;

import java.io.FileNotFoundException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws FileNotFoundException {
        var fileHandler = new FileHandler(args[0]);
        fileHandler.forEachLine((index, line) -> {
            System.out.println(String.join(": ", String.valueOf(index), line));
        });

    }
}
