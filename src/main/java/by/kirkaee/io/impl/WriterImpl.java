package main.java.by.kirkaee.io.impl;

import main.java.by.kirkaee.domain.User;
import main.java.by.kirkaee.io.Writer;

import java.io.FileWriter;
import java.io.IOException;

public class WriterImpl implements Writer {

    private static WriterImpl instance = new WriterImpl();

    private WriterImpl(){
    }

    public static WriterImpl getInstance(){
        return instance;
    }

    public void write(User user){
        try(FileWriter writer = new FileWriter("users.txt", true))
        {
            String text = user.toString();
            writer.write(text);
            writer.append('\n');
            writer.flush();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    public void write(String line){
        try(FileWriter writer = new FileWriter("users.txt", true))
        {
            writer.write(line);
            writer.append('\n');
            writer.flush();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}
