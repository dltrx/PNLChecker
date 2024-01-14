package com.example.pnlchecker.client;

import com.example.pnlchecker.domain.Response;

import feign.RequestLine;

public interface PNLClient {
    @RequestLine("GET")
    public Response getPNL();
}
