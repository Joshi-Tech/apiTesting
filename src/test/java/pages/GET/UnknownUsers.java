package pages.GET;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.AllArgsConstructor;
import pages.BasePage;


public class UnknownUsers extends BasePage {

   String endpoint;

   public UnknownUsers(String endpoint){
       this.endpoint=endpoint;
   }
    public RequestSpecification getUnknownUser(){
        baseRequest(endpoint);
        RequestSpecification httpRequest=RestAssured.given().basePath(endpoint);
      return httpRequest;
    }

    public Response getResponse(){
     Response response =   getUnknownUser().request(Method.GET);
     return response;
    }

}
