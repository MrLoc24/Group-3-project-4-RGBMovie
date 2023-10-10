package com.rgbmovie.config;


import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.rgbmovie.security.JwtTokenFilter;


@Configuration
@EnableWebSecurity
@EnableMethodSecurity(jsr250Enabled = true, prePostEnabled = true, securedEnabled = true) // Setup for role annotation
public class WebSecurityConfig implements WebMvcConfigurer {

    @Autowired
    private JwtTokenFilter jwtTokenFilter;

    @Bean
    UserDetailsService userDetailsService() {
        return new CustomUserDetailServiceImpl();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    AuthenticationManager authenticationManager() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService());
        provider.setPasswordEncoder(passwordEncoder());
        return new ProviderManager(provider);
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        //For request static and template file
        http.authorizeHttpRequests((auth) -> auth.requestMatchers("/assets/**", "/error/**").permitAll());
        //For request not require auth
        http.csrf(AbstractHttpConfigurer::disable).cors(AbstractHttpConfigurer::disable).authorizeHttpRequests((auth) -> auth.requestMatchers("/api/auth", "/api/theater/**", "/api/movie/**", "/api/signup", "/docs/**").permitAll());
        // Filter for api only
        http.csrf(AbstractHttpConfigurer::disable).cors(AbstractHttpConfigurer::disable).authorizeHttpRequests((auth) -> auth.requestMatchers("/api/**").authenticated())
                .addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class).sessionManagement((session) -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        //For request require auth
        http.authorizeHttpRequests((auth) -> auth.requestMatchers("/users/**", "/theater/**", "/role/**", "/movie/**", "/director/**", "/casting/**", "/cast/**", "/home/**", "/customer/**")
                .hasAnyRole("ADMIN").anyRequest().authenticated()).formLogin(form -> form.loginPage("/auth/login").loginProcessingUrl("/auth/login").permitAll()
                .usernameParameter("username").passwordParameter("password").defaultSuccessUrl("/home", true)
                .failureUrl("/auth/login?error=true")).rememberMe(rememberMe ->
                rememberMe.key("uniqueAndSecret").tokenValiditySeconds(86400).userDetailsService(userDetailsService())).sessionManagement((session) -> session.sessionCreationPolicy(SessionCreationPolicy.ALWAYS)).exceptionHandling(exp -> exp.accessDeniedPage("/403"));
        http.logout(l -> l.logoutUrl("/auth/logout").logoutSuccessUrl("/auth/login"));
        return http.build();
    }

    @Component
    public static class CorsConfig {
        @Bean
        public WebMvcConfigurer corsConfigurer() {
            return new WebMvcConfigurer() {
                @Override
                public void addCorsMappings(CorsRegistry registry) {
                    registry.addMapping("/api/**")
                            .allowedMethods(CorsConfiguration.ALL)
                            .allowedHeaders(CorsConfiguration.ALL)
                            .allowedOriginPatterns(CorsConfiguration.ALL);
                }
            };
        }
    }


}
