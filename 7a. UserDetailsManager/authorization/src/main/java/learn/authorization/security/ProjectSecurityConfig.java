// ProjectSecurityConfig.java
package learn.authorization.security;
import java.util.Collections;
import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.csrf.CsrfTokenRequestAttributeHandler;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import jakarta.servlet.http.HttpServletRequest;
import learn.authorization.filter.CsrfCookieFilter;
import learn.authorization.model.Customer;
import learn.authorization.repository.CustomerRepository;

@Configuration
public class ProjectSecurityConfig {

    // Configuring the default security filter chain
    @Bean
    SecurityFilterChain defaultFilterChain(HttpSecurity http) throws Exception {

        // Creating a CsrfTokenRequestAttributeHandler for CSRF token handling
        CsrfTokenRequestAttributeHandler requestHandler = new CsrfTokenRequestAttributeHandler();
        requestHandler.setCsrfRequestAttributeName("_csrf");

        // Configuring security context and session management
        http.securityContext((context) -> context
                .requireExplicitSave(false))
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.ALWAYS));

        // Configuring CORS (Cross-Origin Resource Sharing) settings
        http.cors(cors -> cors.configurationSource(new CorsConfigurationSource() {
            @Override
            public CorsConfiguration getCorsConfiguration(@SuppressWarnings("null") HttpServletRequest request) {
                CorsConfiguration config = new CorsConfiguration();
                config.setAllowedOrigins(Collections.singletonList("http://localhost:3000"));
                config.setAllowedMethods(Collections.singletonList("*"));
                config.setAllowCredentials(true);
                config.setAllowedHeaders(Collections.singletonList("*"));
                config.setMaxAge(3600L);
                return config;
            }
        }));

        // Configuring authorization for different endpoints
        http
                .authorizeHttpRequests(request -> request
                        // .requestMatchers("/myAccount").hasAuthority("VIEWACCOUNT")
                        // .requestMatchers("/myBalance").hasAnyAuthority("VIEWACCOUNT", "VIEWBALANCE")
                        // .requestMatchers("/myLoans").hasAuthority("VIEWLOANS")
                        // .requestMatchers("/myCards").hasAuthority("VIEWCARDS")
                        .requestMatchers("/myAccount").hasAnyRole("user", "admin")
                        .requestMatchers("/myBalance").hasAnyRole("user", "admin")
                        .requestMatchers("/myLoans").hasRole("user")
                        .requestMatchers("/myCards").hasRole("user")
                        .requestMatchers("/user").authenticated()
                        // .requestMatchers("/myAccount", "/myLoans", "/myBalance", "/myCards",
                        // "/user").authenticated()
                        .requestMatchers("/contact", "/notices", "/register").permitAll())
                .formLogin(Customizer.withDefaults()) // Configuring form-based login
                .httpBasic(Customizer.withDefaults()); // Configuring HTTP Basic authentication

        // Configuring CSRF protection
        http.csrf((csrf) -> csrf
                .csrfTokenRequestHandler(requestHandler).ignoringRequestMatchers("/contact", "/register")
                .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()))
                .addFilterAfter(new CsrfCookieFilter(), BasicAuthenticationFilter.class);

        return http.build(); // Building and returning the configured security filter chain
    }

    @Bean
    public UserDetailsService userDetailsService(CustomerRepository customerRepository) {
        return email -> {
            List<Customer> customers = customerRepository.findByEmail(email);

            if (customers.isEmpty()) {
                throw new UsernameNotFoundException("User not found with email: " + email);
            }

            Customer customer = customers.get(0);

            return User.builder()
                    .username(customer.getEmail())
                    .password(customer.getPwd())
                    .roles(customer.getRole())
                    .build();
        };
    }

    // Creating a PasswordEncoder bean for encoding and decoding passwords
    @Bean
    public PasswordEncoder passwordEncoder() {
        // Use a secure password encoder, such as BCryptPasswordEncoder
        return new BCryptPasswordEncoder();
    }

}
