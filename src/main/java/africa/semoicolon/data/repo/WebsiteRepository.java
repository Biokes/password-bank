package africa.semoicolon.repo;


import africa.semoicolon.model.WebsiteDetail;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface WebsiteRepository extends MongoRepository<WebsiteDetail, String>{
}
