package com.restassured.todo.tests.getCalls;

import com.restassured.todo.tests.BaseTest;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Epic("Get List Task Test")
@Feature("Get List Task Test")
@DisplayName("Get List Test - tests to verify get list scenarios-through direct website ")
//note-in local-get calls shows route not defined message
public class GetListTaskTest extends BaseTest {
    @Test
    @DisplayName("should get success for Get List Request")
    void shouldGetSuccessForGetListValidRequests() {
        getListTaskSteps
                .givenIHaveGetPointAndPayload()
                .whenIGetListRequest()
                .thenIVerifyResponseStatusCode();
    }
}

