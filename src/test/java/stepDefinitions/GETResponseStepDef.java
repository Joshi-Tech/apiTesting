package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.GET.SingleUser;
import pages.GET.UnknownUsers;

import static utitlity.Constants.SINGLE_USER;
import static utitlity.Constants.UNKNOWN_USER;

public class GETResponseStepDef {
    private UnknownUsers unknownUsers;
    private SingleUser singleUser;

    @Given("I provide endpoint for user as : {string}")
    public void i_provide_endpoint_for_user_as(String endpoint) {
        switch (endpoint) {
            case UNKNOWN_USER -> {
                unknownUsers = new UnknownUsers(UNKNOWN_USER);
                unknownUsers.getUnknownUser();
            }
            case SINGLE_USER -> {
                singleUser = new SingleUser(SINGLE_USER);
                singleUser.getSingleUserRequest();
            }
        }
    }

    @Then("I should get status code:{int} for {string}")
    public void i_should_get_status_code_for(int statusCode, String userType) {
        switch (userType) {
            case "unknown user" -> Assert.assertEquals(statusCode, unknownUsers.getResponse().statusCode());
            case "single user" -> Assert.assertEquals(statusCode, singleUser.getSingleUserResponse().statusCode());
        }
    }
}
