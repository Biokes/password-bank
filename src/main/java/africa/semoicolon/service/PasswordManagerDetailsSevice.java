package africa.semoicolon.service;

import africa.semoicolon.Exception.SiteNotFoundException;
import africa.semoicolon.data.model.WebsiteDetail;
import africa.semoicolon.data.repo.WebsiteRepository;
import africa.semoicolon.dto.CreateWebDetailsRequest;
import africa.semoicolon.dto.DeleteWebDetails;
import africa.semoicolon.dto.UpdatePasswordRequest;
import africa.semoicolon.dto.ViewAllRequest;
import africa.semoicolon.dto.response.ViewAllResponse;
import africa.semoicolon.utils.Mapper;
import africa.semoicolon.utils.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static africa.semoicolon.utils.Mapper.mapUpdate;
import static africa.semoicolon.utils.Mapper.mapWebDetails;
import static africa.semoicolon.utils.Validator.validate;

@Service
public class PasswordManagerDetailsSevice implements WebsiteDetailsService{
    @Autowired
    private WebsiteRepository repository;
    public void deleteAll(){
        repository.deleteAll();
    }
    public void saveDetails(CreateWebDetailsRequest webDetails){
        Validator.validateCreateWebRequest(webDetails);
        WebsiteDetail details = mapWebDetails(webDetails);
        repository.save(details);
    }
    public long countByUsername(String username){
        validate(username);
        return repository.countByUsername(username);
    }
    public void deleteSite(DeleteWebDetails deleteDetails){
        Validator.validateDeleteSite(deleteDetails);
        validateSiteExistence(deleteDetails.getSiteName(), deleteDetails.getUsername( ));
        repository.deleteByUsernameAndWebsiteName(deleteDetails.getUsername(),
                deleteDetails.getSiteName());
    }
    public ViewAllResponse viewAllSiteDetails(ViewAllRequest request){
        Validator.validateViewRequest(request);
        ViewAllResponse response = new ViewAllResponse();
        List<WebsiteDetail> found =  repository.findAllByUsername(request.getUsername());
        response.setBody(matchDetailsToFound(found));
        return response;
    }
    public void updateWebsiteDetails(UpdatePasswordRequest updateRequest){
        Validator.validateUpdate(updateRequest);
        validateSiteExistence(updateRequest.getSitename(), updateRequest.getUsername( ));
        WebsiteDetail found = repository.findByWebsiteNameAndUsernameAndAndWebsiteUsername(
                updateRequest.getSitename(),
                updateRequest.getUsername(),
                updateRequest.getSiteUsername());
        if(found== null)
            throw new SiteNotFoundException();
        mapUpdate(updateRequest, found);
        repository.save(found);
    }
    private String matchDetailsToFound(List<WebsiteDetail> given){
        StringBuilder output = new StringBuilder();
        if(given.isEmpty()){
            output.append("no password saved yet");
            return output.toString();
        }
        for(WebsiteDetail details: given){
            output.append(String.format("Site : %s\nSite username : %s\n Website Password : %s\n",
                    details.getWebsiteName(), details.getWebsiteUsername(),
                    details.getWebsitePassword()));
        }
        return output.toString();
    }
    private void validateSiteExistence(String siteName, String username){
        Optional<WebsiteDetail> found = repository.findByWebsiteNameAndUsername(siteName, username);
        if( found.isEmpty())
            throw new SiteNotFoundException();
    }
}
