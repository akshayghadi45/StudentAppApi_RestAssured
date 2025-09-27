package org.example.model;

import java.util.List;


public class Student {
    private  String firstName;
    private   String lastName;
    private   String email;
    private   String programme;
    private List<String> cources;

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setProgramme(String programme) {
        this.programme = programme;
    }

    public void setCources(List<String> cources) {
        this.cources = cources;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getProgramme() {
        return programme;
    }

    public List<String> getCources() {
        return cources;
    }



}
