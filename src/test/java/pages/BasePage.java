package pages;



import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class BasePage {
    public  RequestSpecification httpRequest;
    public RequestSpecification baseRequest(String endPoint) {
        RestAssured.baseURI = "https://reqres.in/";
        httpRequest = RestAssured.given().basePath(endPoint);
        return httpRequest;
    }

}
