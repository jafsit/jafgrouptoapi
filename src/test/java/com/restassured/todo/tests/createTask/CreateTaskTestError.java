package com.restassured.todo.tests.createTask;

import com.restassured.todo.dtos.createList.request.CreateListDTO;
import com.restassured.todo.dtos.createtask.request.CreateTaskDTO;
import com.restassured.todo.tests.BaseTest;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@Epic("Create Task- Error ")
@Feature("Create Task -Error ")
@DisplayName("Create Task Error Details - tests to verify Create Task Error scenarios")
public class CreateTaskTestError extends BaseTest {

    @ParameterizedTest(name = "#{index} - {0}")
    @MethodSource("dataProvider")
    @DisplayName("should get Failure On Invalid Request -List Id")
    void shouldGetFailureForInValidRequests(final String description, final CreateTaskDTO createTaskDTO) {
        createListTaskSteps
                .givenIHaveCreateTaskEndpointAndPayload(createTaskDTO)
                .whenICreateTaskRequestWithWrongPath()
                .thenIVerifyError(HttpStatus.SC_NOT_FOUND);
    }

    private static Stream<Arguments> dataProvider() {
        return  Stream.of(
                Arguments.of("should get failure on wrong path param",new CreateTaskDTO()));
    }
}
