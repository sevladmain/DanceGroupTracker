package ua.org.dancegrouptracker;

import org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource({"classpath:spring-mvc-config.xml"})
@ComponentScan
public class AppConfig {
    @Bean
    public PhysicalNamingStrategyStandardImpl namingStrategy() {
        return new PhysicalNamingStrategyStandardImpl();
    }
}
