package com.dev.api.config;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import static com.dev.api.util.Endpoint.H2_CONSOLE;

@Configuration
public class SecurityWebConfig extends WebSecurityConfigurerAdapter {

    private CustomAuthenticationProvider authenticationProvider;

    @Autowired
    public void setAuthenticationProvider(CustomAuthenticationProvider provider){
        authenticationProvider = provider;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin().defaultSuccessUrl("/main", true);

        http.csrf().disable()
            .headers().frameOptions().sameOrigin().and()
            .authorizeRequests()
            .antMatchers(H2_CONSOLE).permitAll()
            .anyRequest().authenticated();
        /*http.httpBasic()
            .and()
            .formLogin().disable()
            .csrf().disable()
            .headers().frameOptions().sameOrigin()
            .and()
            .cors().disable()
            .authorizeRequests()
            .antMatchers(H2_CONSOLE).permitAll()
            .anyRequest().authenticated();*/
    }


    /*
    @Bean
    InitializingBean initializingBean(){
        return () -> SecurityContextHolder.setStrategyName(SecurityContextHolder.MODE_INHERITABLETHREADLOCAL);
    }*/

    /*
    Alternative way to configure Password Encoder and UserDetailService
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        var authenticationManager = new InMemoryUserDetailsManager();
        var user = User.withUsername("user")
                                 .password("user")
                                 .authorities("READ")
                                 .build();
        authenticationManager.createUser(user);
        PasswordEncoder passwordEncoder = NoOpPasswordEncoder.getInstance();

        auth.userDetailsService(authenticationManager)
            .passwordEncoder(passwordEncoder);
    }*/
}
