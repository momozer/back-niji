package com.niji.lille.nijiVerse.security;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@Configuration
@EnableGlobalMethodSecurity(
        // securedEnabled = true,
        // jsr250Enabled = true;
        prePostEnabled = true)
public class WebSecurityConfig {// extends WebSecurityConfigurerAdapter  {



}
