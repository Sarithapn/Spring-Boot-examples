//package com.saritha.security.spring.configure;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.password.NoOpPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//    public class SpringSecurityInMemoryConfiguration {
//
//        @Bean
//        public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//            http
//                    .authorizeHttpRequests(authz -> authz
//                            .requestMatchers("/admin").hasRole("ADMIN")
//                            .requestMatchers("/user").hasAnyRole("USER","ADMIN")
//                            .requestMatchers("/").permitAll()
//                            .anyRequest().authenticated()
//                    )
//                    .formLogin(form -> form
//                           // .loginPage("/login")
//                            .permitAll()
//                    )
//                    .logout(logout -> logout.permitAll());
//            return http.build();
//        }
//
//        @Bean
//        public UserDetailsService userDetailsService() {
//            InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//            manager.createUser(User.withUsername("user").password("password").roles("USER").build());
//            manager.createUser(User.withUsername("admin").password("admin").roles("ADMIN").build());
//            return manager;
//        }
//
//        @Bean
//        public PasswordEncoder passwordEncoder() {
//            return NoOpPasswordEncoder.getInstance();
//        }
//}
