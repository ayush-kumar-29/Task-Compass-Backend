package workcompass.backend.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//import workcompass.backend.auth.JwtAuthenticationFilter;


@Configuration
public class CorsConfigurations implements WebMvcConfigurer {
//    @Autowired
//    private JwtAuthenticationFilter jwtAuthFilter;
//    @Autowired
//    private AuthenticationProvider authenticationProvider;

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
//    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
//        httpSecurity
//                .authorizeHttpRequests(
//                        req -> {
//                            req.requestMatchers("/auth/**").permitAll();
//                            req.anyRequest().authenticated();
//                        }
//                )
//                .sessionManagement(
//                        strategy -> {
//                            strategy.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//                        }
//                )
//                .authenticationProvider(authenticationProvider)
//                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);


//        return httpSecurity.build();
//    }
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
