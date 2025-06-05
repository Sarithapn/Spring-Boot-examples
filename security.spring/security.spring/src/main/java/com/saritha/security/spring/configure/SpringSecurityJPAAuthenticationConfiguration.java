//package com.saritha.security.spring.configure;
//
//import com.saritha.security.spring.repository.UserRepository;
//import com.saritha.security.spring.service.JpaUserDetailsService;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.NoOpPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//public class SpringSecurityJPAAuthenticationConfiguration {
//    @Bean
//    public UserDetailsService userDetailsService(UserRepository userRepository) {
//        return new JpaUserDetailsService(userRepository);
//    }
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http, UserDetailsService userDetailsService) throws Exception {
//        http
//                .authorizeHttpRequests(authz -> authz
//                        .requestMatchers("/h2-console/**").permitAll()
//                        .requestMatchers("/admin").hasRole("ADMIN")
//                        .requestMatchers("/user").hasAnyRole("USER", "ADMIN")
//                        .requestMatchers("/").permitAll()
//                        .anyRequest().authenticated()
//                )
//                .userDetailsService(userDetailsService)
//                .formLogin(form -> form.permitAll())
//                .logout(logout -> logout.permitAll())
//                .csrf(csrf -> csrf.ignoringRequestMatchers("/h2-console/**"))
//                .headers(headers -> headers.frameOptions(frame -> frame.disable()));
//        return http.build();
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return NoOpPasswordEncoder.getInstance();
//    }
//}