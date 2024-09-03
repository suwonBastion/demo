package com.example.demo.repository;

import com.example.demo.entity.Token;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface TokenRepo extends CrudRepository<Token, String> {
    Optional<Token> findByRefreshToken(String refreshToken);
}
