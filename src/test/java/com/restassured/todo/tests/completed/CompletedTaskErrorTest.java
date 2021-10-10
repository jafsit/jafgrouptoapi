package com.restassured.todo.tests.completed;

import com.restassured.todo.dtos.createList.request.CreateListDTO;
import com.restassured.todo.dtos.createtask.request.CreateTaskDTO;
import com.restassured.todo.dtos.patchCompleted.request.CompletedTaskDTO;
import com.restassured.todo.tests.BaseTest;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

@Epic("Completed Task Error Test")
@Feature("Completed Task Error Test")
@DisplayName("Completed Task Error Test - tests to verify Completed scenarios")
public class CompletedTaskErrorTest extends BaseTest {

    @Test
    @DisplayName("Completed Task  Error Test - tests to verify Completed scenarios")
    void shouldGetErrorForInvalidRequest()throws IOException {
        createListTaskSteps
                .givenIHaveCompleteTaskEndpointAndPayload(new CompletedTaskDTO())
                .whenICompleteTaskRequest()
                .thenIVerifyError(HttpStatus.SC_INTERNAL_SERVER_ERROR);
    }

}

