package com.traudat.traudatgroup.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.traudat.traudatgroup.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	Optional<User> findUserByUsername(String username);
}
