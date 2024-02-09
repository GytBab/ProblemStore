package com.Babaitis.Project.ProblemStore.security.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@Profile("!unsecure")
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/login/**")
                        .permitAll()
                        .anyRequest()
                        .authenticated())
                .formLogin(loginConfigure -> loginConfigure
                        .permitAll()
                        .loginPage("/login")                //GET - the login form
                        .loginProcessingUrl("/login")       //Specifies the URL to validate the credentials.
                        .defaultSuccessUrl("/problems", true)
                        .usernameParameter("loginEmail")    //The HTTP parameter to look for the username
                        .passwordParameter("loginPassword")) //The HTTP parameter to look for the password
                .csrf(csrf -> csrf.disable())
                .cors(cors -> cors.disable())
                .build();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return web -> web.ignoring()
                .requestMatchers(
                        PathRequest.toH2Console(),
                        PathRequest.toStaticResources().atCommonLocations()
                );
    }

    @Bean
    public UserDetailsService inMemoryUserDetailsService() {
        final UserDetails adminUser = User.builder()
                .username("admin@eksplaProblem.com")
                .password("{noop}admin")  // look PasswordEncoderFactories
                .roles("ADMIN", "EMPLOYEE")
                .build();
        final UserDetails userUser = User.builder()
                .username("employee@eksplaProblem.com")
                .password("{noop}employee")   // look PasswordEncoderFactories
                .roles("EMPLOYEE")
                .build();

        return new InMemoryUserDetailsManager(adminUser, userUser);
    }
}
