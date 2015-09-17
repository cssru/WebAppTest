package test.config;

import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.AnnotationTransactionAttributeSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.interceptor.TransactionAttributeSource;
import org.springframework.transaction.interceptor.TransactionInterceptor;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import test.dao.HomoDao;
import test.dao.impl.HomoDaoImpl;
import test.service.HomoService;
import test.service.impl.HomoServiceImpl;
import test.service.impl.UserDetailsServiceImpl;

@Configuration
@EnableWebMvc
@ComponentScan("test")
@EnableTransactionManagement
@Import(LocalBeansConfig.class)
public class WebAppConfig extends WebMvcConfigurerAdapter {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}

	@Bean
	public ViewResolver getViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		resolver.setViewClass(JstlView.class);
		return resolver;
	}

	@Bean
	public UserDetailsService userDetailsService(){
		return new UserDetailsServiceImpl();
	}

	@Bean
	public DataSource dataSource() {
		EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
		EmbeddedDatabase database = builder
				.setName("test")
				.setType(EmbeddedDatabaseType.H2)
				.addScript("create_db.sql")
				.build();
		return database;
	}

	@Bean
	public SessionFactory sessionFactory() {
		LocalSessionFactoryBean result = new LocalSessionFactoryBean();
		result.setDataSource(dataSource());
		result.setPackagesToScan("test.domain");
		Properties hibernateProperties = new Properties();
		hibernateProperties.put("hibernate.show_sql", true);
		hibernateProperties.put("hibernate.show_statistics", true);
		hibernateProperties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");

		result.setHibernateProperties(hibernateProperties);
		try {
			result.afterPropertiesSet();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result.getObject();
	}

	@Bean
	public PlatformTransactionManager transactionManager() {
		HibernateTransactionManager result = new HibernateTransactionManager(sessionFactory());
		return result;
	}

	@Bean
	public TransactionAttributeSource annotationTransactionAttributeSource() {
		return new AnnotationTransactionAttributeSource();
	}

	@Bean
	public TransactionInterceptor transactionInterceptor() {
		return new TransactionInterceptor(transactionManager(), annotationTransactionAttributeSource());
	}
}