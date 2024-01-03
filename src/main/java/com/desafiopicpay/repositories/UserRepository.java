package com.desafiopicpay.repositories;

import com.desafiopicpay.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository <User, Long>{
    // ... buscar usuario por documento utilizando o opcional ele pode ou não trazer o documento caso tenha ele traz caso não tenha ele não traz ...
    Optional<User> findUserByDocument(String document);
    Optional<User> findUserById(Long id);
}
