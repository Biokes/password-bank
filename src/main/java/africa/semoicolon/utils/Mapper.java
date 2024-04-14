package africa.semoicolon.utils;

import africa.semoicolon.data.model.WebsiteDetail;
import africa.semoicolon.dto.CreateWebDetailsRequest;

public class Mapper{
    public static WebsiteDetail mapWebDetails(CreateWebDetailsRequest detail){
        WebsiteDetail sitedetails = new WebsiteDetail();
        sitedetails.setWebsiteUsername(detail.getSiteUsername());
        sitedetails.setUsername(detail.getUsername());
        sitedetails.setWebsitePassword(detail.getSitePassword());
        sitedetails.setWebsiteName(detail.getSiteName());
        return sitedetails;
    }
}
