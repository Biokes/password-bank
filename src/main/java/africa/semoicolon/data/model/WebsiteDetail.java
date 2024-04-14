package africa.semoicolon.data.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("WebsiteDetails")
public class WebsiteDetail{
    @Id
    private String id;
    private String username;
    private String websiteUsername;
    private String websitePassword;
    private String websiteName;
}
