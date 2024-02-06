package apiEngine.model.responses;

import io.restassured.response.Response;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import pages.POST.RegisterUserPOST;

@AllArgsConstructor
@NoArgsConstructor
public class POST_PUTResponse {
    public String token;
    private RegisterUserPOST registerUserPOST;

    public String getResponse(String endPoint, String email, String password) {
        registerUserPOST = new RegisterUserPOST(endPoint);
        Response response = registerUserPOST.getPOSTResponse(email, password);
        String createdAt = response.jsonPath().getString("createdAt").split("T")[0];
        return createdAt;
    }
}
