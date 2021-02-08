package com.traudat.traudatgroup.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.traudat.traudatgroup.models.User;
import com.traudat.traudatgroup.repositories.ProfileRepository;
import com.traudat.traudatgroup.services.ProfileService;

@Service
public class ProfileServiceImpl implements ProfileService{

	@Autowired 
	private BCryptPasswordEncoder encoder;
	
	@Autowired
	private ProfileRepository profileRepository;
	
	@Override
	public User save(User user) {
		user.setPassword(encoder.encode(user.getPassword()));
		
		return profileRepository.save(user);
	}

}
