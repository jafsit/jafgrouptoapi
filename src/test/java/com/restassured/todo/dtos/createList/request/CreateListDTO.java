package com.restassured.todo.dtos.createList.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalTime;

@Getter
@Setter
@Accessors(chain = true,fluent = true)
public class CreateListDTO {

    @JsonProperty("name")
    private String name = "List"+LocalTime.now();

}
