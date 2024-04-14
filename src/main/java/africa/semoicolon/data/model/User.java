package africa.semoicolon.data.model;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("Users")
public class User{
    @Id
    private String id;
    private String firstname;
    private String lastname;
    private String username;
    private String password;
}
