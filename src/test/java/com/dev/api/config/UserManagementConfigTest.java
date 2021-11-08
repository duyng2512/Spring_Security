package com.dev.api.config;

import com.dev.api.entity.EnumFactory;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.Assert;

import static org.junit.jupiter.api.Assertions.*;

class UserManagementConfigTest {

    @Test
    void userDetailsService() {
        EnumFactory.EncryptionAlgorithm encryptionAlgorithm = EnumFactory.EncryptionAlgorithm.BCRYPT;
        System.out.println(encryptionAlgorithm.toString());
    }

    @Test
    void passwordEncoder() {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encoded = passwordEncoder.encode("12345");
        System.out.println("Encoded password :" + encoded);
        Assert.isTrue(passwordEncoder.matches("12345", encoded));
    }

}