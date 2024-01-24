package learn.rest_api_bank_backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectSecurityConfig {
    
    @Bean
    SecurityFilterChain defauFilterChain(HttpSecurity http) throws Exception {
        
        // This is how to deny ALL request with denyAll()
        // http.authorizeHttpRequests((request) -> request.anyRequest().denyAll())
        //     .formLogin(Customizer.withDefaults())
        //     .httpBasic(Customizer.withDefaults());
        
        // This is how to permit ALL request with denyAll()
        // http.authorizeHttpRequests((request) -> request.anyRequest().permitAll())
        //     .formLogin(Customizer.withDefaults())
        //     .httpBasic(Customizer.withDefaults());
        
            http.authorizeHttpRequests((request) -> request
            .requestMatchers("/myAccount", "/myLoans", "/myBalance", "/myCards").authenticated()
            .requestMatchers("/notices", "/contact").permitAll())
            .formLogin(Customizer.withDefaults())
            .httpBasic(Customizer.withDefaults());
        
        return http.build();
    }
}
