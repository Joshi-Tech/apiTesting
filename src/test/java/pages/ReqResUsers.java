package pages;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.Test;

public class ReqResUsers {

    public Response getResponse(){
        RestAssured.baseURI = "https://reqres.in/";
        String endPoint="api/users";
        RequestSpecification httpRequest=RestAssured.given().basePath(endPoint);
        Response response = httpRequest.request(Method.GET);
        return response;
    }


    @Test
    public void statusCode(){
        Assert.assertEquals(200,getResponse().statusCode());
        //return getResponse().statusCode();
    }

    public static void main(String[] args) {
        ReqResUsers f=new ReqResUsers();
       // System.out.println("*****"+f. statusCode());
        RestAssured.baseURI = "https://fakestoreapi.com/products";
        String endPoint="products";
        RequestSpecification httpRequest=RestAssured.given().basePath(endPoint);
        Response response = httpRequest.request(Method.GET);
        System.out.println("Status Code: "+response.statusCode());
        System.out.println("Status Line: "+response.statusLine());
        System.out.println("Content Type: "+response.contentType());
        System.out.println();
    }
}
