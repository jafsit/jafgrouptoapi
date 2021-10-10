package com.restassured.todo.dtos.getList.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(fluent = true,chain = true)
public class GetListResponseDTO {

    @JsonProperty("name")
    private String name;
    @JsonProperty("removable")
    private Boolean removable;
    @JsonProperty("id")
    private Integer id;
}