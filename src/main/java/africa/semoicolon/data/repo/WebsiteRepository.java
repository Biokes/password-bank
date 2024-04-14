package africa.semoicolon.data.repo;


import africa.semoicolon.data.model.WebsiteDetail;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface WebsiteRepository extends MongoRepository<WebsiteDetail, String>{
    long countByUsername(String username);

    void deleteByUsernameAndWebsiteName(String username, String WebsiteName);

    Optional<WebsiteDetail> findBySiteName(String siteName);
}
