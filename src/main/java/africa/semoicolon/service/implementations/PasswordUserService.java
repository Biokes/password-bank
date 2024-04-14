package africa.semoicolon.service.implementations;

import africa.semoicolon.Exception.UserAlreadyExistException;
import africa.semoicolon.data.model.User;
import africa.semoicolon.data.repo.UserRepository;
import africa.semoicolon.dto.request.CreateUserRequest;
import africa.semoicolon.service.interFace.UserService;
import africa.semoicolon.utils.Mapper;
import africa.semoicolon.utils.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static africa.semoicolon.utils.Validator.validateCreateRequest;

@Service
public class PasswordUserService implements UserService{
    public void deleteAll(){
        userRepository.deleteAll();
    }
    public void register(CreateUserRequest createRequest){
        validateCreateRequest(createRequest);
        validateUserExistence(createRequest.getUsername());
        userRepository.save(Mapper.mapToUser(createRequest));
    }

    private void validateUserExistence(String username){
        List<User> users = userRepository.findAll();
        for(User user : users){
            if(user.getUsername().equalsIgnoreCase(username))
                throw new UserAlreadyExistException();
        }
    }

    @Override
    public long count(){
        return userRepository.count();
    }

    @Autowired
    private UserRepository userRepository;
}
