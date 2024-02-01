package com.example.pnlchecker.client;

import feign.Feign;
import feign.gson.GsonDecoder;

public class FeignBuilder {
    public static PNLClient buildClient() {
        return Feign.builder()
                .decoder(new GsonDecoder())
                .target(PNLClient.class, "https://demo5360542.mockable.io/");
    }
}
