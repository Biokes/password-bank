package africa.semoicolon.service.implementations;

import africa.semoicolon.data.repo.UserRepository;
import africa.semoicolon.dto.request.CreateUserRequest;
import africa.semoicolon.service.interFace.UserService;
import africa.semoicolon.utils.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PasswordUserService implements UserService{
    public void deleteAll(){
        userRepository.deleteAll();
    }
    public void register(CreateUserRequest createRequest){
        Validator.validateCreateRequest(createRequest);
    }

    @Autowired
    private UserRepository userRepository;
}
