package com.restassured.todo.tests.createlist;

import com.restassured.todo.dtos.createList.request.CreateListDTO;
import com.restassured.todo.steps.CreateListTaskSteps;
import com.restassured.todo.tests.BaseTest;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Stream;

@Epic("Create List ")
@Feature("Create List ")
@DisplayName("Create List details - tests to verify Create List scenarios")
public class CreateListTest extends BaseTest {

    @ParameterizedTest(name = "#{index} - {0}")
    @MethodSource("dataProvider")
    @DisplayName("should get success")
    void shouldGetSuccessForValidRequests(final String description, final CreateListDTO createListDTO) {
        createListTaskSteps
                .givenIHaveToDoEndPointAndPayload(createListDTO)
                .whenICreateListRequest()
                .thenIVerifyCreateListResponseSuccessfully();
    }

    private static Stream<Arguments> dataProvider() {
        return  Stream.of(
                Arguments.of("should get success Response",new CreateListDTO()),
                Arguments.of("should get success Response for 2nd List",
                        new CreateListDTO().name("ListTwo"+ LocalTime.now())));
    }
}
