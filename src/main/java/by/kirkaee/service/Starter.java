package main.java.by.kirkaee.service;

import main.java.by.kirkaee.io.Reader;
import main.java.by.kirkaee.io.impl.ReaderImpl;

public class Starter {

    public void start(){
        Reader reader = ReaderImpl.getInstance();

        while (true) {
            System.out.println("Write command (create, view, edit, delete).");
            String command = reader.readFromConsole();
            switch (command) {
                case "create" :
                    CreatorUser creatorUser = new CreatorUser();
                    creatorUser.create();
                    break;
                case "view" :
                    ViewerUsers viewerUsers = new ViewerUsers();
                    viewerUsers.view();
                    break;
                case "edit" :
                    EditorUser editUser = new EditorUser();
                    editUser.edit();
                    break;
                case "delete" :
                    DeleterUser deleterUser = new DeleterUser();
                    deleterUser.delete();
                    break;
                default :
                    System.out.println("Command not found.");
                    break;
            }
        }
    }
}
