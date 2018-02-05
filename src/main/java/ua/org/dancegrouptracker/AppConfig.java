package ua.org.dancegrouptracker;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource({"classpath:spring-mvc-config.xml", "classpath:spring-database-config.xml"})
public class AppConfig {
}
