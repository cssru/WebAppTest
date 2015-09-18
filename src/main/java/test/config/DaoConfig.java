package test.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import test.dao.HomoDao;
import test.dao.impl.HomoDaoImpl;

@Configuration
public class DaoConfig {

    @Bean
    public HomoDao homoDao() {
        return new HomoDaoImpl();
    }

}
