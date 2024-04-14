package africa.semoicolon.dto.request;

import lombok.Data;

@Data
public class CreateUserRequest{
    private String firstname;
    private String lastname;
    private String username;
    private String password;
}
