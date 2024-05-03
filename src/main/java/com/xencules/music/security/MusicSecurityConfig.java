package com.xencules.music.security;

import com.xencules.music.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class MusicSecurityConfig {

    //bcrypt bean definition
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    //authenticationProvider bean definition
    @Bean
    public DaoAuthenticationProvider authenticationProvider(UserService userService) {
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(userService); //set the custom user details service
        auth.setPasswordEncoder(passwordEncoder()); //set the password encoder - bcrypt
        return auth;
    }

    // ADD SUPPORT FOR fdbc ... NO NEED TO HARDCODE USERS
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {
        return new JdbcUserDetailsManager(dataSource);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers(HttpMethod.GET, "music-api/albums").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.GET, "music-api/albums/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST, "music-api/albums").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT, "music-api/albums/**").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE, "music-api/albums/**").hasRole("ADMIN")
        );

        // use HTTP basic auhtentication
        http.httpBasic(Customizer.withDefaults());

        // disable Cross Site Request Forgery (CSRF)
        http.csrf(csrf -> csrf.disable());

        return http.build();

    }
}
