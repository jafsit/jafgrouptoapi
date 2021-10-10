package com.restassured.todo.dtos.createtask.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@Getter
@Setter
@Accessors(fluent = true,chain = true)
public class CreateTaskResponseDTO {

    @JsonProperty("text")
    private String text;
    @JsonProperty("listId")
    private Integer listId;
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("completed")
    private Boolean completed;
    @JsonProperty("touched")
    private BigDecimal touched;
}