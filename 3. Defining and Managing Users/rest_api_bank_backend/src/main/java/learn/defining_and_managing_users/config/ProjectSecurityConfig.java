//ProjectSecurityConfig.java
package learn.defining_and_managing_users.config;
import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectSecurityConfig {
    
    @Bean
    SecurityFilterChain defaultFilterChain(HttpSecurity http) throws Exception {
        
            http.authorizeHttpRequests((request) -> request
            .requestMatchers("/myAccount", "/myLoans", "/myBalance", "/myCards").authenticated()
            .requestMatchers("/notices", "/contact").permitAll())
            .formLogin(Customizer.withDefaults())
            .httpBasic(Customizer.withDefaults());
        
        return http.build();
    }

    // @Bean
    // public UserDetailsService userDetailsService(DataSource dataSource){
    //     return new JdbcUserDetailsManager(dataSource);
    // }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }
}
