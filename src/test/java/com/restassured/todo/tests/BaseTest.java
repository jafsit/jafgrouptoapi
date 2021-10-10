package com.restassured.todo.tests;

import com.restassured.todo.config.Config;
import com.restassured.todo.endpoints.EndPoints;
import com.restassured.todo.steps.CreateListTaskSteps;
import com.restassured.todo.steps.DeleteListTaskSteps;
import com.restassured.todo.steps.GetListTaskSteps;
import com.restassured.todo.utils.HeaderUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = Config.class)
@ExtendWith(SpringExtension.class)
@TestPropertySource({ "classpath:endpoints.properties" })
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@Slf4j
public class BaseTest {

    @Autowired
    EndPoints endPoints;

    @Autowired
    public CreateListTaskSteps createListTaskSteps;

    @Autowired
    public DeleteListTaskSteps deleteListTaskSteps;

    @Autowired
    public GetListTaskSteps getListTaskSteps;

    @Autowired
    public HeaderUtils headerUtils;

    @BeforeEach
    void beforeEach(TestInfo testInfo) {
        log.info("********* Start of the Test : " + testInfo.getDisplayName()+" ****************");
    }

    @AfterEach
    void afterEach(TestInfo testInfo) {
        log.info("********** End of the Test : " +testInfo.getDisplayName()+ " *****************");
    }
}
