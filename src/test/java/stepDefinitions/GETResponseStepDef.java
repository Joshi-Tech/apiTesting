package stepDefinitions;

import apiEngine.model.responses.POST_PUTResponse;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.GET.SingleUser;
import pages.GET.UnknownUsers;
import pages.GET.UsersList;

import static utitlity.Constants.*;

public class GETResponseStepDef {
    private UnknownUsers unknownUsers;
    private SingleUser singleUser;
    private UsersList usersList;

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
            case USER_LIST -> {
                usersList = new UsersList(endpoint);
                usersList.getUserListRequest();
            }
        }
    }

    @Then("I should get status code:{int} for {string}")
    public void i_should_get_status_code_for(int statusCode, String userType) {
        switch (userType) {
            case "unknown user" -> Assert.assertEquals(statusCode, unknownUsers.getResponse().statusCode());
            case "single user" -> Assert.assertEquals(statusCode, singleUser.getSingleUserResponse().statusCode());
            case "users list" -> Assert.assertEquals(statusCode, usersList.getUserListResponse().statusCode());
        }
    }

    @Then("I should see an user with email:{string}")
    public void i_should_see_an_user_with_email(String email) {
        Assert.assertEquals(email, new POST_PUTResponse().getEmail("/api/users?page=2"));
    }
}
