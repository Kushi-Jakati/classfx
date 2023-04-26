package edu.guilford;

public class Individual {
    //Set the name attribute to "John Doe"
    private String name;
    //Set the email attribute to "jdoe@guilford"
    private String email;
    //Set the phone attribute to "555-555-5555"
    private String phone;

    //Constructor with no arguments
    public Individual() {
        name = "John Doe";
        email = "jdoe@guilford.edu";
        phone = "555-555-5555";
    }

    //Constructor with three arguments
    public Individual(String name, String email, String phone) {
        //Set the name attribute to the name argument
        this.name = name;
        //Set the email attribute to the email argument
        this.email = email;
        //Set the phone attribute to the phone argument
        this.phone = phone;
    }

    //Getters and setters for all three attributes
    public String getName() {
        //Return the name attribute
        return name;
    }

    public void setName(String name) {
        //Set the name attribute to the name argument
        this.name = name;
    }

    public String getEmail() {
        //Return the email attribute
        return email;
    }

    public void setEmail(String email) {
        //Set the email attribute to the email argument
        this.email = email;
    }

    public String getPhone() {
        //Return the phone attribute
        return phone;
    }

    public void setPhone(String phone) {
        //Set the phone attribute to the phone argument
        this.phone = phone;
    }

    //Override the toString method
    @Override
    public String toString() {
        //Return a string representation of the object
        return "Individual{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
