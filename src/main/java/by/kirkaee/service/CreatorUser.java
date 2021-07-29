package main.java.by.kirkaee.service;

import main.java.by.kirkaee.domain.Role;
import main.java.by.kirkaee.domain.User;
import main.java.by.kirkaee.io.Reader;
import main.java.by.kirkaee.io.Writer;
import main.java.by.kirkaee.io.impl.ReaderImpl;
import main.java.by.kirkaee.io.impl.WriterImpl;
import main.java.by.kirkaee.validator.Validator;
import main.java.by.kirkaee.validator.impl.EmailValidator;
import main.java.by.kirkaee.validator.impl.PhoneValidator;

import java.util.*;

public class CreatorUser {

    Reader reader = ReaderImpl.getInstance();
    Writer writer = WriterImpl.getInstance();
    String command;

    public void create() {
        String firstName = setFirstName();
        String lastName = setLastName();
        String email = setEmail();
        Set<Role> roles = setRole();
        Set<String> phones = setPhones();
        User user = new User(firstName, lastName, email, roles, phones);
        writer.write(user);
        System.out.println("User created.");
    }

    public String setFirstName() {
        String firstName;
        do {
            System.out.println("Write first name.");
            firstName = reader.readFromConsole();
            if (firstName.isEmpty()){
                System.out.println("Invalid data.");
            }
        } while (firstName.isEmpty());
        return firstName;
    }

    public String setLastName() {
        String lastName;
        do {
            System.out.println("Write last name.");
            lastName = reader.readFromConsole();
            if (lastName.isEmpty()){
                System.out.println("Invalid data.");
            }
        } while (lastName.isEmpty());
        return lastName;
    }

    public String setEmail() {
        Validator validator = new EmailValidator();
        String check;
        String email;
        do {
            System.out.println("Write email.");
            email = reader.readFromConsole();
            check = validator.check(email);
        } while (check.equals("Invalid data."));
        return email;
    }

    public Set<Role> setRole(){
        Set<Role> roles = new HashSet<>();
        String role;
        do{
            System.out.println("Enter roles separated by commas.\n" +
                    "Maximum 1 role from one level (Level 3: SUPER_ADMIN;\n" +
                    "Level 2: PROVIDER, ADMIN; Level 1: USER, CUSTOMER)\n" +
                    "Example: \"ADMIN, USER\"");
            role = reader.readFromConsole();
            List<String> list = new ArrayList<String>(Arrays.asList(role.split(", ")));
            if (list.contains("ADMIN") && list.contains("PROVIDER") ||
                    list.contains("USER") && list.contains("CUSTOMER")){
                System.out.println("You cannot enter 2 roles of the same level.");
            } else {
                if ((list.contains("USER") || list.contains("CUSTOMER") || list.contains("ADMIN") ||
                        list.contains("PROVIDER")) && !list.contains("SUPER_ADMIN")
                        && list.size() < 3) {
                    for (int i = 0; list.size()>i; i++) {
                        roles.add(Role.valueOf(list.get(i)));
                    }
                } else {
                if (list.contains("SUPER_ADMIN") && list.size() < 2) {
                    for (int i = 0; list.size() > i; i++) {
                        roles.add(Role.valueOf(list.get(i)));
                    }
                } else {
                    if (list.contains("SUPER_ADMIN")) {
                        System.out.println("Can't be SUPER_ADMIN and anyone else.");
                    } else {
                        System.out.println("Invalid date.");
                    }
                }
                }
            }
        } while (roles.isEmpty());
        return roles;
    }

    public Set<String> setPhones() {
        Set<String> phones = new HashSet<>();
        Validator validator = new PhoneValidator();
        String phone;
        String check;
        do {
            do {
                System.out.println("Enter the number in the form 375*********");
                phone = reader.readFromConsole();
                check = validator.check(phone);
            } while (check.equals("Invalid data."));
            phones.add(phone);
            if (phones.size() < 3) {
                System.out.println("Enter another number? (yes/no)");
                command = reader.readFromConsole();
            }
        } while (phones.size() < 3 && command.equals("yes"));
        return phones;
    }
}
