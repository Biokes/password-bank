package africa.semoicolon.service;

import africa.semoicolon.data.model.WebsiteDetail;
import africa.semoicolon.data.repo.WebsiteRepository;
import africa.semoicolon.dto.CreateWebDetailsRequest;
import africa.semoicolon.dto.DeleteWebDetails;
import africa.semoicolon.utils.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        repository.deleteByUsernameAndWebsiteName(deleteDetails.getUsername(),
                deleteDetails.getSiteName());
    }
}
