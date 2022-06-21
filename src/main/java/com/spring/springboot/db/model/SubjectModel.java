package com.spring.springboot.db.model;

public class SubjectModel {

    private String name;
    private String description;
    private String numberofclasses;

    private String email;

    public SubjectModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNumberofclasses() {
        return numberofclasses;
    }

    public void setNumberofclasses(String numberofclasses) {
        this.numberofclasses = numberofclasses;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "SubjectModel{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", numberofclasses='" + numberofclasses + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
