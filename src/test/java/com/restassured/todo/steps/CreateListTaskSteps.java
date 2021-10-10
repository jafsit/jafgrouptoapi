package com.restassured.todo.steps;

import com.restassured.todo.dtos.createList.request.CreateListDTO;
import com.restassured.todo.dtos.createList.response.CreateListResponseDTO;
import com.restassured.todo.dtos.createtask.request.CreateTaskDTO;
import com.restassured.todo.dtos.createtask.response.CreateTaskResponseDTO;
import com.restassured.todo.dtos.patchCompleted.request.CompletedTaskDTO;
import com.restassured.todo.dtos.patchCompleted.response.CompletedTaskResponseDTO;
import com.restassured.todo.utils.JsonUtil;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpStatus;
import org.springframework.stereotype.Component;

import static org.junit.jupiter.api.Assertions.*;

@Component
@Slf4j
public class CreateListTaskSteps extends BaseSteps<CreateListTaskSteps>{

    @Step
    public CreateListTaskSteps givenIHaveToDoEndPointAndPayload(CreateListDTO payload) {
        endPoint = endPoints.listPath();
        createListDTO = payload;
        payloadAsString = JsonUtil.getJsonStringFromPojo(payload);
        log.info("-------payload---------" + payloadAsString);
        return this;
    }

    @Step
    public CreateListTaskSteps givenIHaveCreateTaskEndpointAndPayload(CreateTaskDTO payload) {
        endPoint = endPoints.listPath();
        createTaskDTO = payload;
        payloadAsString = JsonUtil.getJsonStringFromPojo(payload);
        log.info("-------payload---------" + payloadAsString);
        return this;
    }

    @Step
    public CreateListTaskSteps givenIHaveCompleteTaskEndpointAndPayload(CompletedTaskDTO payload) {
        endPoint = endPoints.taskPath();
        completedTaskDTO = payload;
        payloadAsString = JsonUtil.getJsonStringFromPojo(payload);
        log.info("-------payload---------" + payloadAsString);
        return this;
    }

    @Step
    public CreateListTaskSteps whenICreateListRequest() {
        response = apiCalls.createList(endPoint,payloadAsString,headerUtils.getHeaders());
        return this;
    }

    @Step
    public CreateListTaskSteps whenICompleteTaskRequest() {
        response = apiCalls.completeTask(endPoint,taskId, payloadAsString,headerUtils.getHeaders());
        return this;
    }

    @Step
    public CreateListTaskSteps whenICreateTaskRequest() {
        response = apiCalls.createTask(endPoint, listId,payloadAsString,headerUtils.getHeaders());
        return this;
    }

    @Step
    public CreateListTaskSteps whenICreateTaskRequestWithWrongPath() {
        response = apiCalls.invalidCreateTask(endPoint,payloadAsString,headerUtils.getHeaders());
        return this;
    }

    @Step
    public CreateListTaskSteps whenICreateListRequestWithInvalidMethod() {
        response = apiCalls.createListWithInvalidRequest(endPoint,payloadAsString,headerUtils.getHeaders());
        return this;
    }

    @Step
    public CreateListTaskSteps thenIVerifyResponseStatusCode() {
        log.info("*********** Response ****************** : " +response.getBody().asString());
        assertNotNull(response);
        assertEquals(HttpStatus.SC_CREATED,response.getStatusCode(),"Verify response status code");
        assertTrue(response.contentType().equals("application/json; charset=utf-8"));
        return this;
    }

    @Step
    public CreateListTaskSteps thenIVerifyCreateListResponseSuccessfully() {
        thenIVerifyResponseStatusCode();
        createListResponseDTO = response.getBody().as(CreateListResponseDTO.class);
        listId = createListResponseDTO.id();
        assertEquals(createListDTO.name(), createListResponseDTO.name(),"verify name");
        assertEquals(true, createListResponseDTO.removable(),"verify removable status");
        assertNotNull(createListResponseDTO.id() ,"verify Id");
        return this;
    }
    @Step
    public CreateListTaskSteps thenIVerifyCompletedTaskResponseSuccessfully() {
        thenIVerifyResponseStatusCode();
        completedTaskResponseDTO = response.getBody().as(CompletedTaskResponseDTO.class);
        assertEquals(taskText,completedTaskResponseDTO.text(),"verify text");
        assertEquals(listId, completedTaskResponseDTO.listId(),"verify listId status");
        assertEquals(taskId, completedTaskResponseDTO.id(),"verify taskId status");
        assertEquals(true ,completedTaskResponseDTO.completed(),"verify completed");
        assertNotNull(completedTaskResponseDTO.touched() ,"verify touched id");
        return this;
    }

    @Step
    public CreateListTaskSteps thenIVerifyCreateTaskResponseSuccessfully() {
        thenIVerifyResponseStatusCode();
        createTaskResponseDTO = response.getBody().as(CreateTaskResponseDTO.class);
        taskId = createTaskResponseDTO.id();
        taskText = createTaskResponseDTO.text();
        assertEquals(createTaskDTO.text(), createTaskResponseDTO.text(),"verify text");
        assertEquals(false, createTaskResponseDTO.completed(),"verify text");
        assertNotNull(createTaskResponseDTO.listId() ,"verify ListId");
        assertNotNull(createTaskResponseDTO.id() ,"verify Id");
        assertNotNull(createTaskResponseDTO.touched() ,"verify touched");
        return this;
    }

    @Step
    public CreateListTaskSteps thenIVerifyError(int httpStatus) {
        log.info("*********** Response ****************** : " +response.getBody().asString());
        assertEquals(httpStatus,response.getStatusCode(),"Verify error status code");
        return this;
    }
}
