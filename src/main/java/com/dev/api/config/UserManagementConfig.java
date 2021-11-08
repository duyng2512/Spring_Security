package com.dev.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

import javax.management.MXBean;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;


public class UserManagementConfig {
    /*
    public UserDetailsService userDetailsService(DataSource dataSource){
        return new JdbcUserDetailsManager(dataSource);
    }*/

    /*
    UserDetailsService userDetailsService(){
        var authenticationManager = new InMemoryUserDetailsManager();
        var user = User.withUsername("user")
                       .password("user")
                       .authorities("READ")
                       .build();
        authenticationManager.createUser(user);
        return authenticationManager;
    }*/


/*    PasswordEncoder passwordEncoder(){
        Authentication authentication = null;
        AuthenticationManager manager = null;
        AuthenticationProvider provider = null;

        Map<String, PasswordEncoder> encoders = new HashMap<>();
        encoders.put("noop", NoOpPasswordEncoder.getInstance());
        encoders.put("bcrypt", new BCryptPasswordEncoder());
        encoders.put("scrypt", new SCryptPasswordEncoder());
        return new DelegatingPasswordEncoder("noop", encoders);

    }*/
}
