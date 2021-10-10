package com.restassured.todo.apicalls;

import com.restassured.todo.utils.RestUtils;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ApiCalls {

    @Autowired
    RestUtils restUtils;

    public Response getList(String endPointUrl, Headers headers) {
        return restUtils.get(endPointUrl, headers);
    }

    public Response getTask(String endPointUrl,Integer listId, Headers headers) {
        return restUtils.get(endPointUrl+"/"+listId+"/tasks", headers);
    }

    public Response deleteList(String endPointUrl, Integer listId) {
        return restUtils.delete(endPointUrl+"/"+listId);
    }

    public Response deleteTask(String endPointUrl, Integer taskId) {
        return restUtils.delete(endPointUrl+"/"+taskId);
    }

    public Response createList(String endPointUrl, String payload, Headers headers) {
        return restUtils.post(endPointUrl, payload, headers);
    }

    public Response createTask(String endPointUrl,Integer listId, String payload, Headers headers) {
        return restUtils.post(endPointUrl+"/"+listId+"/tasks", payload, headers);
    }

    public Response invalidCreateTask(String endPointUrl, String payload, Headers headers) {
        return restUtils.post(endPointUrl+"/$#@!/tasks", payload, headers);
    }

    public Response completeTask(String endPointUrl,Integer taskId, String payload, Headers headers) {
        return restUtils.patch(endPointUrl+"/"+taskId, payload, headers);
    }

    public Response createListWithInvalidRequest(String endPointUrl, String payload, Headers headers) {
        return restUtils.patch(endPointUrl, payload, headers);
    }
}
