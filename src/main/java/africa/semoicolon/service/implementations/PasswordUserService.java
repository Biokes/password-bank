package africa.semoicolon.service.implementations;

import africa.semoicolon.Exception.UserAlreadyExistException;
import africa.semoicolon.Exception.UserNotFoundException;
import africa.semoicolon.data.model.User;
import africa.semoicolon.data.repo.UserRepository;
import africa.semoicolon.dto.request.CreateUserRequest;
import africa.semoicolon.dto.request.CreateWebDetailsRequest;
import africa.semoicolon.dto.request.UpdatePasswordRequest;
import africa.semoicolon.service.interFace.UserService;
import africa.semoicolon.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static africa.semoicolon.utils.Validator.validate;
import static africa.semoicolon.utils.Validator.validateCreateRequest;
@Service
public class PasswordUserService implements UserService{
    public void deleteAll(){
        userRepository.deleteAll();
        passwordDetails.deleteAll();
    }
    public void register(CreateUserRequest createRequest){
        validateCreateRequest(createRequest);
        validateUserNameExistence(createRequest.getUsername());
        userRepository.save(Mapper.mapToUser(createRequest));
    }
    public long count(){
        return userRepository.count();
    }
    public void saveSiteDetails(CreateWebDetailsRequest webDetails){
        findUserByUsername(webDetails.getUsername());
        passwordDetails.saveDetails(webDetails);
    }
    public long countnAllUserDetails(String username){
        validate(username);
        findUserByUsername(username);
        return passwordDetails.countByUsername(username);
    }

    @Override
    public void updateSiteDetails(UpdatePasswordRequest webPassDetails){
        validateUserNameExistence(webPassDetails.getUsername( ));
        passwordDetails.updateWebsiteDetails(webPassDetails);
    }

    private void validateUserNameExistence(String username){
        List<User> users = userRepository.findAll();
        for(User user : users){
            if(user.getUsername().equalsIgnoreCase(username))
                throw new UserAlreadyExistException();
        }
    }
    private void findUserByUsername(String username){
      Optional<User> user = userRepository.findByUsername(username);
      if( user.isEmpty() )
          throw new UserNotFoundException();
    }
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordManagerDetailsSevice passwordDetails;
}
