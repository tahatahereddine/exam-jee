package com.ensam.donation.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

@Configuration
public class SecurityConfig {
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(requests -> requests
                        .requestMatchers("/ajouterAction", "/voirDons", "/dons").authenticated()
                        .requestMatchers("/index", "/", "/actions").permitAll())
                .formLogin(formLogin -> {
                    formLogin.defaultSuccessUrl("/index", true);
                })
                .httpBasic(Customizer.withDefaults());
        return http.build();
    }
}
