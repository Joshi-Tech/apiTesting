package stepDefinitions;

import apiEngine.model.responses.POST_PUTResponse;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.PUT.UpdateUserPUT;

import java.time.LocalDate;

import static utitlity.Constants.UPDATE_USER;

public class PUTResponseStepDef {
    private UpdateUserPUT updateUserPUT;
    POST_PUTResponse response;

    @Given("I provide the end point for PUT request as : {string}")
    public void i_provide_the_end_point_for_put_request_as(String endpoint) {
        switch (endpoint) {
            case UPDATE_USER -> {
                updateUserPUT = new UpdateUserPUT(UPDATE_USER);
                updateUserPUT.postRequest();
            }
        }

    }

    @When("I provide the name as: {string} and job as: {string} to a {string} user")
    public void i_provide_the_name_as_and_job_as_to_a_user(String name, String job, String user) {
        switch (user) {
            case "update" -> updateUserPUT.providePayLoad(name, job);
        }
    }

    @Then("I should get PUT status code:{int} for {string}")
    public void i_should_get_put_status_code_for(int statusCode, String userType) {
        updateUserPUT.PUTResponse("morpheus", "zion resident");
        switch (userType) {
            case "update" -> Assert.assertEquals(statusCode, updateUserPUT.PUTResponse("morpheus", "zion resident"));
        }
    }

    @Then("the date create at should be today's date")
    public void the_date_create_at_should_be_today_s_date() {
        response = new POST_PUTResponse();
        Assert.assertEquals(LocalDate.now().toString(), response.getResponse("/api/register", "eve.holt@reqres.in", "pistol"));
    }
}
