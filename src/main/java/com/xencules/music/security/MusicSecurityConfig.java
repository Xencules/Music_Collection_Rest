package com.xencules.music.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class MusicSecurityConfig {

    // ADD SUPPORT FOR fdbc ... NO MORE HARDCODED USERS
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

    /*
    BASIC AUTHENTICATION
    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {

        UserDetails john = User.builder()
                .username("john")
                .password("{noop}test123")
                .roles("EMPLOYEE")
                .build();

        UserDetails mary = User.builder()
                .username("mary")
                .password("{noop}test123")
                .roles("EMPLOYEE", "MANAGER")
                .build();

        UserDetails susan = User.builder()
                .username("susan")
                .password("{noop}test123")
                .roles("EMPLOYEE", "MANAGER", "ADMIN")
                .build();

        return new InMemoryUserDetailsManager(john, mary, susan);
    }
*/

}
