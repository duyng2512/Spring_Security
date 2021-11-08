package com.dev.api.entity;

import com.dev.api.entity.EnumFactory.EncryptionAlgorithm;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.security.core.userdetails.User;

import javax.persistence.*;

@Entity
@Table(name = "authorities")
@Data
public class AuthorityEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne
    @JoinColumn(name = "user")
    private UserEntity user;

}
