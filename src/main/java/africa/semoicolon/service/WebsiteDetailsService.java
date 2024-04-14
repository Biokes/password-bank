package africa.semoicolon.service;

import africa.semoicolon.dto.CreateWebDetailsRequest;
import org.springframework.stereotype.Service;

@Service
public interface WebsiteDetailsService{
    void deleteAll();

    void saveDetails(CreateWebDetailsRequest webDetails);

    long countByUsername(String name);
}
