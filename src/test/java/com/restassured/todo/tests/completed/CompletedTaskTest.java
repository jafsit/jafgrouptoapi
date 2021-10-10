package com.restassured.todo.tests.completed;

import com.restassured.todo.dtos.createList.request.CreateListDTO;
import com.restassured.todo.dtos.createtask.request.CreateTaskDTO;
import com.restassured.todo.dtos.patchCompleted.request.CompletedTaskDTO;
import com.restassured.todo.tests.BaseTest;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

@Epic("Completed Task Test")
@Feature("Completed Task Test")
@DisplayName("Completed Task Test - tests to verify Completed scenarios")
public class CompletedTaskTest extends BaseTest {

    @Test
    @DisplayName("Completed Task Test - tests to verify Completed scenarios")
    void shouldMarkTaskCompleted()throws IOException {
        createListTaskSteps
                .givenIHaveToDoEndPointAndPayload(new CreateListDTO())
                .whenICreateListRequest()
                .thenIVerifyCreateListResponseSuccessfully()
                .givenIHaveCreateTaskEndpointAndPayload(new CreateTaskDTO())
                .whenICreateTaskRequest()
                .thenIVerifyCreateTaskResponseSuccessfully()
                .givenIHaveCompleteTaskEndpointAndPayload(new CompletedTaskDTO())
                .whenICompleteTaskRequest()
                .thenIVerifyCompletedTaskResponseSuccessfully();
    }

}

