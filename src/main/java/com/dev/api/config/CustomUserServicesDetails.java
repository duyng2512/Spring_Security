package com.dev.api.config;

import com.dev.api.entity.UserEntity;
import com.dev.api.model.CustomUserDetails;
import com.dev.api.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CustomUserServicesDetails implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserServicesDetails(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<UserEntity> optional = userRepository.findUserEntityByUserName(s);
        if (optional.isEmpty()){
            throw new UsernameNotFoundException(s);
        }
        return new CustomUserDetails(optional.get());
    }

    public CustomUserDetails toCustomUserDetails(String s) {
        Optional<UserEntity> optional = userRepository.findUserEntityByUserName(s);
        if (optional.isEmpty()){
            throw new UsernameNotFoundException("User name " + s + " not found");
        }
        return new CustomUserDetails(optional.get());
    }
}
