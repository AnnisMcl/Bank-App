package com.example.mybankapp;

public class User {
    private int id;
    private String name;
    private String  lastname;

    public void User(int id, String name, String lastname){
        this.id=id;
        this.name=name;
        this.lastname=lastname;
    }


    public int getId() {
        return id;
    }
    public void setId(int i) {
        this.id=i;
    }

    public String getName() {
        return name;
    }
    public void setName(String n) {
        this.name=n;
    }


    public String getLastname() {
        return lastname;
    }
    public void setLastname(String i) {
        this.lastname=i;
    }
}


