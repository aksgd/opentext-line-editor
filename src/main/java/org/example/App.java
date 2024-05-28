package org.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.stream.Collectors;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws FileNotFoundException {
        var file = new File(args[0]);
        var br
            = new BufferedReader(new FileReader(file));
        var linesOfFile = new LinkedList<String>();
        br.lines().forEach(line -> {
            linesOfFile.add(line);
        });
        linesOfFile.forEach(line -> {
            System.out.println(line);
        });

    }
}
