package apiEngine.model.requests;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class LoginUser {
    private String email;
    private String password;
}
