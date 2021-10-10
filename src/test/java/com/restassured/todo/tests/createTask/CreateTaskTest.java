package com.restassured.todo.tests.createTask;

import com.restassured.todo.dtos.createList.request.CreateListDTO;
import com.restassured.todo.dtos.createtask.request.CreateTaskDTO;
import com.restassured.todo.tests.BaseTest;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.time.LocalTime;
import java.util.stream.Stream;

@Epic("Create Task ")
@Feature("Create Task ")
@DisplayName("Create Task details - tests to verify Create Task scenarios")
public class CreateTaskTest extends BaseTest {

    @BeforeEach
    void shouldCreateListId() throws IOException {
        createListTaskSteps
                .givenIHaveToDoEndPointAndPayload(new CreateListDTO())
                .whenICreateListRequest()
                .thenIVerifyCreateListResponseSuccessfully();
    }

    @ParameterizedTest(name = "#{index} - {0}")
    @MethodSource("dataProvider")
    @DisplayName("should get success")
    void shouldGetSuccessForValidRequests(final String description, final CreateTaskDTO createTaskDTO) {
        createListTaskSteps
                .givenIHaveCreateTaskEndpointAndPayload(createTaskDTO)
                .whenICreateTaskRequest()
                .thenIVerifyCreateTaskResponseSuccessfully();
    }

    private static Stream<Arguments> dataProvider() {
        return  Stream.of(
                Arguments.of("should get success Response",new CreateTaskDTO()),
                Arguments.of("should get success Response for 2nd List",
                        new CreateTaskDTO().text("TaskTwo"+ LocalTime.now())));
    }
}
