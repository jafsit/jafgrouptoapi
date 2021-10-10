package com.restassured.todo.utils;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class HeaderUtils {

    public ArrayList<Header> defaultHeaders = new ArrayList<>();
    public Headers headers;

    public HeaderUtils setDefaultHeaders() {
        defaultHeaders.add(new Header("Accept","application/json, text/plain, */*"));
        defaultHeaders.add(new Header("Content-Type","application/json;charset=UTF-8"));
        headers = new Headers(defaultHeaders);
        return this;
    }

    public Headers getHeaders() {
        setDefaultHeaders();
        return headers;
    }

    public Headers modifyHeaderAndGetHeader(String headerName, String replacementValue) {
        getHeaders();
        defaultHeaders.remove(headers.get(headerName));
        defaultHeaders.add(new Header(headerName,replacementValue));
        headers = new Headers(defaultHeaders);
        return headers;
    }
}
