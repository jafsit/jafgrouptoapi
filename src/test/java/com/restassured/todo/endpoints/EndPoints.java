package com.restassured.todo.endpoints;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
@RequiredArgsConstructor
public class EndPoints {

    @Value("${listURI}")
    private String listURI;

    @Value("${taskURI}")
    private String taskURI;

    @Value("${webListURI}")
    private String webListURI;

    public String listPath() { return listURI;}

    public String taskPath() {
        return taskURI;
    }

    public String webListPath() { return webListURI; }

}
