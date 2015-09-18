package test.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import test.dao.HomoDao;
import test.dao.impl.HomoDaoImpl;
import test.service.HomoService;
import test.service.impl.HomoServiceImpl;

@Configuration
public class ServiceConfig {
    @Bean
    public HomoService homoService() {
        return new HomoServiceImpl();
    }

    @Bean
    public HomoDao homoDao() {
        return new HomoDaoImpl();
    }

}