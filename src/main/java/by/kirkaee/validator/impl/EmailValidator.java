package main.java.by.kirkaee.validator.impl;

import main.java.by.kirkaee.validator.Validator;

public class EmailValidator implements Validator {

    @Override
    public String check(String checkingObject) {
        int s1 = checkingObject.indexOf("@",1);
        if (s1 != -1) {
            int s2 = checkingObject.indexOf(".", s1+2);
            if (s2 != -1) {
                return checkingObject;
            }
        }
        System.out.println("Invalid data.");
        return "Invalid data.";

    }
}
