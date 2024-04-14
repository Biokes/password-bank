package africa.semoicolon.service;

import africa.semoicolon.data.model.WebsiteDetail;
import africa.semoicolon.data.repo.WebsiteRepository;
import africa.semoicolon.dto.CreateWebDetailsRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static africa.semoicolon.utils.Mapper.mapWebDetails;

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
        return repository.countByUsername(username);
    }
}
