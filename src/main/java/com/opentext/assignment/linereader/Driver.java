package com.opentext.assignment.linereader;

import java.io.IOException;
import java.util.Scanner;

public class Driver {

    private final FileHandler fileHandler;
    private final TerminalHandler terminalHandler;

    public Driver(FileHandler fileHandler, TerminalHandler terminalHandler) {
        this.fileHandler = fileHandler;
        this.terminalHandler = terminalHandler;
    }

    private void display() {

        terminalHandler.printLine();
        terminalHandler.printLine();

        fileHandler.forEachLine((index, line) -> {
            terminalHandler.printLine(String.join(": ", String.valueOf(index), line));
        });

        terminalHandler.printLine();
        terminalHandler.printLine();
    }

    private Scanner scanner = new Scanner(System.in);
    private String getInput() {
        return scanner.nextLine();
    }

    public void start() {
        Input input;
        boolean stop = false;

        do {

            displayChoices();

            String inputString = getInput();

            input = new Input(inputString);

            switch (input.getFlag()) {
                case "list":
                    display();
                    break;
                case "del":
                    delete(Integer.valueOf(input.getValueAsInteger()));
                    break;
                case "ins":
                    insert(Integer.valueOf(input.getValueAsInteger()));
                    break;
                case "save":
                    save();
                    break;
                case "quit":
                    stop = true;
                    break;
                default:
                    terminalHandler.printLine("Input not supported, please try one of the below.");
            }

        } while(!stop);

        terminalHandler.printLine("Application now terminates. You will loose any unsaved changes.");
    }

    private void save() {
        try {
            fileHandler.save();
            terminalHandler.printLine("File saved.");
        } catch (IOException e) {
            terminalHandler.printLine("Unable to save the file.");
        }
    }

    private void delete(Integer lineNumber) {
        try {
            fileHandler.delete(lineNumber);
            terminalHandler.printLine("Line deleted.");
        } catch (Exception e) {
            terminalHandler.printLine("Unable to locate the line number.");
        }
    }

    private void displayPrompt(){
        terminalHandler.print(">>");
    }

    private void displayChoices(){
        terminalHandler.printLine("___________________________________________________________________________________________________________________________________________");
        terminalHandler.printLine("Show file:     list\ndelete a line: del <line number>\ninsert a line: ins <line number>\nTo save:       save\nTo quit:       quit");
        terminalHandler.printLine("-------------------------------------------------------------------------------------------------------------------------------------------");
        terminalHandler.printLine();
        displayPrompt();
    }
    private void insert(Integer lineNumber) {
        //this if block was added to improve user experience. However, it leads to double handling of the same concern
        if(!fileHandler.isValidLine(lineNumber)) {
            terminalHandler.printLine("Unable to locate the line number.");
            return;
        }
        terminalHandler.printLine("Enter the content:");
        displayPrompt();
        try {
            fileHandler.insert(lineNumber,getInput());
            terminalHandler.printLine("Line inserted");
        } catch (Exception e) {
            terminalHandler.printLine("Unable to locate the line number.");
        }
    }
}
