package main.java.by.kirkaee.service;

import main.java.by.kirkaee.converter.Converter;
import main.java.by.kirkaee.domain.User;
import main.java.by.kirkaee.io.Reader;
import main.java.by.kirkaee.io.Writer;
import main.java.by.kirkaee.io.impl.ReaderImpl;
import main.java.by.kirkaee.io.impl.WriterImpl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class EditorUser extends CreatorUser {

    Reader reader = ReaderImpl.getInstance();
    Writer writer = WriterImpl.getInstance();
    Converter converter = Converter.getInstance();

    public void edit() {
        System.out.println("Enter the email of the user you want to edit.");
        String email = reader.readFromConsole();
        List<String> lines = null;
        try {
            lines = Files.readAllLines(Paths.get("users.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        int counter = 0;
        for (String s : lines) {
            if (s.contains(email)) {
                List<String> list = new ArrayList<String>(Arrays.asList(s.split(";")));
                lines.remove(counter);
                try {
                    Files.write(Paths.get("users.txt"), lines);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("Enter the field you want to edit " +
                        "(first name, last name, email, role, phones)");
                String command = reader.readFromConsole();
                User user = new User(list.get(0), list.get(1), list.get(2),
                        converter.converterStringToSetRole(list.get(3)),
                        converter.converterStringToSetString(list.get(4)));

                switch (command) {
                    case "first name" :
                        user.setFirstName(setFirstName());
                        break;
                    case "last name" :
                        user.setLastName(setLastName());
                        break;
                    case "email" :
                        user.setEmail(setEmail());
                        break;
                    case "role" :
                        user.setRoles(setRole());
                        break;
                    case "phones" :
                        user.setPhoneNumber(setPhones());
                        break;
                    default :
                        System.out.println("There is no such command.");
                        break;
                }
                writer.write(user);
                break;
            }
            counter++;
        }
    }
}
