package com.example.pnlchecker.models;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class MyData {
    private long id;
    private String symbol;
    private String buyExchange;
    private String sellExchange;
    private long time;
    private double pnl;

    // Constructors, getters, and setters



    public MyData() {
        // Default constructor
    }

//    public MyData(String column1, String column2, String column3, String column4, Double column5) {
//
//        this.column1 = column1;
//        this.column2 = column2;
//        this.column3 = column3;
//        this.column4 = column4;
//        this.column5 = column5;
//    }
//    public String getColumn1() {
//
//        return column1;
//    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getBuyExchange() {
        return buyExchange;
    }

    public void setBuyExchange(String buyExchange) {
        this.buyExchange = buyExchange;
    }

    public String getSellExchange() {
        return sellExchange;
    }

    public void setSellExchange(String sellExchange) {
        this.sellExchange = sellExchange;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public double getPnl() {
        return pnl;
    }

    public void setPnl(double pnl) {
        this.pnl = pnl;
    }


    // Constructors, getters, setters, etc.
   
}

