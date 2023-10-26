package com.rgbmovie.config;


import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
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
import org.springframework.security.web.access.channel.ChannelProcessingFilter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.rgbmovie.security.JwtTokenFilter;

import java.io.IOException;
import java.util.Arrays;


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
        http.csrf(AbstractHttpConfigurer::disable).cors(AbstractHttpConfigurer::disable).authorizeHttpRequests((auth) -> auth.requestMatchers("/api/auth", "/api/theater/**", "/api/movie/**", "/api/signup", "/docs/**", "/api/screening/**").permitAll());
        // Filter for api only
        http.authorizeHttpRequests((auth) -> auth.requestMatchers("/api/**")).addFilterBefore(new CorsFilter(), ChannelProcessingFilter.class)
                .addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class).csrf(AbstractHttpConfigurer::disable).cors(AbstractHttpConfigurer::disable).sessionManagement((session) -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        //For request require auth
        http.authorizeHttpRequests((auth) -> auth.requestMatchers("/users/**", "/theater/**", "/role/**", "/movie/**", "/director/**", "/casting/**", "/cast/**", "/home/**", "/customer/**")
                .hasAnyRole("ADMIN").anyRequest().authenticated()).formLogin(form -> form.loginPage("/auth/login").loginProcessingUrl("/auth/login").permitAll()
                .usernameParameter("username").passwordParameter("password").defaultSuccessUrl("/home", true)
                .failureUrl("/auth/login?error=true")).rememberMe(rememberMe ->
                rememberMe.key("uniqueAndSecret").tokenValiditySeconds(86400).userDetailsService(userDetailsService())).sessionManagement((session) -> session.sessionCreationPolicy(SessionCreationPolicy.ALWAYS)).exceptionHandling(exp -> exp.accessDeniedPage("/403"));
        http.logout(l -> l.logoutUrl("/auth/logout").logoutSuccessUrl("/auth/login"));
        return http.build();
    }

//    @Bean
//    public CorsConfigurationSource corsConfigurationSource() {
//        final CorsConfiguration configuration = new CorsConfiguration();
//        configuration.setAllowedOrigins(Arrays.asList("*"));
//        configuration.setAllowedMethods(Arrays.asList("HEAD",
//                "GET", "POST", "PUT", "DELETE", "PATCH"));
//        // setAllowCredentials(true) is important, otherwise:
//        // The value of the 'Access-Control-Allow-Origin' header in the response must not be the wildcard '*' when the request's credentials mode is 'include'.
//        configuration.setAllowCredentials(true);
//        // setAllowedHeaders is important! Without it, OPTIONS preflight request
//        // will fail with 403 Invalid CORS request
//        configuration.setAllowedHeaders(Arrays.asList("Authorization", "Cache-Control", "Content-Type"));
//        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", configuration);
//        return source;
//    }


    //    @Component
//    public static class CorsConfig {
//        @Bean
//        public WebMvcConfigurer corsConfigurer() {
//            return new WebMvcConfigurer() {
//                @Override
//                public void addCorsMappings(@NotNull CorsRegistry registry) {
//                    registry.addMapping("/**")
//                            .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
//                            .allowedOrigins("*")
//                            .allowedHeaders("*").exposedHeaders("*");
//                }
//            };
//        }
//    }
    @Component
    @Order(Ordered.HIGHEST_PRECEDENCE)
    public static class CorsFilter extends OncePerRequestFilter {
        @Override
        protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
            response.setHeader("Access-Control-Max-Age", "3600");
            response.setHeader("Access-Control-Allow-Headers", "authorization, content-type, xsrf-token");
            response.addHeader("Access-Control-Expose-Headers", "xsrf-token");
            if ("OPTIONS".equals(request.getMethod())) {
                response.setStatus(HttpServletResponse.SC_OK);
            } else {
                filterChain.doFilter(request, response);
            }
        }
    }
}

