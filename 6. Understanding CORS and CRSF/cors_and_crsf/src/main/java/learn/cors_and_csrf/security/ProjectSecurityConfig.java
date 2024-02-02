//ProjectSecurityConfig.java
package learn.cors_and_csrf.security;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectSecurityConfig {
    
    @Bean
    SecurityFilterChain defaultFilterChain(HttpSecurity http) throws Exception {
        
            http
                .authorizeHttpRequests((request) -> request
                .requestMatchers("/myAccount", "/myLoans", "/myBalance", "/myCards", "/user").authenticated()
                .requestMatchers("/notices", "/contact", "/register").permitAll())
                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults());

            http.csrf(csrf -> csrf.disable());
        
        return http.build();
    }

 
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
