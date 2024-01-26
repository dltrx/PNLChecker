package com.example.pnlchecker;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "item_table")
public class Item {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String symbol;
    private String buyExchange;
    private String sellExchange;
    private String time;
    private double pnl;

    public Item(String symbol, String buyExchange, String sellExchange, String time, double pnl) {
        this.symbol = symbol;
        this.buyExchange = buyExchange;
        this.sellExchange = sellExchange;
        this.time = time;
        this.pnl = pnl;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getBuyExchange() {
        return buyExchange;
    }

    public String getSellExchange() {
        return sellExchange;
    }

    public String getTime() {
        return time;
    }

    public double getPnl() {
        return pnl;
    }
}
