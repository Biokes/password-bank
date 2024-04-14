package africa.semoicolon.dto;

import lombok.Data;

@Data
public class UpdatePasswordRequest{
    private String username;
    private String password;
    private String sitePassword;
    private String sitename;

}
