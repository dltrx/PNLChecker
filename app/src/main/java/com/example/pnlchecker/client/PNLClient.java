package com.example.pnlchecker.client;

import  com.example.pnlchecker.domain.Item;

import feign.RequestLine;

public interface PNLClient {
    @RequestLine("GET")
    public Item getPNL();
}
