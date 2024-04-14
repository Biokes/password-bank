package africa.semoicolon.service;

import africa.semoicolon.Exception.UserAlreadyExistException;
import africa.semoicolon.Exception.UserNotFoundException;
import africa.semoicolon.dto.request.CreateUserRequest;
import africa.semoicolon.dto.request.CreateWebDetailsRequest;
import africa.semoicolon.service.interFace.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.nio.file.attribute.UserPrincipalNotFoundException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class UserServiceTest{
    @Autowired
    private UserService userService;
    @BeforeEach
    public void wipe(){
        userService.deleteAll();
    }
    @Test
    public void createUser_testUserIsCreated(){
        CreateUserRequest createRequest = new CreateUserRequest();
        createRequest.setUsername("name");
        createRequest.setPassword("password");
        createRequest.setFirstname("firstName");
        createRequest.setLastname("lastname");
        userService.register(createRequest);
        assertThrows(UserAlreadyExistException.class,()->userService.register(createRequest));
        assertEquals(1,userService.count());
    }
    @Test
    public void createWebsiteDetails_testWebsiteDetailsIsCreated(){
        CreateWebDetailsRequest webDetails = new CreateWebDetailsRequest();
        webDetails.setUsername("name");
        webDetails.setSiteName("google");
        webDetails.setSitePassword("sitePassword");
        webDetails.setSiteUsername("userName");
        assertThrows(UserNotFoundException.class,()->userService.saveSiteDetails(webDetails));
        CreateUserRequest createRequest = new CreateUserRequest();
        createRequest.setUsername("name");
        createRequest.setPassword("password");
        createRequest.setFirstname("firstName");
        createRequest.setLastname("lastname");
        userService.register(createRequest);
        userService.saveSiteDetails(webDetails);
        assertEquals(1, userService.countnAllUserDetails("name"));
    }
}
