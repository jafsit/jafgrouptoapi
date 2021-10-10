package com.restassured.todo.steps;

import com.restassured.todo.dtos.createtask.request.CreateTaskDTO;
import com.restassured.todo.utils.JsonUtil;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpStatus;
import org.springframework.stereotype.Component;

import static org.junit.jupiter.api.Assertions.*;

@Component
@Slf4j
public class DeleteListTaskSteps extends BaseSteps<DeleteListTaskSteps> {

    @Step
    public DeleteListTaskSteps givenIHaveToDoDeleteListEndPointAndPayload() {
        endPoint = endPoints.listPath();
        return this;
    }

    @Step
    public DeleteListTaskSteps givenIHaveToDoDeleteTaskEndPointAndPayload() {
        endPoint = endPoints.taskPath();
        return this;
    }

    @Step
    public DeleteListTaskSteps givenIHaveCreateTaskEndpointAndPayload(CreateTaskDTO payload) {
        endPoint = endPoints.listPath();
        createTaskDTO = payload;
        payloadAsString = JsonUtil.getJsonStringFromPojo(payload);
        log.info("-------payload---------" + payloadAsString);
        return this;
    }

    @Step
    public DeleteListTaskSteps whenICreateListRequest() {
        response = apiCalls.createList(endPoint,payloadAsString,headerUtils.getHeaders());
        return this;
    }

    @Step
    public DeleteListTaskSteps whenIDeleteListRequest() {
        response = apiCalls.deleteList(endPoint, listId);
        return this;
    }

    @Step
    public DeleteListTaskSteps whenIDeleteTaskRequest() {
        response = apiCalls.deleteTask(endPoint, taskId);
        return this;
    }

    @Step
    public DeleteListTaskSteps thenIVerifyResponseStatusCode() {
        assertEquals(HttpStatus.SC_NO_CONTENT,response.getStatusCode(),"Verify response status code");
        return this;
    }

    @Step
    public DeleteListTaskSteps thenIVerifyError(int httpStatus) {
        log.info("*********** Response ****************** : " +response.getBody().asString());
        assertEquals(httpStatus,response.getStatusCode(),"Verify error status code");
        return this;
    }
}
