package main.java.by.kirkaee.service;

import main.java.by.kirkaee.io.Reader;
import main.java.by.kirkaee.io.impl.ReaderImpl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class DeleterUser {

    Reader reader = ReaderImpl.getInstance();

    public void delete() {
        System.out.println("Enter the email of the user you want to delete.");
        String email = reader.readFromConsole();
        List<String> lines = null;
        try {
            lines = Files.readAllLines(Paths.get("users.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        int counter = 0;
        for(String s : lines) {
            if(s.contains(email) && !email.isEmpty()){
                break;
            } else {
                counter++;
            }
        }
        if (lines.size()>counter) {
            lines.remove(counter);
            try {
                Files.write(Paths.get("users.txt"), lines);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("User is not found.");
        }
    }
}
