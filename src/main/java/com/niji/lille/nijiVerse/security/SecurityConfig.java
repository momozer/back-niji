//package com.niji.lille.nijiVerse.security;
//import com.niji.lille.nijiVerse.services.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
//import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//import javax.sql.DataSource;
//
//@Configuration
//@EnableGlobalAuthentication
//public class SecurityConfig extends GlobalAuthenticationConfigurerAdapter {
//
//    @Autowired
//    private UserService userService;
//    @Autowired
//    private DataSource dataSource;
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//
//    @Override
//    public void init(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(auth.getDefaultUserDetailsService()).passwordEncoder(passwordEncoder());
//    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.jdbcAuthentication()
//                .dataSource(dataSource)
//                .usersByUsernameQuery("SELECT username, mot_passe, actif FROM user WHERE username=?")
//                .authoritiesByUsernameQuery("SELECT username, id_role FROM user WHERE username=?")
//                .rolePrefix("");
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//}
