package main.java.by.kirkaee.io;

import main.java.by.kirkaee.domain.User;

public interface Writer {
    void write(User user);
    void write(String line);
}
