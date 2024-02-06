package pages.POST;

import apiEngine.model.requests.LoginUser;
import apiEngine.model.requests.RegisterUser;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pages.BasePage;

public class LoginUserPOST extends BasePage {
    private String endpoint;

    public LoginUserPOST(String endpoint){
        this.endpoint=endpoint;
    }


    public RequestSpecification postRequest() {
        RestAssured.baseURI = "https://reqres.in";
        RequestSpecification httpRequest = RestAssured.given().basePath(endpoint);
        return httpRequest;
    }

    public RequestSpecification providePayLoad(String email, String password) {
        LoginUser loginUser = new LoginUser(email,password);
        postRequest().contentType(ContentType.JSON);
        postRequest().header("Content-Type", "application/json");
        RequestSpecification payload = postRequest().body(loginUser.toString());
        return payload;
    }

    public int POSTResponse(String email, String password) {
        Response response = providePayLoad(email, password).post();
        System.out.println(response.body().jsonPath().getString( "token"));
       String json= response.asString();
        Object token = JsonPath.from(json).get("token");
        return response.statusCode();
    }
}
