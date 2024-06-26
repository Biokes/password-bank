package africa.semoicolon.data.repo;


import africa.semoicolon.data.model.WebsiteDetail;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface WebsiteRepository extends MongoRepository<WebsiteDetail, String>{
    long countByUsername(String username);
    void deleteByUsernameAndWebsiteName(String username, String WebsiteName);
    Optional<WebsiteDetail> findByWebsiteName(String siteName);
    List<WebsiteDetail> findAllByUsername(String username);

    WebsiteDetail findByWebsiteNameAndUsernameAndAndWebsiteUsername(String sitename,
                                                                    String username,
                                                                    String websiteUsername);

    Optional<WebsiteDetail> findByWebsiteNameAndUsername(String siteName, String username);
}
