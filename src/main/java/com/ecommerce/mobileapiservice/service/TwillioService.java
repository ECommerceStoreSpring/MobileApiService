package com.ecommerce.mobileapiservice.service;

public interface TwillioService {

    public void sendSms(String to, String from, String body);
    
}
