package africa.semoicolon.service;

import africa.semoicolon.Exception.UserAlreadyExistException;
import africa.semoicolon.dto.request.CreateUserRequest;
import africa.semoicolon.service.interFace.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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

    }
}
