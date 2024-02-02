package apiEngine.model.requests;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class RegisterUser {
    private String email;
    private String password;
}
