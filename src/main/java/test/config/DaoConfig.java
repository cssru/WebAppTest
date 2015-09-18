package test.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import test.dao.PersonDao;
import test.dao.impl.PersonDaoImpl;

@Configuration
public class DaoConfig {

    @Bean
    public PersonDao personDao() {
        return new PersonDaoImpl();
    }

}
