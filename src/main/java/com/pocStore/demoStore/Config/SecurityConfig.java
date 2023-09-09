package com.pocStore.demoStore.Config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

@Configuration
public class SecurityConfig {
    @Autowired
    private AuthEntryPoint point;
    @Autowired
    private JwtAuthenticationFilter filter;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        RequestMatcher requestMatcher = new AntPathRequestMatcher("/home/**");
        RequestMatcher requestMatcherauth = new AntPathRequestMatcher("/auth/login");
        RequestMatcher requestMatcherauth1 = new AntPathRequestMatcher("/swagger-ui");
        RequestMatcher requestMatcherauth2 = new AntPathRequestMatcher("/v3/**");

        http
                .csrf(csrf -> csrf.disable())
                .cors(cors -> cors.disable())
                .authorizeHttpRequests(request -> request.requestMatchers(requestMatcher).authenticated()
                .requestMatchers(requestMatcherauth).permitAll()
                .requestMatchers(requestMatcherauth1).permitAll()
                .requestMatchers(requestMatcherauth2).permitAll()
                .anyRequest()
                .authenticated()).exceptionHandling(ex -> ex.authenticationEntryPoint(point))
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration builder) throws Exception {
        return builder.getAuthenticationManager();
    }


}