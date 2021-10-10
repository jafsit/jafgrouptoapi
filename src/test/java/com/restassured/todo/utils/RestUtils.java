package com.restassured.todo.utils;

import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static io.restassured.RestAssured.given;

@Component
public class RestUtils {

    @Autowired
    HeaderUtils headerUtils;

    public Response get (String endPointUrl,Headers headers) {
        return given()
                .headers(headers)
                .relaxedHTTPSValidation()
                .log()
                .all()
                .get(endPointUrl);
    }

    public Response post (String endPointUrl,String payload,Headers headers) {
        return given()
                .headers(headers)
                .relaxedHTTPSValidation()
                .log()
                .all()
                .body(payload)
                .post(endPointUrl);
    }

    public Response patch (String endPointUrl,String payload,Headers headers) {
        return given()
                .headers(headers)
                .relaxedHTTPSValidation()
                .log()
                .all()
                .body(payload)
                .patch(endPointUrl);
    }

    public Response delete(String endPointUrl) {
        return given()
                .relaxedHTTPSValidation()
                .headers(headerUtils.getHeaders())
                .log()
                .all()
                .delete(endPointUrl);
    }
}
