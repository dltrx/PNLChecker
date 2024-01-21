package com.example.pnlchecker.models;

public class MyData {
    private long id;
    private String column1;
    private String column2;
    private String column3;
    private String column4;
    private Double column5;


    public MyData() {
        // Default constructor
    }

    public MyData(String column1, String column2, String column3, String column4, Double column5) {

        this.column1 = column1;
        this.column2 = column2;
        this.column3 = column3;
        this.column4 = column4;
        this.column5 = column5;
    }
    public String getColumn1() {

        return column1;
    }

    // Constructors, getters, setters, etc.
}

