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
        
            http.authorizeHttpRequests((request) -> request
            .requestMatchers("/myAccount", "/myLoans", "/myBalance", "/myCards").authenticated()
            .requestMatchers("/notices", "/contact").permitAll())
            .formLogin(Customizer.withDefaults())
            .httpBasic(Customizer.withDefaults());
        
        return http.build();
    }
}
