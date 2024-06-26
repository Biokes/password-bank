package africa.semoicolon.utils;

import africa.semoicolon.data.model.User;
import africa.semoicolon.data.model.WebsiteDetail;
import africa.semoicolon.dto.request.CreateUserRequest;
import africa.semoicolon.dto.request.CreateWebDetailsRequest;
import africa.semoicolon.dto.request.UpdatePasswordRequest;

public class Mapper{
    public static WebsiteDetail mapWebDetails(CreateWebDetailsRequest detail){
        WebsiteDetail sitedetails = new WebsiteDetail();
        sitedetails.setWebsiteUsername(detail.getSiteUsername());
        sitedetails.setUsername(detail.getUsername());
        sitedetails.setWebsitePassword(detail.getSitePassword());
        sitedetails.setWebsiteName(detail.getSiteName());
        return sitedetails;
    }
    public static void mapUpdate(UpdatePasswordRequest updateRequest, WebsiteDetail found){
        found.setWebsitePassword(updateRequest.getSitePassword());
    }

    public static User mapToUser(CreateUserRequest createRequest){
        User user = new User();
        user.setFirstname(createRequest.getFirstname());
        user.setLastname(createRequest.getLastname( ));
        user.setUsername(createRequest.getUsername( ));
        user.setPassword(createRequest.getPassword( ));
        return user;
    }
}
