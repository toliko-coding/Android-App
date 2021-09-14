package com.example.myapplication;

public class Disease {

    int id;
    String name;
    boolean status;
    String cure;
    String symptoms;

    public Disease(int id, String name, String cure, String symptoms) {
        this.id = id;
        this.name = name;
        this.cure = cure;
        this.status = false;
        this.symptoms = symptoms;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }


}
