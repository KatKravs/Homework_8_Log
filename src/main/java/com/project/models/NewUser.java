package com.project.models;

public class NewUser {

    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String confirmPassword;


    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public NewUser setEmail(String email) {
        this.email = email;
        return this;
    }

    public NewUser setPassword(String password) {
        this.password = password;
        return this;
    }

    public NewUser setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public NewUser setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public NewUser setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }

    @Override
    public String toString() {
        return "NewUser{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", confirmPassword='" + confirmPassword + '\'' +
                '}';
    }
}
