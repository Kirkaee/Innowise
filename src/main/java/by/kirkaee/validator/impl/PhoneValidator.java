package main.java.by.kirkaee.validator.impl;

import main.java.by.kirkaee.validator.Validator;

public class PhoneValidator implements Validator {
    @Override
    public String check(String checkingObject) {
        int s1 = checkingObject.indexOf("375");
        if (s1 == 0) {
            int s2 = checkingObject.length();
            if (s2 == 12) {
                return checkingObject;
            }
        }
        System.out.println("Invalid data.");
        return "Invalid data.";
    }
}
