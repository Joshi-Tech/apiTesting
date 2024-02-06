package pages.POST;

import apiEngine.model.requests.RegisterUser;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.AllArgsConstructor;
import lombok.Data;
import pages.BasePage;

@AllArgsConstructor
@Data
public class RegisterUserPOST extends BasePage {
    private String endpoint;

    public RequestSpecification postRequest() {
        RestAssured.baseURI = "https://reqres.in/api/register";
        RequestSpecification httpRequest = RestAssured.given().basePath(endpoint);
        return httpRequest;
    }

    public RequestSpecification providePayLoad(String email, String password) {
        RegisterUser registerUser = new RegisterUser(email, password);
        postRequest().contentType(ContentType.JSON);
        RequestSpecification payload = postRequest().body(registerUser.toString());
        postRequest().header("Content-Type", "application/json");
        return payload;
    }

    public Response getPOSTResponse(String email, String password) {
        Response response = providePayLoad(email, password).post();
        return response;
    }

    public int POSTResponse(String email, String password) {
        Response response = providePayLoad(email, password).post();
        return response.statusCode();
    }
}
