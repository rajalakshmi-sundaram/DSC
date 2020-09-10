package com.example.dsc.ui.home;

public class Events {
    private final String name;
    private final String date;

    public Events(String name, String date) {
        this.name = name;
        this.date = date;
    }
    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }
}
