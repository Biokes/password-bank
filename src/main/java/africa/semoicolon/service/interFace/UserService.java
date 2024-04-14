package africa.semoicolon.service.interFace;

import africa.semoicolon.dto.request.CreateUserRequest;
import africa.semoicolon.dto.request.CreateWebDetailsRequest;
import org.springframework.stereotype.Service;

@Service
public interface UserService{
    void deleteAll();
    void register(CreateUserRequest createRequest);
    long count();

    void saveSiteDetails(CreateWebDetailsRequest webDetails);

    long countnAllUserDetails(String name);
}
