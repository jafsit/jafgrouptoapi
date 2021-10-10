package com.restassured.todo.dtos.patchCompleted.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(fluent = true,chain = true)
public class CompletedTaskResponseDTO {

    @JsonProperty("text")
    private String text;
    @JsonProperty("listId")
    private Integer listId;
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("completed")
    private Boolean completed;
    @JsonProperty("touched")
    private String touched;
}