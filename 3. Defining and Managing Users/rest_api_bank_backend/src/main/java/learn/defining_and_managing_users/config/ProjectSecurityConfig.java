//ProjectSecurityConfig.java
package learn.defining_and_managing_users.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.InMemoryUserDetailsManagerConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
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

    //Configure users using InMemoeryUserDetailsManager
    @Bean
    public InMemoryUserDetailsManager userDetailsManager(){
        UserDetails admin = User.withDefaultPasswordEncoder()
            .username("admin")
            .password("pass")
            .authorities("admin")
            .build();

        UserDetails user = User.withDefaultPasswordEncoder()
            .username("user")
            .password("pass")
            .authorities("read")
            .build();

        return new InMemoryUserDetailsManager(admin, user);
    }
}
