package stepDefinitions;

import apiEngine.model.responses.POST_PUTResponse;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.POST.LoginUserPOST;
import pages.POST.RegisterUserPOST;

import static utitlity.Constants.LOGIN_USER;
import static utitlity.Constants.REGISTER_USER;

public class POSTResponseStepDef {
    private RegisterUserPOST registerUserPOST;
    private LoginUserPOST loginUserPOST;

    @Given("I provide the end point for POST request as : {string}")
    public void i_provide_the_end_point_for_post_request_as(String endpoint) {
        switch (endpoint) {
            case REGISTER_USER -> {
                registerUserPOST = new RegisterUserPOST(REGISTER_USER);
                registerUserPOST.postRequest();
            }
            case LOGIN_USER -> {
                loginUserPOST = new LoginUserPOST(LOGIN_USER);
                loginUserPOST.postRequest();
            }
        }
    }

    @When("I provide the email as: {string} and password as: {string} to a {string} user")
    public void i_provide_the_email_as_and_password_as_to_a_use(String email, String password, String user) {
        switch (user) {
            case "login" -> loginUserPOST.providePayLoad(email, password);
            case "register" -> registerUserPOST.providePayLoad(email, password);
        }
    }

    @Then("I should get POST status code:{int} for {string}")
    public void i_should_get_post_status_code_for(int statusCode, String userType) {
        System.out.println(new POST_PUTResponse().getResponse("/api/register", "eve.holt@reqres.in", "pistol"));
        switch (userType) {
            case "register user" ->
                    Assert.assertEquals(statusCode, registerUserPOST.POSTResponse("xyz@abc.com", "password"));
            case "login user" -> Assert.assertEquals(statusCode, loginUserPOST.POSTResponse("xyz@abc.com", "password"));
        }
    }
}
