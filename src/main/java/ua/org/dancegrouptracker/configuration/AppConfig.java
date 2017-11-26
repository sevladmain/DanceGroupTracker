package ua.org.dancegrouptracker.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource({"classpath:spring-mvc-config.xml", "classpath:applicationContext.xml"})
public class AppConfig {
}
