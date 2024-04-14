package africa.semoicolon.repo.repositoryTest;

import africa.semoicolon.data.model.User;
import africa.semoicolon.data.repo.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class UserRepoTest{
    @Autowired
    private UserRepository userRepository;
    @BeforeEach
    public void wipe(){
        userRepository.deleteAll();
    }
    @Test
    public void saveUser_testUserIsSaved(){
        User user = new User();
        userRepository.save(user);
        assertEquals(1,userRepository.count());
    }

}
