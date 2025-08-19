package com.sunbeam.service;

import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.sunbeam.Repository.UserDao;
import com.sunbeam.entities.UserEntity;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class UserServiceImpl implements UserService {
	
	
	private final UserDao user; 
	
	private final PasswordEncoder passwordEncoder;
	
	public UserEntity addU(UserEntity u) {
		u.setPassword(passwordEncoder.encode(u.getPassword()));
		return user.save(u);
	}

    public Optional<UserEntity> findByEmail(String email) {
        return user.findByEmail(email);
    }

}