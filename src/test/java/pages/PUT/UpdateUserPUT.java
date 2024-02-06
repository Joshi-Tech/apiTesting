package pages.PUT;

import apiEngine.model.requests.UpdateUserStatus;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pages.BasePage;

public class UpdateUserPUT extends BasePage {

    private String endpoint;

    public UpdateUserPUT(String endpoint) {
        this.endpoint = endpoint;
    }

    public RequestSpecification postRequest() {
        RestAssured.baseURI = "https://reqres.in";
        RequestSpecification httpRequest = RestAssured.given().basePath(endpoint);
        return httpRequest;
    }

    public RequestSpecification providePayLoad(String name, String job) {
        UpdateUserStatus updateUser = new UpdateUserStatus(name, job);
        postRequest().contentType(ContentType.JSON);
        RequestSpecification payload = postRequest().body(updateUser.toString());
        postRequest().header("Content-Type", "application/json");
        return payload;
    }

    public int PUTResponse(String name, String job) {
        Response response = providePayLoad(name, job).put();
        response.getBody().asString();
        return response.statusCode();
    }
}
