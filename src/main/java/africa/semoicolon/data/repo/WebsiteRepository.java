package africa.semoicolon.data.repo;


import africa.semoicolon.data.model.WebsiteDetail;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface WebsiteRepository extends MongoRepository<WebsiteDetail, String>{
    long countByUsername(String username);
}
