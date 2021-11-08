package com.dev.api.entity;

import javax.persistence.*;
import com.dev.api.entity.EnumFactory.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Set;

@Entity
@Table(name = "user")
@Data
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username")
    private String userName;

    @Column(name = "password")
    private String password;

    @Column(name = "algorithm")
    @Enumerated(EnumType.STRING)
    private EncryptionAlgorithm encryptionAlgorithm;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany (fetch = FetchType.EAGER, mappedBy = "user")
    Set<AuthorityEntity> authorities;

}
