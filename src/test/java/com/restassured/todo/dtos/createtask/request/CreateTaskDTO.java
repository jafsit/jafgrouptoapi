package com.restassured.todo.dtos.createtask.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalTime;

@Getter
@Setter
@Accessors(chain = true,fluent = true)
public class CreateTaskDTO {

    @JsonProperty("text")
    private String text = "Task"+LocalTime.now();

}
