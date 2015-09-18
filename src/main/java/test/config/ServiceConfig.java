package test.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import test.service.PersonService;
import test.service.impl.PersonServiceImpl;

@Configuration
public class ServiceConfig {

    @Bean
    public PersonService personService() {
        return new PersonServiceImpl();
    }

}
