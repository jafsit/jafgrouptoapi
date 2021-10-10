package com.restassured.todo.tests.createlist;

import com.restassured.todo.dtos.createList.request.CreateListDTO;
import com.restassured.todo.tests.BaseTest;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Stream;

@Epic("Create List- Error ")
@Feature("Create List -Error ")
@DisplayName("Create List details - tests to verify Create List Error scenarios")
public class CreateListTestError extends BaseTest {

    @ParameterizedTest(name = "#{index} - {0}")
    @MethodSource("dataProvider")
    @DisplayName("should get Failure")
    void shouldGetFailureForInValidRequests(final String description, final CreateListDTO createListDTO) {
        createListTaskSteps
                .givenIHaveToDoEndPointAndPayload(createListDTO)
                .whenICreateListRequestWithInvalidMethod()
                .thenIVerifyError(HttpStatus.SC_NOT_FOUND);
    }

    private static Stream<Arguments> dataProvider() {
        return  Stream.of(
                Arguments.of("should get success Response",new CreateListDTO()));
    }
}
