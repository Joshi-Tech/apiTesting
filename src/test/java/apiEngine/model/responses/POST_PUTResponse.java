package apiEngine.model.responses;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import pages.GET.UsersList;
import pages.POST.RegisterUserPOST;

@AllArgsConstructor
@NoArgsConstructor
public class POST_PUTResponse {
    public String token;
    private RegisterUserPOST registerUserPOST;
    private UsersList usersList;

    public String getResponse(String endPoint, String email, String password) {
        registerUserPOST = new RegisterUserPOST(endPoint);
        Response response = registerUserPOST.getPOSTResponse(email, password);
        String createdAt = response.jsonPath().getString("createdAt").split("T")[0];
        return createdAt;
    }

    public JsonPath getUserListResponse(String endPoint) {
        usersList = new UsersList(endPoint);
        Response response = usersList.getUserListResponse();
        JsonPath s = response.body().jsonPath();
        return s;
    }

    public String getEmail(String endPoint) {
        return getUserListResponse(endPoint).get("data.find{it.id==2}.email");
    }
}
