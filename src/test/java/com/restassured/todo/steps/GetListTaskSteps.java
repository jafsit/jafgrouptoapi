package com.restassured.todo.steps;

import com.restassured.todo.dtos.getList.response.GetListResponseDTO;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpStatus;
import org.springframework.stereotype.Component;

import static org.junit.jupiter.api.Assertions.*;

@Component
@Slf4j
public class GetListTaskSteps extends BaseSteps<GetListTaskSteps>{

    @Step
    public GetListTaskSteps givenIHaveGetPointAndPayload() {
        endPoint = endPoints.webListPath();
        return this;
    }

    @Step
    public GetListTaskSteps whenIGetListRequest() {
        response = apiCalls.getList(endPoint,headerUtils.getHeaders());
        return this;
    }

    @Step
    public GetListTaskSteps thenIVerifyResponseStatusCode() {
        log.info("*********** Response ****************** : " +response.getBody().asString());
        assertNotNull(response);
        assertEquals(HttpStatus.SC_OK,response.getStatusCode(),"Verify response status code");
        assertTrue(response.contentType().equals("application/json; charset=utf-8"));
        return this;
    }

    @Step
    public GetListTaskSteps thenIVerifyGetResponseSuccessfully() {
        thenIVerifyResponseStatusCode();
        getListResponseDTO = response.getBody().as(GetListResponseDTO.class);
        assertNotNull(getListResponseDTO.id() ,"verify id");
        assertNotNull(getListResponseDTO.name() ,"verify name");
        assertNotNull(getListResponseDTO.removable() ,"verify removable");
        return this;
    }
}
