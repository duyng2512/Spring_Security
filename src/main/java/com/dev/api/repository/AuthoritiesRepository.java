package com.dev.api.repository;

import com.dev.api.entity.AuthorityEntity;
import com.dev.api.entity.UserEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthoritiesRepository extends PagingAndSortingRepository<AuthorityEntity, Long> {
}
