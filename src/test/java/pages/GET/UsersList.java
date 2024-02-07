package pages.GET;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pages.BasePage;

public class UsersList extends BasePage {

    private String endpoint;

    public UsersList(String endpoint) {
        this.endpoint = endpoint;
    }

    public RequestSpecification getUserListRequest() {
        baseRequest(endpoint);
        RequestSpecification httpRequest = RestAssured.given().basePath(endpoint);
        return httpRequest;
    }

    public Response getUserListResponse() {
        Response response = getUserListRequest().request(Method.GET);
        return response;
    }
}
