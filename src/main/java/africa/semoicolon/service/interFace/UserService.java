package africa.semoicolon.service.interFace;

import africa.semoicolon.dto.request.CreateUserRequest;
import org.springframework.stereotype.Service;

@Service
public interface UserService{
    void deleteAll();

    void register(CreateUserRequest createRequest);
}
