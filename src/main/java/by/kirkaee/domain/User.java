package main.java.by.kirkaee.domain;

import java.util.Set;

public class User {
    private String firstName;
    private String lastName;
    private String email;
    private Set<Role> roles;
    private Set<String> phoneNumber;

    public User(String firstName, String lastName, String email, Set<Role> roles, Set<String> phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.roles = roles;
        this.phoneNumber = phoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Set<String> getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Set<String> phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return firstName + ";" + lastName + ";" + email + ";" + roles + ";" + phoneNumber;
    }
}
