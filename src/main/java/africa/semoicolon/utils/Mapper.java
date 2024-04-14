package africa.semoicolon.utils;

import africa.semoicolon.data.model.WebsiteDetail;
import africa.semoicolon.dto.CreateWebDetailsRequest;
import africa.semoicolon.dto.UpdatePasswordRequest;

import static africa.semoicolon.utils.Encryption.encrypt;

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
}
