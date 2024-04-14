package africa.semoicolon.service;

import africa.semoicolon.dto.CreateWebDetailsRequest;
import africa.semoicolon.dto.DeleteWebDetails;
import africa.semoicolon.dto.UpdatePasswordRequest;
import africa.semoicolon.dto.ViewAllRequest;
import africa.semoicolon.dto.response.ViewAllResponse;
import org.springframework.stereotype.Service;

@Service
public interface WebsiteDetailsService{
    void deleteAll();
    void saveDetails(CreateWebDetailsRequest webDetails);
    long countByUsername(String name);
    void deleteSite(DeleteWebDetails deleteDetails);
    ViewAllResponse viewAllSiteDetails(ViewAllRequest request);
    void updateWebsiteDetails(UpdatePasswordRequest updateRequest);
}
