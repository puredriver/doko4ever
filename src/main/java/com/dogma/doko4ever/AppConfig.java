package com.dogma.doko4ever;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.expression.ParseException;
import org.springframework.format.Formatter;

@Configuration
// @EnableTransactionManagement
//@EnableScheduling
public class AppConfig {

	// private Environment env;

//	@Bean
//	public EntityManagerFactory entityManagerFactory() {
//
//		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
//		// vendorAdapter.setGenerateDdl(true);
//		// vendorAdapter.setShowSql(true);
//		// vendorAdapter.setDatabase(Database.POSTGRESQL);
//
//		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
//		factory.setJpaVendorAdapter(vendorAdapter);
//		factory.setPackagesToScan("com.dogma.doko4ever.model");
//		factory.setDataSource(dataSource());
//		// factory.setJpaDialect(PostgreSQL9Dialect.getDialect());
//		factory.setJpaProperties(hibernateProperties());
//		factory.afterPropertiesSet();
//
//		return factory.getObject();
//	}

//	@Bean
//	public ViewResolver viewResolver() {
//		SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
//		// templateResolver.setTemplateMode("XHTML");
//		templateResolver.setPrefix("templates/");
//		templateResolver.setSuffix(".html");
//		templateResolver.setCharacterEncoding("UTF-8");
//
//		SpringTemplateEngine engine = new SpringTemplateEngine();
//		engine.setTemplateResolver(templateResolver);
//
//		ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
//		viewResolver.setTemplateEngine(engine);
//		viewResolver.setContentType("text/html; charset=UTF-8");
//		viewResolver.setCharacterEncoding("UTF-8");
//		return viewResolver;
//	}
//
//	@Bean
//	public Properties hibernateProperties() {
//		Properties properties = new Properties();
//		properties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQL95Dialect");
//		properties.put("hibernate.show_sql", "true");
//		properties.put("hibernate.hbm2ddl.auto", "update");
//		properties.put("hibernate.jdbc.lob.non_contextual_creation", "true");
//		// properties.put("hibernate.search.default.directory_provider", "filesystem");
//		// index pfad in properties
//		// properties.put("hibernate.search.default.indexBase",
//		// "C:\\Users\\Andre.Jacobi\\Desktop\\tmp\\backofficeindex");
//
//		return properties;
//	}

//	@Bean(name = "dataSource")
//	public BasicDataSource dataSource() {
//		BasicDataSource rtn = new BasicDataSource();
//		rtn.setDriverClassName(env.getProperty("db.driverClassName"));
//		rtn.setUrl(env.getProperty("db.url"));
//		rtn.setUsername(env.getProperty("db.username"));
//		rtn.setPassword(env.getProperty("db.password"));
//		return rtn;

	// StringBuffer url = new StringBuffer();
	// url.append("jdbc:postgresql://");

	// amazon aws
	// String dbName = System.getProperty("RDS_DB_NAME");
	// String userName = System.getProperty("RDS_USERNAME");
	// String password = System.getProperty("RDS_PASSWORD");
	// String hostname = System.getProperty("RDS_HOSTNAME");
	// String port = System.getProperty("RDS_PORT");
	// localhost
	// extract to propties files
	// String dbName = "myclub_dev";
	// String userName = "postgres";
	// String password = "postgres";
	// String hostname = "localhost";
	// String port = "5432";
	//
	// url.append(hostname);
	// url.append(":");
	// url.append(port);
	// url.append("/");
	// url.append(dbName);

	//
	// localhost
	// rtn.setUsername("root");
	// rtn.setPassword("");

//	}

//	@Bean
//	public PlatformTransactionManager transactionManager() {
//
//		JpaTransactionManager txManager = new JpaTransactionManager();
//		txManager.setEntityManagerFactory(entityManagerFactory());
//		return txManager;
//	}

	@Bean
	public Formatter<LocalDate> localDateFormatter() {
		return new Formatter<LocalDate>() {
			@Override
			public LocalDate parse(String text, Locale locale) throws ParseException {
				return LocalDate.parse(text, DateTimeFormatter.ISO_DATE);
			}

			@Override
			public String print(LocalDate object, Locale locale) {
				return DateTimeFormatter.ISO_DATE.format(object);
			}
		};
	}

	@Bean
	public Formatter<LocalDateTime> localDateTimeFormatter() {
		return new Formatter<LocalDateTime>() {
			@Override
			public LocalDateTime parse(String text, Locale locale) throws ParseException {
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
				return LocalDateTime.parse(text, formatter);
			}

			@Override
			public String print(LocalDateTime object, Locale locale) {
				// return DateTimeFormatter.ISO_DATE_TIME.format(object);

				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
				return formatter.format(object);

			}
		};
	}

	/*
	 * @Bean public LogRequestFilter requestLoggingFilter() {
	 * 
	 * return new LogRequestFilter(); }
	 */

	/**
	 * Enables the Pageable request param in the controller class
	 *
	 * @param argumentResolvers
	 * 
	 *                          public void
	 *                          addArgumentResolvers(List<HandlerMethodArgumentResolver>
	 *                          argumentResolvers) {
	 *                          PageableHandlerMethodArgumentResolver resolver = new
	 *                          PageableHandlerMethodArgumentResolver();
	 *                          resolver.setFallbackPageable(new PageRequest(0, 5));
	 *                          argumentResolvers.add(resolver); }
	 */

}
