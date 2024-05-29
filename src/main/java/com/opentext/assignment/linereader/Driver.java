package com.opentext.assignment.linereader;

import java.io.IOException;
import java.util.Scanner;

public class Driver {

    final private FileHandler fileHandler;
    public Driver(FileHandler fileHandler) {
        this.fileHandler = fileHandler;
    }

    private void display() {

        System.out.println();
        System.out.println();

        fileHandler.forEachLine((index, line) -> {
            System.out.println(String.join(": ", String.valueOf(index), line));
        });

        System.out.println();
        System.out.println();
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
                    System.out.println("Input not supported, please try one of the below.");
            }

        } while(!stop);

        System.out.println("Application now terminates. You will loose any unsaved changes.");
    }

    private void save() {
        try {
            fileHandler.save();
            System.out.println("File saved.");
        } catch (IOException e) {
            System.out.println("Unable to save the file.");
        }
    }

    private void delete(Integer lineNumber) {
        try {
            fileHandler.delete(lineNumber);
            System.out.println("Line deleted.");
        } catch (Exception e) {
            System.out.println("Unable to locate the line number.");
        }
    }

    private void displayPrompt(){
        System.out.print(">>");
    }

    private void displayChoices(){
        System.out.println("___________________________________________________________________________________________________________________________________________");
        System.out.println("Show file: list\t\tdelete a line: del <line number>\tinsert a line: ins <line number>\t To save: save\tTo quit: quit");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println();
        displayPrompt();
    }
    private void insert(Integer lineNumber) {
        System.out.println("Enter the content:");
        displayPrompt();
        try {
            fileHandler.insert(lineNumber,getInput());
            System.out.println("Line inserted");
        } catch (Exception e) {
            System.out.println("Unable to locate the line number.");
        }
    }
}
