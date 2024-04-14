package africa.semoicolon.service;

import africa.semoicolon.dto.request.CreateUserRequest;
import africa.semoicolon.service.interFace.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
        userService.register(createRequest);

    }
}
