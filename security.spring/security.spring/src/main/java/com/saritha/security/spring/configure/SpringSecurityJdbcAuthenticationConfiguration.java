//package com.saritha.security.spring.configure;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configurers.AbstractAuthenticationFilterConfigurer;
//import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.password.NoOpPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.JdbcUserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//
//import javax.sql.DataSource;
//
//@Configuration
//public class SpringSecurityJdbcAuthenticationConfiguration {
//
//private final DataSource dataSource;
//@Autowired
//public SpringSecurityJdbcAuthenticationConfiguration(DataSource dataSource) {
//    this.dataSource = dataSource;
//}
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http
//                .authorizeHttpRequests(authz -> authz
//                        .requestMatchers("/admin").hasRole("ADMIN")
//                        .requestMatchers("/user").hasAnyRole("USER","ADMIN")
//                        .requestMatchers("/", "/h2-console/**").permitAll()
//                        .anyRequest().authenticated()
//                )
//                 .formLogin(form -> form.permitAll())
//                .logout(logout -> logout.permitAll())
//                .csrf(csrf -> csrf.ignoringRequestMatchers("/h2-console/**"))
//                .headers(headers -> headers.frameOptions(frame -> frame.disable()));
//
//        //disable security for h2-console
//       // http.headers().frameOptions().disable();
//
//        return http.build();
//    }
//
//    @Bean
//    public UserDetailsService userDetailsService(DataSource dataSource) {
//        return new JdbcUserDetailsManager(dataSource);
//    }
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return NoOpPasswordEncoder.getInstance();
//    }
//}