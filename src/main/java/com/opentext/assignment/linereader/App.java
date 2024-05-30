package com.opentext.assignment.linereader;

import java.io.FileNotFoundException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )  {
        var terminalHandler = new TerminalHandler();
        if(args.length > 0) {
            try {
                new Driver(new FileHandler(args[0]), terminalHandler).start();
            } catch (FileNotFoundException e) {
                terminalHandler.printError("Invalid file path. Program exits now.");
                System.exit(1);
            }
        } else {
            terminalHandler.printLine("Missing file path. Program exits now");
        }
    }
}
