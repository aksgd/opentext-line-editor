package com.opentext.assignment.linereader;

public class Input{
    private String flag;
    private String value;

    public String getFlag() {
        return flag;
    }

    public Integer getValueAsInteger(){
        if(value == null) {
            return null;
        }
        return Integer.valueOf(value.trim());
    }

    public Input(String userInput) {
        String[] inputStrings = userInput.split("\\s+");
        flag = inputStrings[0];
        if(inputStrings.length > 1) {
            value = inputStrings[1];
        }
    }
}
