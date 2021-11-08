package com.dev.api.config;

import com.dev.api.entity.EnumFactory.*;
import com.dev.api.model.CustomUserDetails;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    private final CustomUserServicesDetails userDetailsService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final SCryptPasswordEncoder sCryptPasswordEncoder;

    public CustomAuthenticationProvider(CustomUserServicesDetails userDetailsService,
                                        BCryptPasswordEncoder bCryptPasswordEncoder,
                                        SCryptPasswordEncoder sCryptPasswordEncoder) {
        this.userDetailsService = userDetailsService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.sCryptPasswordEncoder = sCryptPasswordEncoder;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String authName = authentication.getName();
        String authPassword = authentication.getCredentials().toString();
        CustomUserDetails userDetails = userDetailsService.toCustomUserDetails(authentication.getName());
        EncryptionAlgorithm algorithm = userDetails.getAlgorithm();

        switch (algorithm) {
            case BCRYPT: {
                return checkPassword(userDetails, authPassword, bCryptPasswordEncoder);
            }
            case SCRYPT:{
                return checkPassword(userDetails, authPassword, sCryptPasswordEncoder);
            }
        }

        return null;

    }

    private Authentication checkPassword(CustomUserDetails userDetails, String rawPassword, PasswordEncoder encoder){
        if (encoder.matches(rawPassword, userDetails.getPassword())){
            return new UsernamePasswordAuthenticationToken(userDetails.getUsername(), userDetails.getPassword(), userDetails.getAuthorities());
        }
        throw new BadCredentialsException("Wrong Username or password");
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(aClass);
    }
}
