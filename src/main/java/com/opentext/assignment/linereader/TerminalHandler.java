package com.opentext.assignment.linereader;

public class TerminalHandler {

    public void printLine(String s) {
        System.out.println(s);
    }

    public void print(String s) {
        System.out.print(s);
    }

    public void printLine() {
        System.out.println();
    }

    public void printError(String s) {
        System.err.println(s);
    }
}
