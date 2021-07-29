package main.java.by.kirkaee.converter;

import main.java.by.kirkaee.domain.Role;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Converter {

    private static Converter instance = new Converter();

    private Converter(){
    }

    public static Converter getInstance(){
        return instance;
    }

    public Set<String> converterSetRoleToSetString(Set<Role> roles){
        Set<String> rolesString = new HashSet();
        for (Role s : roles) {
            rolesString.add(s.toString());
        }
        return rolesString;
    }

    public Set<Role> converterStringToSetRole(String line){
        int size = line.length();
        line = line.substring(1,size-1);
        Set<String> lines = new HashSet<String>(Arrays.asList(line.split(", ")));
        Set<Role> roles = new HashSet<Role>();
        for (String s : lines) {
            roles.add(Role.valueOf(s));
        }
        return roles;
    }

    public Set<String> converterStringToSetString(String line){
        int size = line.length();
        line = line.substring(1,size-1);
        Set<String> lines = new HashSet<String>(Arrays.asList(line.split(", ")));
        return lines;
    }
}
