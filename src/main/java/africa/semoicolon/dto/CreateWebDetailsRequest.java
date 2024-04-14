package africa.semoicolon.dto;

import lombok.Data;

@Data
public class CreateWebDetailsRequest{
    private String username;
    private String siteName;
    private String siteUsername;
    private String sitePassword;
}
