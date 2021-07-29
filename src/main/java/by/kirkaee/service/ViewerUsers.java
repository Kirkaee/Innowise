package main.java.by.kirkaee.service;

import main.java.by.kirkaee.io.Reader;
import main.java.by.kirkaee.io.impl.ReaderImpl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class ViewerUsers {

    Reader reader = ReaderImpl.getInstance();
    String email;

    public void view(){
        System.out.println("Enter \"all\" to get all users" +
                " or email of the user in order to get only this user.");
        email = reader.readFromConsole();
        if(email.equals("all")){
            viewAll();
        } else {
            viewUser(email);
        }
    }

    public void viewAll(){
        reader.readFromFile();
    }

    public void viewUser(String email){
        List<String> lines = null;
        try {
            lines = Files.readAllLines(Paths.get("users.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        int counter = 0;
        for(String s : lines) {
            if(s.contains(email) && !email.isEmpty()) {
                System.out.println(s);
                counter++;
            }
        }
        if (counter==0){
            System.out.println("User not found.");
        }
    }

}
