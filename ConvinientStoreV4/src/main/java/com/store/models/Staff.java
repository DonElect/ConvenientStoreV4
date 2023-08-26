package com.store.models;

public abstract class Staff {
    protected String firstName;
    protected String lastName;
    protected int age;
    protected String employerID;
    protected String email;
    protected String address;

    protected Staff(String firstName, String lastName, int age, String employerID, String email, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.employerID = employerID;
        this.email = email;
        this.address = address;
    }

    protected Staff(){

    }

    public String getFirstName() {
        return firstName;
    }

    protected String getLastName() {
        return lastName;
    }

    protected int getAge() {
        return age;
    }

    protected String getEmployerID() {
        return employerID;
    }

    protected String getEmail() {
        return email;
    }

    protected String getAddress() {
        return address;
    }

}
