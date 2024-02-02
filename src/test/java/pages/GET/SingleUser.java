package pages.GET;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pages.BasePage;

public class SingleUser extends BasePage {
    private String endpoint;
    public SingleUser(String endpoint){
        this.endpoint=endpoint;
    }

    public RequestSpecification getSingleUserRequest(){
        baseRequest(endpoint);
        RequestSpecification httpRequest=RestAssured.given().basePath(endpoint);
        return httpRequest;
    }

    public Response getSingleUserResponse(){
        Response response =   getSingleUserRequest().request(Method.GET);
        return response;
    }
}
