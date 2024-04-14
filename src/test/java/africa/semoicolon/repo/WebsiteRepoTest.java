package africa.semoicolon.repo.repositoryTest;

import africa.semoicolon.data.model.WebsiteDetail;
import africa.semoicolon.data.repo.WebsiteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
    class WebsiteRepoTest{
        @Autowired
        private WebsiteRepository websiteRepository;
        @BeforeEach
        void setUp(){
            websiteRepository.deleteAll();
        }
        @Test
        public void saveWebsiteDetails_testWebsiteDetailsIsSaved(){
            WebsiteDetail details = new WebsiteDetail();
            websiteRepository.save(details);
            assertEquals(1,websiteRepository.count());
        }
}
