package main.java.by.kirkaee.io.impl;

import main.java.by.kirkaee.io.Reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReaderImpl implements Reader {

    private static ReaderImpl instance = new ReaderImpl();

    private ReaderImpl(){
    }

    public static ReaderImpl getInstance(){
        return instance;
    }

    public String readFromConsole() {
        String s = null;
        try {
            BufferedReader readerLine = new BufferedReader(new InputStreamReader(System.in));
            s = readerLine.readLine();
        } catch (
                IOException ex) {
            System.out.println(ex.getMessage());
        }
        return s;
    }

    public void readFromFile() {
        try (FileReader reader = new FileReader("users.txt")) {
            int c;
            while ((c = reader.read()) != -1) {
                System.out.print((char) c);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
