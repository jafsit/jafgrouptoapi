package com.restassured.todo.tests.deleteListTask;

import com.restassured.todo.dtos.createList.request.CreateListDTO;
import com.restassured.todo.dtos.createtask.request.CreateTaskDTO;
import com.restassured.todo.tests.BaseTest;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.*;

import java.io.IOException;

@Epic("Delete List Task Test")
@Feature("Delete List Task Test")
@DisplayName("Delete List Test - tests to verify delete list scenarios")
public class DeleteListTaskTest extends BaseTest {

    @BeforeEach
    void shouldCreateListIdAndTaskId()throws IOException {
        createListTaskSteps
                .givenIHaveToDoEndPointAndPayload(new CreateListDTO())
                .whenICreateListRequest()
                .thenIVerifyCreateListResponseSuccessfully()
                .givenIHaveCreateTaskEndpointAndPayload(new CreateTaskDTO())
                .whenICreateTaskRequest()
                .thenIVerifyCreateTaskResponseSuccessfully();
    }

    @Test
    @DisplayName("should get success for Delete List Request")
    void shouldGetSuccessForDeleteListValidRequests() {
        deleteListTaskSteps
                .givenIHaveToDoDeleteListEndPointAndPayload()
                .whenIDeleteListRequest()
                .thenIVerifyResponseStatusCode();
    }

    @Test
    @DisplayName("should get success for Delete Task Request")
    void shouldGetSuccessForDeleteTaskValidRequests() {
        deleteListTaskSteps
                .givenIHaveToDoDeleteTaskEndPointAndPayload()
                .whenIDeleteTaskRequest()
                .thenIVerifyResponseStatusCode();
    }

}

