package africa.semoicolon.service.interFace;

import africa.semoicolon.dto.request.CreateWebDetailsRequest;
import africa.semoicolon.dto.request.DeleteWebDetails;
import africa.semoicolon.dto.request.UpdatePasswordRequest;
import africa.semoicolon.dto.request.ViewAllRequest;
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
