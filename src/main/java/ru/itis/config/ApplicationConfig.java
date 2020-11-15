package ru.itis.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import ru.itis.repositories.PostRepository;
import ru.itis.repositories.PostRepositoryJdbcTemplateImpl;
import ru.itis.repositories.UsersRepository;
import ru.itis.repositories.UsersRepositoryJdbcTemplateImpl;
import ru.itis.services.*;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:db.properties")
@ComponentScan(basePackages = "ru.itis")
public class ApplicationConfig {

    @Autowired
    private Environment environment;

    @Bean
    public UsersService usersService() {
        return new UsersServiceImpl(usersRepository());
    }

    @Bean
    public SignInService signInService() {
        return new SignInServiceImpl(usersRepository());
    }

    @Bean
    public PostService postService() {
        return new PostServiceImpl(postRepository());
    }

    @Bean
    public SignUpService signUpService() {
        return new SignUpServiceImpl(usersRepository());
    }

    @Bean
    public UsersRepository usersRepository() {
        return new UsersRepositoryJdbcTemplateImpl(dataSource());
    }

    @Bean
    public PostRepository postRepository() {
        return new PostRepositoryJdbcTemplateImpl(dataSource());
    }

    @Bean
    public DataSource dataSource() {
        return new HikariDataSource(hikariConfig());
    }

    @Bean // создали bean с id = objectMapper
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }

    @Bean
    public HikariConfig hikariConfig() {
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setJdbcUrl(environment.getProperty("db.url"));
        hikariConfig.setMaximumPoolSize(Integer.parseInt(environment.getProperty("db.hikari.max-pool-size")));
        hikariConfig.setUsername(environment.getProperty("db.username"));
        hikariConfig.setPassword(environment.getProperty("db.password"));
        hikariConfig.setDriverClassName(environment.getProperty("db.driver-class-name"));
        return hikariConfig;
    }
}
