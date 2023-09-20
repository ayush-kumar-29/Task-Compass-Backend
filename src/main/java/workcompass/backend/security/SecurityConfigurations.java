package workcompass.backend.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SecurityConfigurations implements WebMvcConfigurer  {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:3000")
                .allowedMethods("*")
                .allowedHeaders("*");
//                .allowCredentials(true)
//                .maxAge(3600);
    }
//    @Bean
//    public WebMvcConfigurer configureCors() {
//        return new WebMvcConfigurer() {
//            public void addCorsMappings(CorsRegistry registry) {
//                registry.addMapping("/**") // Define the endpoint(s) to allow CORS for
//                        .allowedMethods("*") // Specify the allowed HTTP methods (GET, POST etc)
//                        .allowedOrigins("http://localhost:3000"); // Specify the allowed origin(s) for CORS requests
//            }
//        };
//    }
}
