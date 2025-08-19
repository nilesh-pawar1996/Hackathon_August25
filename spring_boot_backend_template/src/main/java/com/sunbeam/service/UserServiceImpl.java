package com.sunbeam.service;

import java.util.Optional;

import org.springframework.stereotype.Service;


import com.sunbeam.entities.User;

import com.sunbeam.repository.UserRepository;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class UserServiceImpl implements UserService {
	
	
	private final UserRepository user; 
	
	private final PasswordEncoder passwordEncoder;
	
	public User addU(User u) {
		u.setPassword(passwordEncoder.encode(u.getPassword()));
		return user.save(u);
	}

    public Optional<User> findByEmail(String email) {
        return user.findByEmail(email);
    }

}