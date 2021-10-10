package com.restassured.todo.steps;

import com.restassured.todo.apicalls.ApiCalls;
import com.restassured.todo.dtos.createList.response.CreateListResponseDTO;
import com.restassured.todo.dtos.createtask.request.CreateTaskDTO;
import com.restassured.todo.dtos.createtask.response.CreateTaskResponseDTO;
import com.restassured.todo.dtos.getList.response.GetListResponseDTO;
import com.restassured.todo.dtos.patchCompleted.request.CompletedTaskDTO;
import com.restassured.todo.dtos.patchCompleted.response.CompletedTaskResponseDTO;
import com.restassured.todo.dtos.createList.request.CreateListDTO;
import com.restassured.todo.endpoints.EndPoints;
import com.restassured.todo.utils.HeaderUtils;
import io.restassured.response.Response;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseSteps<T extends BaseSteps<T>> {

    public Response             response;
    String                      endPoint;
    String                      payloadAsString;
    public Integer listId;
    public Integer taskId;
    public String taskText;
    CreateListResponseDTO createListResponseDTO;
    CreateListDTO createListDTO;
    CreateTaskResponseDTO createTaskResponseDTO;
    CreateTaskDTO createTaskDTO;
    CompletedTaskResponseDTO completedTaskResponseDTO;
    CompletedTaskDTO completedTaskDTO;
    GetListResponseDTO getListResponseDTO;

    @Autowired
    ApiCalls apiCalls;

    @Autowired
    EndPoints endPoints;

    @Autowired
    HeaderUtils headerUtils;
}
